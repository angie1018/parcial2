package com.uniajc.batallas;

/**
 * Clase Arma usada mediante composición en las criaturas.
 * Se usa composición (y no herencia) porque un arma ES un objeto
 * que la criatura TIENE, no algo que la criatura ES.
 */
public class Arma {
    private String nombre;
    private int dañoAdicional;

    public Arma(String nombre, int dañoAdicional) {
        this.nombre = nombre;
        this.dañoAdicional = dañoAdicional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDañoAdicional() {
        return dañoAdicional;
    }

    public void setDañoAdicional(int dañoAdicional) {
        this.dañoAdicional = dañoAdicional;
    }

    /**
     * Realiza un ataque con el arma sobre la criatura objetivo.
     * Aplica daño adicional y delega la defensa al objetivo.
     * @param objetivo La criatura que recibirá el daño del arma.
     */
    public void atacarConArma(Criatura objetivo) {
        System.out.println("  [Arma: " + nombre + "] inflige " + dañoAdicional + " de daño adicional a " + objetivo.getNombre());
        objetivo.defender(dañoAdicional);
    }
}
