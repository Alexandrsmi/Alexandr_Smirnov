package ru.job4j.file.manager;

import ru.job4j.file.manager.operations.CdOperation;
import ru.job4j.file.manager.operations.CopyOperation;
import ru.job4j.file.manager.operations.DirOperation;
import ru.job4j.file.manager.operations.Operation;

import java.io.File;
import java.io.InputStream;


/**
 * @author Aleksandr Smirnov.
 */
public class Manager {

    private static final String DIR_KEY = "dir";
    private static final String CD_KEY = "cd";
    private static final String COPY_KEY = "copy";
    private static final String HELP_KEY = "help";
    private final String homeDir;
    private String currentDir;

    public Manager() {
        this.homeDir = System.getProperty("user.dir");
        this.currentDir = homeDir;
    }

    public class OperationsFactory {
        private Operation[] operations = {
                new DirOperation(),
                new CdOperation(),
                new CopyOperation()
        };

        public Operation getOperation(String operationName) {
            for (Operation operation : operations) {
                if (operationName.equals(operation.getKey())) {
                    return operation;
                }
            }
            return null;
        }
    }

    static public String[] getSplitOperation(String operation) {
        String[] strings = operation.split(" ");
        return strings;
    }

    public String start(File homeDir, File currentFile, String operationName) {
        Operation operation = null;
        OperationsFactory operationsFactory = new OperationsFactory();
        if (operationName.equals(HELP_KEY)) {
            return getMessage(operationName, currentFile, homeDir);
        } else if (operationName.equals(DIR_KEY)) {
            operation = operationsFactory.getOperation(operationName);
            operation.execute(getSplitOperation(operationName), currentFile, homeDir);
            String msg = stringBuilder(currentFile) + "\n\r" + getPathInCommandString(currentFile);
            return msg;
        } else if (getSplitOperation(operationName)[0].equals(CD_KEY) && getSplitOperation(operationName).length > 1) {
            operation = operationsFactory.getOperation(getSplitOperation(operationName)[0]);
            File file = operation.execute(getSplitOperation(operationName), homeDir, currentFile);

            if (currentFile.getPath().equals(file.getPath())) {
                if (operationName.equals("cd ..")) {
                    return getMessage(operationName, currentFile, file);
                }
            } else {
                this.currentDir = file.getPath();
                return operation.getMessage();
//                return file.getPath() + '>';
            }
        } else if (getSplitOperation(operationName)[0].equals(COPY_KEY)) {
            operation = operationsFactory.getOperation(getSplitOperation(operationName)[0]);
            operation.execute(getSplitOperation(operationName), homeDir, currentFile);
            return currentFile.getPath() + '>';
        }
        return getMessage(operationName, currentFile, homeDir);
    }

    public static String getPathInCommandString(File file) {
        return String.format("%s%s", file.getPath(), '>');
    }

    public static String getMessage(String operationName, File first, File second) {
        if (operationName.equals(HELP_KEY)) {
            return "cd каталог - смена каталога.\ndir - отображение списка файлов и каталогов.\ncopy имя_файла путь(каталог в который неообходимо скопировать файл.) - копирование файлов " + "\n" + first.getPath() + '>';
        } else if (operationName.equals("cd ..") && first.getPath().length() == second.getPath().length()) {
            return "Запрещается подниматься выше корневого каталога." + "\n" + first.getPath() + '>';
        } else if (getSplitOperation(operationName)[0].equals(CD_KEY)) {
            return "Системе не удается найти указанный путь." + "\n" + first.getPath() + '>';
        } else
            return "\"" + operationName + "\"" + " " + "не является внутренней или внешней командой,\n исполняемой программой или пакетным файлом." +
                    "\n" + first.getPath() + '>';
    }

    public String stringBuilder(File file) {
        StringBuilder builder = new StringBuilder();
        File[] files = file.listFiles();
        for (int index = 0; index < files.length; index++)
            if (index < files.length - 1) {
                builder.append(files[index].getName()).append("\r\n");
            } else {
                builder.append(files[index].getName());
            }
        String msg = builder.toString();
        byte[] array = msg.getBytes();
        int arraySize = array.length;
        String ms = new String(array);
        return ms;
    }


    public String getHomeDir() {
        return homeDir;
    }

    public String getCurrentDir() {
        return currentDir;
    }
}