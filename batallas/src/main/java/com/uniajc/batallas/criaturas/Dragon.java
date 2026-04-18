package com.uniajc.batallas.criaturas;

import com.uniajc.batallas.Arma;
import com.uniajc.batallas.Criatura;
import com.uniajc.batallas.contratos.Volador;

/**
 * El Dragón implementa la interfaz Volador porque es su habilidad característica.
 * Su ataque es más fuerte (fuerza * 2) y puede además usar un arma mediante composición.
 */
public class Dragon extends Criatura implements Volador {
    private String escamas;
    private Arma arma; // composición: el dragón TIENE un arma, no la hereda

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    public String getEscamas() {
        return escamas;
    }

    public void setEscamas(String escamas) {
        this.escamas = escamas;
    }

    public Arma getArma() {
        return arma;
    }

    /** Equipa un arma al dragón. */
    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println(getNombre() + " ha equipado: " + arma.getNombre());
    }

    /** Desequipa el arma actual del dragón. */
    public void desequiparArma() {
        System.out.println(getNombre() + " ha desequipado: " + arma.getNombre());
        this.arma = null;
    }

    /**
     * El dragón ataca con el doble de su fuerza (fuerza * 2).
     * Si tiene arma equipada, también la usa.
     */
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza() * 2;
        System.out.println(getNombre() + " escupe fuego sobre " + objetivo.getNombre() + " causando " + daño + " de daño");
        objetivo.defender(daño);

        if (arma != null) {
            arma.atacarConArma(objetivo);
        }
    }

    @Override
    public void defender(int daño) {
        // Las escamas reducen el daño en 5 puntos
        int dañoReal = Math.max(0, daño - 5);
        setSalud(getSalud() - dañoReal);
        System.out.println(getNombre() + " se defiende con sus escamas (" + escamas + "). Recibe " + dañoReal + " de daño. Salud restante: " + getSalud());
    }

    @Override
    public void volar() {
        System.out.println(getNombre() + " extiende sus alas y se eleva");
    }

    @Override
    public void aterrizar() {
        System.out.println(getNombre() + " aterriza con un estremecedor golpe al suelo");
    }
}
