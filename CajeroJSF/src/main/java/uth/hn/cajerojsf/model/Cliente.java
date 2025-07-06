package uth.hn.cajerojsf.model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String numeroCuenta;
    private double saldo;
    private String pin;
    private String nombre;

    public Cliente(String numeroCuenta, double saldo, String pin, String nombre) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.pin = pin;
        this.nombre = nombre;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public String getPin() { return pin; }
    public void setPin(String pin) { this.pin = pin; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
