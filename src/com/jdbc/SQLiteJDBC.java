package com.jdbc;

import java.sql.*;

public class SQLiteJDBC {

    public static void main( String args[] ) {
        Connection c = null; // соединение
        Statement stmt = null; // поток

        try {
            Class.forName("org.sqlite.JDBC"); // формат бд
            c = DriverManager.getConnection("jdbc:sqlite:test.db"); // выбираем бд из фалов и соединяемся
            System.out.println("Открыта БД, успех!");

            stmt = c.createStatement(); //бд в поток
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)"; // создание таблицы в sql
            stmt.executeUpdate(sql); // обновить бд
            stmt.close(); // закрыть
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() ); // ошибка
            System.exit(0);
        }
        System.out.println("Таблица создана, успех!");
    }
}
