package com.spring2102.Dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Alumno {

    private int id;
    private String name;
    private String apellido;
    private int edad;
    
}
