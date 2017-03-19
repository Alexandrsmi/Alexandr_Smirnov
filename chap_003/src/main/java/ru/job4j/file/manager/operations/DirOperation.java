package ru.job4j.file.manager.operations;

import java.io.File;

/**
 * @author Aleksandr Smirnov.
 */
public class DirOperation implements Operation {
    @Override
    public String getKey() {
        return "dir";
    }

    @Override
    public File execute(String operation[], File homeDir, File currentDir) {
        return currentDir;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
