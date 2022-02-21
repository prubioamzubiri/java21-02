package com.spring2102.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import com.spring2102.Dominio.Alumno;

import org.junit.jupiter.api.Test;

public class MySQLDBTest {

    @Test
    void testContrutor() throws SQLException {

        MySQLDB db = new MySQLDB();
        //db.init();
        db.close();

    }

    @Test
    void testFunctions() throws SQLException {

        MySQLDB db = new MySQLDB();
        Alumno a = new Alumno(4,"a","b",2);
        db.addAlumno(a);

        Alumno b = db.getAlumno(4);
        assertEquals(a.getId(), b.getId());
        assertEquals(a.getEdad(), b.getEdad());
        assertEquals(a.getName(), b.getName());

        db.deleteAlumno(4);
        db.close();


    }
}
