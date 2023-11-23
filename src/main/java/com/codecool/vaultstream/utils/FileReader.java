package com.codecool.vaultstream.utils;


import java.util.List;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class FileReader {
    private final List<String> content;
    public FileReader(String filePath) {
        this.content = readFileInList(filePath);
    }

    private static List<String> readFileInList(String filePath){
        List<String> content;
        Path path = Paths.get(filePath);
        try {
            content = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

    public List<String> getFileContentInList(){
        return content;
    }
}
