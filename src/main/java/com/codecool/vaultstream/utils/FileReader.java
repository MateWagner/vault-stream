package com.codecool.vaultstream.utils;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader implements IFileReader {
    public List<String> readFileLinesInList(String filePath) {
        List<String> lineList;
        Path path = Paths.get(filePath);
        try {
            lineList = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Invalid file path: " + path.toUri());
        }
        return lineList;
    }
}
