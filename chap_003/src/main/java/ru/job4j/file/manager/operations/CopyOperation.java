package ru.job4j.file.manager.operations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Aleksandr Smirnov.
 */
public class CopyOperation implements Operation {
    @Override
    public String getKey() {
        return "copy";
    }

    @Override
    public File execute(String[] operation, File homeDir, File currentDir) {
        File newFile = currentDir;
        homeDir = new File(homeDir.getPath() + "\\" + operation[1]);
        currentDir = new File(operation[2] + "\\" + operation[1]);
        try {
            Files.copy(homeDir.toPath(), currentDir.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }

    @Override
    public String getMessage() {
        return null;
    }
}