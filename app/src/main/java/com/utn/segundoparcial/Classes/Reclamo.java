package com.utn.segundoparcial.Classes;

public class Reclamo {

    private String Cliente;
    private String Detalle;
    private String Logo;
    private String ID;
    private Boolean Estado;

    public Reclamo() {
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        Estado = estado;
    }
}
