package uth.hn.cajerojsf.bean;

import uth.hn.cajerojsf.model.Cliente;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("cajeroBean")
@SessionScoped
public class CajeroBean implements Serializable {
    private List<Cliente> clientes = new ArrayList<>();
    private String numeroCuenta;
    private String pin;
    private double monto;
    private String mensaje;
    private Cliente clienteActual;

    public CajeroBean() {

        clientes.add(new Cliente("1001", 2500, "1234", "Juan Pérez"));
        clientes.add(new Cliente("1002", 1000, "4321", "Ana López"));
        clientes.add(new Cliente("1003", 5500, "5678", "Carlos Ruiz"));
        clientes.add(new Cliente("1004", 700, "9876", "María Gómez"));
        clientes.add(new Cliente("1005", 3200, "2468", "Luis Ortega"));
    }

    private Cliente buscarCliente() {
        for (Cliente c : clientes) {
            if (c.getNumeroCuenta().equals(numeroCuenta) && c.getPin().equals(pin)) {
                return c;
            }
        }
        return null;
    }

    public void retirar() {
        clienteActual = buscarCliente();
        if (clienteActual == null) {
            mensaje = "PIN o cuenta inválida.";
            limpiarCampos();
        } else if (monto <= 0) {
            mensaje = "El monto debe ser mayor a cero.";
            limpiarCampos();
        } else if (monto > clienteActual.getSaldo()) {
            mensaje = "No hay saldo suficiente.";
            limpiarCampos();
        } else {
            clienteActual.setSaldo(clienteActual.getSaldo() - monto);
            mensaje = "Retiro exitoso. Nuevo saldo: L " + clienteActual.getSaldo();
            limpiarCampos();
        }
    }

    public void depositar() {
        clienteActual = buscarCliente();
        if (clienteActual == null) {
            mensaje = "PIN o cuenta inválida.";
            limpiarCampos();
        } else if (monto <= 0) {
            mensaje = "El monto debe ser mayor a cero.";
            limpiarCampos();
        } else {
            clienteActual.setSaldo(clienteActual.getSaldo() + monto);
            mensaje = "Depósito exitoso. Nuevo saldo: L " + clienteActual.getSaldo();
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        this.numeroCuenta = "";
        this.pin = "";
        this.monto = 0;
    }
    public void limpiarMensaje() {
        this.mensaje = "";
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }

    public String getPin() { return pin; }
    public void setPin(String pin) { this.pin = pin; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}
