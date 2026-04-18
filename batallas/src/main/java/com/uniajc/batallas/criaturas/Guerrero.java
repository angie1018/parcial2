package com.uniajc.batallas.criaturas;

import com.uniajc.batallas.Arma;
import com.uniajc.batallas.Criatura;

/**
 * El Guerrero ataca con su espada (su fuerza base).
 * Puede equipar un arma adicional mediante composición para potenciar su ataque.
 */
public class Guerrero extends Criatura {
    private String tipoEspada;
    private Arma arma; // composición: el guerrero TIENE un arma, no la hereda

    public Guerrero(String nombre, int salud, int fuerza, String tipoEspada) {
        super(nombre, salud, fuerza);
        this.tipoEspada = tipoEspada;
    }

    public String getTipoEspada() {
        return tipoEspada;
    }

    public void setTipoEspada(String tipoEspada) {
        this.tipoEspada = tipoEspada;
    }

    public Arma getArma() {
        return arma;
    }

    /** Equipa un arma al guerrero. */
    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println(getNombre() + " ha equipado: " + arma.getNombre());
    }

    /** Desequipa el arma actual del guerrero. */
    public void desequiparArma() {
        System.out.println(getNombre() + " ha desequipado: " + arma.getNombre());
        this.arma = null;
    }

    /**
     * El guerrero ataca con su espada causando daño igual a su fuerza.
     * Si tiene un arma equipada, también la usa en el mismo turno.
     */
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza();
        System.out.println(getNombre() + " ataca con su " + tipoEspada + " a " + objetivo.getNombre() + " causando " + daño + " de daño!");
        objetivo.defender(daño);

        if (arma != null) {
            arma.atacarConArma(objetivo);
        }
    }

    @Override
    public void defender(int daño) {
        // El guerrero bloquea con su escudo, reduciendo el daño en 3
        int dañoReal = Math.max(0, daño - 3);
        setSalud(getSalud() - dañoReal);
        System.out.println(getNombre() + " bloquea con su escudo. Recibe " + dañoReal + " de daño. Salud restante: " + getSalud());
    }
}
