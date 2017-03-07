package com.ksc.firs.example;

import java.sql.*;

/**
 * Created by Probook on 2017-03-07.
 */
public class MyFirstConnectionExample {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ksc", "root", "");
            if (connection!=null){
                System.out.println("Connected!!!");
                getStudents(connection);
            }
        } catch (SQLException e) {
            System.out.println("Connectio to DB failed!!!"+e);;
        }
    }
    private static void getStudents(Connection connection){

        try {
            Statement st = connection.createStatement();
            ResultSet resultSet=st.executeQuery("select * from students");
            while(resultSet.next()){

                System.out.println(" id >> " + resultSet.getInt(1)
                        + " username >> " + resultSet.getString("name")
                + " surname >> " + resultSet.getString("surname")
                        + " phone >> "+ resultSet.getString(4)
                + " email >> "+ resultSet.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
