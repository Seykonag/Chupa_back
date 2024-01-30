package com.chupagames.game.controllers;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

import static com.chupagames.game.GameApplication.dataBaseController;

@RestController
public class RequestController {
    @GetMapping("/balanceValue/{userId}")
    public Balance balance(@PathVariable String userId)
            throws SQLException {
        try {
            return dataBaseController.balanceValue(userId);
        } catch (SQLException exc) {
            System.out.println("Error, database balance!");
            throw exc;
        }
    }

    @PostMapping("/editValue")
    public void editBalance(@RequestBody String[] input)
            throws SQLException {
        try {
            dataBaseController.editBalance(input[0], Integer.parseInt(input[1]));
        } catch (SQLException exc) {
            System.out.println("Error edit database!");
            throw exc;
        }
    }
}
