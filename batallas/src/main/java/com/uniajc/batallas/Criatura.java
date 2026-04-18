package com.uniajc.batallas;

/**
 * Clase abstracta base para todas las criaturas del juego.
 * Define los atributos comunes (nombre, salud, fuerza) y los métodos
 * abstractos que cada criatura concreta debe implementar según su tipo.
 */
public abstract class Criatura {
    private String nombre;
    private int salud;
    private int fuerza;

    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * Ataca a otra criatura. Cada subclase define cómo ataca.
     * @param objetivo La criatura que recibe el ataque.
     */
    public abstract void atacar(Criatura objetivo);

    /**
     * Reduce la salud de la criatura según el daño recibido.
     * @param daño La cantidad de daño recibido (equivale a la fuerza del atacante).
     */
    public abstract void defender(int daño);

    /**
     * Indica si la criatura sigue con vida.
     * @return true si la salud es mayor a 0.
     */
    public boolean estaViva() {
        return salud > 0;
    }

    /**
     * Imprime los atributos básicos de la criatura por consola.
     * Útil para depuración y visualización del estado.
     */
    public void imprimir() {
        System.out.println("Nombre: " + nombre + " | Salud: " + salud + " | Fuerza: " + fuerza);
    }
}
