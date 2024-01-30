package com.chupagames.game.models;

import com.chupagames.game.controllers.Balance;

import java.sql.*;

public class Shaper {
    private final Connection connection;

    private static final String URL = "jdbc:sqlite:" +
            "C://Users/realy/Desktop/Chupa games project/" +
            "ChupiGames/data/chupa_games.db";

    public Shaper() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(URL);
    }

    public Balance balanceValue(String userId) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            ResultSet balance = statement.executeQuery(
                    "SELECT * FROM profile WHERE user_id='" + userId + "'"
            );
            return new Balance(balance.getString(2));
        } catch (SQLException exc) {
            System.out.println("Balance value error" + exc);
            throw exc;
        }
    }

    public void editBalance(String userId, int sum) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "UPDATE profile SET balance = (balance + " + sum + ") WHERE user_id == '" + userId + "'"
            );
            System.out.println("Commit successful!");
        } catch (SQLException exc) {
            System.out.println("Edit balance database error!" + exc);
            throw exc;
        }
    }

    public void closeDataBase() throws SQLException {
        try {
            connection.close();
        } catch (SQLException exc) {
            System.out.println("Error close database!" + exc);
            throw exc;
        }
    }
}
