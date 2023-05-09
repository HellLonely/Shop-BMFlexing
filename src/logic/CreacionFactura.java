/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author a22ricardova
 */
public class CreacionFactura {
    private int precioInicial;
    private int precioTotal;
    private int idCliente;
    private int idEmpleado;
    private String tipo;

    public CreacionFactura(int precioInicial, String tipo) {
        this.precioInicial = precioInicial;
        this.tipo = tipo;
        this.precioTotal=0;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
    
}
