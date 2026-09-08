package com.rhsoft.controlvisitas;

public class visita {
        String nombre, empresa, proposito, dni;

        // Constructor
        public visita(String nombre, String empresa, String proposito, String dni) {
            this.nombre = nombre;
            this.empresa = empresa;
            this.proposito = proposito;
            this.dni = dni;
        }

        // Getters
        public String getNombre() { return nombre; }
        public String getEmpresa() { return empresa; }
        public String getProposito() { return proposito; }
        public String getDni() { return dni; }


}
