package com.gm.mundopc;

public class Mouse extends DispositivoEntrada{
    private int idMouse;
    private static int contadorMouse;

    public Mouse(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.idMouse = ++Mouse.contadorMouse;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "idMouse=" + idMouse +
                "} " + super.toString();
    }

    public int getIdMouse() {
        return idMouse;
    }
}
