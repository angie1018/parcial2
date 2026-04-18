package com.uniajc.batallas;

import com.uniajc.batallas.criaturas.Dragon;
import com.uniajc.batallas.criaturas.Guerrero;
import com.uniajc.batallas.criaturas.Mago;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para el sistema de batallas.
 * Se usa JUnit 5 (Jupiter) declarado en el pom.xml.
 */
public class BatallaTest {

    private Dragon dragon;
    private Mago mago;
    private Guerrero guerrero;

    @BeforeEach
    public void setUp() {
        dragon = new Dragon("Ignis", 150, 30, "Escamas de Obsidiana");
        mago = new Mago("Gandalf", 100, 25, "Bola de Fuego");
        guerrero = new Guerrero("Thor", 120, 20, "Espada Larga");
    }

    @Test
    public void testCriaturaViva() {
        assertTrue(dragon.estaViva());
        assertTrue(mago.estaViva());
        assertTrue(guerrero.estaViva());
    }

    @Test
    public void testDefenderReduceSalud() {
        int saludInicial = mago.getSalud();
        mago.defender(20);
        assertEquals(saludInicial - 20, mago.getSalud());
    }

    @Test
    public void testDragonDefiendeConEscamas() {
        // El dragón reduce el daño en 5
        int saludInicial = dragon.getSalud();
        dragon.defender(20);
        assertEquals(saludInicial - 15, dragon.getSalud()); // 20 - 5 = 15
    }

    @Test
    public void testGuerreroDefiendeConEscudo() {
        // El guerrero reduce el daño en 3
        int saludInicial = guerrero.getSalud();
        guerrero.defender(20);
        assertEquals(saludInicial - 17, guerrero.getSalud()); // 20 - 3 = 17
    }

    @Test
    public void testCriaturaMuere() {
        mago.defender(200); // daño mayor a la salud
        assertFalse(mago.estaViva());
    }

    @Test
    public void testComposicionArma() {
        Arma espada = new Arma("Espada Mágica", 10);
        guerrero.equiparArma(espada);
        assertNotNull(guerrero.getArma());
        assertEquals("Espada Mágica", guerrero.getArma().getNombre());

        guerrero.desequiparArma();
        assertNull(guerrero.getArma());
    }

    @Test
    public void testDragonAtacaConDobleFuerza() {
        int saludAntes = guerrero.getSalud();
        dragon.atacar(guerrero);
        // Dragon fuerza=30, ataca con 60. Guerrero reduce 3 => recibe 57
        assertEquals(saludAntes - 57, guerrero.getSalud());
    }
}
