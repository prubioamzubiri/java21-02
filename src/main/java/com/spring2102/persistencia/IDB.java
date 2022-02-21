package com.spring2102.persistencia;

import com.spring2102.Dominio.Alumno;

public interface IDB {


    public void init();

    public void addAlumno(Alumno a);

    public Alumno getAlumno(int ide);

    public void deleteAlumno(int ide);
    
}
