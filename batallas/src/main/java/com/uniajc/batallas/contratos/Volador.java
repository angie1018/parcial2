package com.uniajc.batallas.contratos;

/**
 * Interfaz que define el comportamiento de las criaturas que pueden volar.
 * Se usa una interfaz porque volar es una habilidad opcional, no una
 * característica base de toda criatura.
 */
public interface Volador {
    void volar();
    void aterrizar();
}
