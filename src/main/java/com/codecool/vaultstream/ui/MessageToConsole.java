package com.codecool.vaultstream.ui;

public class MessageToConsole {
    private static final String RED_CHARACTER_COLOR = "\u001B[31m";
    private static final String GREEN_CHARACTER_COLOR = "\u001B[32m";
    private static final String RESET_CHARACTER_COLOR = "\u001B[0m";

    public static void errorMessage(String message) {
        System.out.println(RED_CHARACTER_COLOR + message + RESET_CHARACTER_COLOR);
    }

    public static void successMessage(String message) {
        System.out.println(GREEN_CHARACTER_COLOR + message + RESET_CHARACTER_COLOR);
    }
}
