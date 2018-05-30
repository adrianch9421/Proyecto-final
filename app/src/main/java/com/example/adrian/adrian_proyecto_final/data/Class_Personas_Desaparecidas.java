package com.example.adrian.adrian_proyecto_final.data;

public class Class_Personas_Desaparecidas  {
    String nombre_persona;
    String edad;
    String fecha_de_desaparicion;
    String genero;

    public Class_Personas_Desaparecidas(String nombre_persona, String edad, String fecha_de_desaparicion, String genero) {
        this.nombre_persona = nombre_persona;
        this.edad = edad;
        this.fecha_de_desaparicion = fecha_de_desaparicion;
        this.genero = genero;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public String getEdad() {
        return edad;
    }

    public String getFecha_de_desaparicion() {
        return fecha_de_desaparicion;
    }

    public String getGenero() {
        return genero;
    }
}
