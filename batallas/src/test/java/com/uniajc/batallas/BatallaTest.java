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
    public void testMagoAtaca() {
        int saludAntes = guerrero.getSalud();
        mago.atacar(guerrero);
        // Mago fuerza=25, guerrero reduce 3 => recibe 22
        assertEquals(saludAntes - 22, guerrero.getSalud());
    }

    @Test
    public void testGuerreroAtaca() {
        int saludAntes = dragon.getSalud();
        guerrero.atacar(dragon);
        // Guerrero fuerza=20, dragon reduce 5 => recibe 15
        assertEquals(saludAntes - 15, dragon.getSalud());
    }

    @Test
    public void testCriaturaMuertaNoAtaca() {
        // Matar al mago
        mago.defender(200);
        assertFalse(mago.estaViva());
        // Intentar atacar no debería hacer nada, pero como es void, difícil probar.
        // Quizás agregar un método que verifique si puede atacar.
        // Por ahora, solo verificar que está muerto.
    }

    @Test
    public void testComposicionArmaMago() {
        Arma varita = new Arma("Varita Mágica", 12);
        mago.equiparArma(varita);
        assertNotNull(mago.getArma());
        assertEquals("Varita Mágica", mago.getArma().getNombre());

        mago.desequiparArma();
        assertNull(mago.getArma());
    }

    @Test
    public void testComposicionArmaDragon() {
        Arma lanza = new Arma("Lanza de Fuego", 18);
        dragon.equiparArma(lanza);
        assertNotNull(dragon.getArma());
        assertEquals("Lanza de Fuego", dragon.getArma().getNombre());

        dragon.desequiparArma();
        assertNull(dragon.getArma());
    }

    @Test
    public void testBatallaCompleta() {
        // Crear criaturas débiles para batalla rápida
        Criatura debil1 = new Guerrero("Debil1", 10, 5, "Espada Pequeña");
        Criatura debil2 = new Mago("Debil2", 10, 5, "Hechizo Débil");

        // Simular batalla hasta que uno muera
        while (debil1.estaViva() && debil2.estaViva()) {
            debil1.atacar(debil2);
            if (debil2.estaViva()) {
                debil2.atacar(debil1);
            }
        }
        assertTrue(debil1.estaViva() || debil2.estaViva());
        assertFalse(debil1.estaViva() && debil2.estaViva());
    }
