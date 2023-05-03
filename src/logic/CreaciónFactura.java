/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author a22ricardova
 */
public class CreaciónFactura {
    private int precioInicial;
    private int precioTotal;
    private int idCliente;
    private int idEmpleado;
    private String tipo;

    public CreaciónFactura(int precioInicial, String tipo) {
        this.precioInicial = precioInicial;
        this.tipo = tipo;
        this.precioTotal=0;
    }
    
    public int calcularPrecio(int sumaPrecio){
        precioTotal= precioInicial+sumaPrecio+precioTotal;
        return precioTotal;
    }
    
    
}
