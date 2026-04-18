package com.uniajc.batallas.contratos;

/**
 * Interfaz que define el comportamiento de las criaturas con habilidades mágicas.
 * Se usa una interfaz porque la magia es una habilidad específica que no
 * todas las criaturas poseen.
 */
public interface Magico {
    void lanzarHechizo();
    void aprenderHechizo();
}
