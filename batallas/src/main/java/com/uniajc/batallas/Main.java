package com.uniajc.batallas;

import com.uniajc.batallas.criaturas.Dragon;
import com.uniajc.batallas.criaturas.Guerrero;
import com.uniajc.batallas.criaturas.Mago;

public class Main {

    /**
     * Simula una batalla entre dos criaturas por turnos.
     * La batalla continúa hasta que una de las criaturas muere (salud <= 0).
     * Muestra el progreso de la batalla por consola, incluyendo salud después de cada ataque.
     * @param criatura1 Primera criatura en atacar.
     * @param criatura2 Segunda criatura en atacar.
     */
    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("\n========================================");
        System.out.println("  BATALLA: " + criatura1.getNombre() + " VS " + criatura2.getNombre());
        System.out.println("========================================");

        int turno = 1;
        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("\n--- Turno " + turno + " ---");
            criatura1.atacar(criatura2);
            System.out.println("Salud de " + criatura2.getNombre() + ": " + criatura2.getSalud());

            if (criatura2.estaViva()) {
                criatura2.atacar(criatura1);
                System.out.println("Salud de " + criatura1.getNombre() + ": " + criatura1.getSalud());
            }
            turno++;
        }

        System.out.println("\n======== RESULTADO FINAL ========");
        if (criatura1.estaViva()) {
            System.out.println("¡" + criatura1.getNombre() + " ha ganado la batalla!");
            System.out.println("Salud restante: " + criatura1.getSalud());
        } else {
            System.out.println("¡" + criatura2.getNombre() + " ha ganado la batalla!");
            System.out.println("Salud restante: " + criatura2.getSalud());
        }
        System.out.println("=================================\n");
    }

    public static void main(String[] args) {
        // Crear armas con diferentes niveles de daño
        Arma lanzaLlamas = new Arma("Lanza Llamas", 15);
        Arma bastónMágico = new Arma("Bastón Mágico", 10);
        Arma hachaDoble = new Arma("Hacha Doble", 8);

        // Crear criaturas con atributos únicos
        Dragon dragon = new Dragon("Ignis", 150, 30, "Escamas de Obsidiana");
        Mago mago = new Mago("Gandalf", 100, 25, "Bola de Fuego");
        Guerrero guerrero = new Guerrero("Thor", 120, 20, "Espada Larga");

        // Equipar armas a las criaturas para potenciar sus ataques
        dragon.equiparArma(lanzaLlamas);
        mago.equiparArma(bastónMágico);
        guerrero.equiparArma(hachaDoble);

        // Mostrar información inicial de las criaturas
        System.out.println("\n=== CRIATURAS EN COMBATE ===");
        dragon.imprimir();
        mago.imprimir();
        guerrero.imprimir();

        // Demostrar habilidades especiales de las criaturas
        System.out.println("\n=== DEMOSTRACIÓN DE HABILIDADES ESPECIALES ===");
        dragon.volar();
        mago.aprenderHechizo();
        dragon.aterrizar();

        // Simular batallas entre las criaturas
        System.out.println("\n=== INICIANDO BATALLAS ===");
        simularBatalla(dragon, guerrero);
        simularBatalla(mago, guerrero);
    }
}
