package com.uniajc.batallas.criaturas;

import com.uniajc.batallas.Arma;
import com.uniajc.batallas.Criatura;
import com.uniajc.batallas.contratos.Magico;

/**
 * El Mago implementa la interfaz Magico porque ataca mediante hechizos.
 * Su daño base equivale a su fuerza. Puede equipar un arma por composición.
 */
public class Mago extends Criatura implements Magico {
    private String hechizos;
    private Arma arma; // composición: el mago TIENE un arma, no la hereda

    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    public String getHechizos() {
        return hechizos;
    }

    public void setHechizos(String hechizos) {
        this.hechizos = hechizos;
    }

    public Arma getArma() {
        return arma;
    }


    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println(getNombre() + " ha equipado: " + arma.getNombre());
    }

    /** Desequipa el arma actual del mago. */
    public void desequiparArma() {
        System.out.println(getNombre() + " ha desequipado: " + arma.getNombre());
        this.arma = null;
    }

    /**
     * El mago ataca lanzando un hechizo con daño igual a su fuerza
     * Si tiene arma equipada también la usa en el mismo turno para potenciar su ataque
     */
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza();
        lanzarHechizo();
        System.out.println(getNombre() + " lanza " + hechizos + " sobre " + objetivo.getNombre() + " causando " + daño + " de daño!");
        objetivo.defender(daño);

        if (arma != null) {
            arma.atacarConArma(objetivo);
        }
    }

    @Override
    public void defender(int daño) {
        setSalud(getSalud() - daño);
        System.out.println(getNombre() + " intenta esquivar pero recibe " + daño + " de daño. Salud restante: " + getSalud());
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(getNombre() + " prepara el hechizo: " + hechizos);
    }

    @Override
    public void aprenderHechizo() {
        System.out.println(getNombre() + " estudia nuevos hechizos en su grimorio...");
    }
}
