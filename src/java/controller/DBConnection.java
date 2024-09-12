/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
/**
 *
 * @author Siric
 */
import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import model.addclothes;

public class DBConnection{
        public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        addclothes clothes = dbConnection.getclothes("addclothes");
        
        if (clothes != null) {
            System.out.println("clothes found:");
            System.out.println("name: " + clothes.getclothesname());
            System.out.println("clothes: " + clothes.getclothes());
            System.out.println("site: " + clothes.getsite());
            System.out.println("colori: " + clothes.getcolori());
            System.out.println("price: " + clothes.getclothesprice());
        } else {
            System.out.println("clothes not found");
        }
    }


    public boolean insertNewclothes(addclothes clothes) {
    boolean result = false;
    Connection connection = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/uno", 
                "root", "20042547Bam@");

        String query = "INSERT INTO clothes (nameclothes, nature, site, color, price) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, clothes.getclothesname());
        statement.setString(2, clothes.getclothes());
        statement.setString(3, clothes.getsite());
        statement.setString(4, clothes.getcolori());
        statement.setDouble(5, clothes.getclothesprice());

        System.out.println("........SQL: " + statement);

        int i = statement.executeUpdate();
        if (i != 0) {
            result = true;
        }

        statement.close();
        connection.close();
    } catch (ClassNotFoundException | SQLException exception) {
        System.out.println(exception);
    }

    return result;
}


  
    public addclothes getclothes(String nameclothes) {
    addclothes clothes = new addclothes();
    Connection connection = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/uno", 
                "root", "20042547Bam@");

        String query = "SELECT * FROM clothes WHERE nameclothes=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, nameclothes);
        
        System.out.println(">>>>>>>>>> query=" + statement);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            clothes.setclothesname(resultSet.getString("nameclothes").trim());
            clothes.setclothes(resultSet.getString("nature").trim());
            clothes.setsite(resultSet.getString("site").trim());
            clothes.setcolori(resultSet.getString("color").trim());
            clothes.setclothesprice(resultSet.getDouble("price"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (ClassNotFoundException | SQLException exception) {
        System.out.println(exception);
    }
    return clothes;
}
}

 
