package com.chupagames.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chupagames.game.models.Shaper;

import java.sql.SQLException;

@SpringBootApplication
public class GameApplication {
	public static Shaper dataBaseController;

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(GameApplication.class, args);
		try {
			dataBaseController = new Shaper();
		} catch (SQLException | ClassNotFoundException  exc) {
			System.out.println("Error connection");
		}
	}

}
