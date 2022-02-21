package com.spring2102.persistencia;

import java.sql.*;

import com.spring2102.Dominio.Alumno;

public class MySQLDB implements IDB {
    
    Connection conn = null;

    public MySQLDB() throws SQLException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/escuela","root","1234");

            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE   ALUMNO " +
                         "(id INTEGER not NULL, " +
                         " nombre VARCHAR(255), " +
                         " apellido VARCHAR(255), " +
                         " edad INTEGER, " +
                         " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  

    }

    @Override
    public void addAlumno(Alumno a) {
        
        String sql ="INSERT INTO ALUMNO" +
                    "VALUES (" + a.getId() +"," + a.getName() + "," + a.getApellido() + "," + a.getEdad() +");";
        
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
    }

    @Override
    public Alumno getAlumno() {

        String sql = "SELECT id, first, last, age FROM Registration";
        ResultSet rs = null;
        Alumno a = null;

        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);

            rs = stmt.executeQuery(sql);

            while(rs.next()){
                // Retrieve by column name
                
                int id  = rs.getInt("id");
                int age = rs.getInt("edad");
                String first = rs.getString("nombre");
                String last = rs.getString("apellido");
                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);

                a =new Alumno(id, first, last, age);
            }
            rs.close();

            stmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return a;

    }

    public void close()
    {
        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

 



}
