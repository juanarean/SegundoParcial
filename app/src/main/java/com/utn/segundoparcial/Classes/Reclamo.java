package com.utn.segundoparcial.Classes;

public class Reclamo {

    private String Cliente;
    private String Detalle;
    private String Logo;

    public Reclamo() {
    }

    public Reclamo(String cliente, String detalle) {
        Cliente = cliente;
        Detalle = detalle;
        Logo = Logo;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        this.Logo = logo;
    }

    public String getCliente() {
        return Cliente;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public void setDetalle(String detalle) {
        Detalle = detalle;
    }
}
