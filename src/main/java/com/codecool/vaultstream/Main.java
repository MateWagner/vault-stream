package com.codecool.vaultstream;

import com.codecool.vaultstream.utils.FileReader;

public class Main {
    public static void main(String[] args) {
        argumentValidation(args);
        FileReader reader = new FileReader(args[0]);
    }
    private static void argumentValidation(String[] args){
        boolean haveArgument = args.length > 0;
        if (!haveArgument){
            System.out.println("You need to provide the relative file path as the first argument!");
            System.exit(0);
        }
    }
}
