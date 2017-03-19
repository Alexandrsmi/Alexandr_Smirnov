package ru.job4j.file.manager.operations;

import java.io.File;

/**
 * @author Aleksandr Smirnov.
 */
public class CdOperation implements Operation {
    private String message;

    @Override
    public String getKey() {
        return "cd";
    }

    @Override
    public File execute(String[] operation, File homeDir, File currentDir) {
        String folder = operation[1];
        File newDir = null;
        if (operation[1].equals("..")) {
            newDir = new File(currentDir.getParent());
            if (currentDir.getParent().length() > homeDir.length()) {
            } else if (newDir.getPath().length() < homeDir.getPath().length()) {
                newDir = new File(homeDir.getPath());
            }
        } else if (folder != null) {
            newDir = new File(String.format("%s\\%s", currentDir.getPath(), folder));
            if (newDir.isDirectory()) {
                currentDir = newDir;
                return newDir;
            }else {
                newDir = currentDir;
                return newDir;
            }
        }
        return newDir;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
