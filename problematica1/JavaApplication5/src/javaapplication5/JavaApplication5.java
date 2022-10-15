package javaapplication5;

import clases.Cliente;
import clases.Turno;
import clases.Empleado;
import clases.Tematica;

import java.sql.Date;

/**
 *
 * @author JannethGuaman
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente cliente = new Cliente("0604056598", "Janneth", "Guamán", new Date(1991, 10, 26), "janneth.guaman@unl.edu.ec", "0984027353", "Riobamba");
        Empleado empleado = new Empleado("0609955222", "Emilio", "Vera", "Jefe de TIC's", null);
        Tematica tematica = new Tematica("001", "Servicios Bancarios", "ACTIVO", null);

        Turno turno = new Turno("A001", new Date(2022 - 10 - 15), "PENDIENTE", empleado, cliente, tematica);

        System.out.println("*****************************************");
        System.out.println("     PRACTICA EN CLASE  - TURNO          ");
        System.out.println("*****************************************");
        System.out.println("                                         ");
        System.out.println("CLIENTE       : " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("IDENTIFICACION: " + cliente.getIdentificacion());
        System.out.println("DIRECCION     : " + cliente.getDireccion());
        System.out.println("                                         ");
        System.out.println("TURNO N°      : " + turno.getId());
        System.out.println("FECHA         : " + turno.getFecha().toString());
        System.out.println("ESTADO        : " + turno.getEstado());
        System.out.println("TEMATICA      : " + tematica.getNombre());
        System.out.println("                                         ");
        System.out.println("EMPLEADO      : " + empleado.getNombre() + " " + empleado.getApellido());
        System.out.println("CARGO         : " + empleado.getCargo());
        System.out.println("                                         ");
        System.out.println("*****************************************");
        System.out.println("        GRACIAS POR SU ESPERA            ");
        System.out.println("*****************************************");
    }

}
