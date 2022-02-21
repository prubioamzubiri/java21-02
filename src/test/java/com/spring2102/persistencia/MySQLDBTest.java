package com.spring2102.persistencia;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class MySQLDBTest {

    @Test
    void testContrutor() throws SQLException {

        MySQLDB db = new MySQLDB();
        db.close();

    }

    @Test
    void testAddAlumno() {

    }

    @Test
    void testGetAlumno() {

    }
}
