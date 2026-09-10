package com.rhsoft.controlvisitas;

public class visita {
    private String nombre;
    private String empresa;
    private String proposito;
    private String dni;

    public visita(String nombre, String empresa, String proposito, String dni) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.proposito = proposito;
        this.dni = dni;
    }

    public String getNombre() { return nombre; }
    public String getEmpresa() { return empresa; }
    public String getProposito() { return proposito; }
    public String getDni() { return dni; }
}
