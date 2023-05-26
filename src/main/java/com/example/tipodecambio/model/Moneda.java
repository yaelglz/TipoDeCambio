package com.example.tipodecambio.model;

public class Moneda {

    private String moneda;
    private String cambio;

    public Moneda(String moneda, String cambio) {
        this.moneda = moneda;
        this.cambio = cambio;
    }

    public Moneda() {

    }

    // Getters and setters

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    // Getters and setters

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

}
