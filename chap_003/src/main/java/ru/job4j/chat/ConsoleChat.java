package ru.job4j.chat;

import ru.job4j.FileSort;
import ru.job4j.chat.command.*;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 */
public class ConsoleChat {
    /**
     * Хранит фразы и команды.
     */
    private File log;
    /**
     * Файл с фразами.
     */
    private File phrase;

    /**
     * Конструктор класса.
     */
    public ConsoleChat() {
        this.log = log;
        this.phrase = phrase;
    }

    /**
     * Метод доступа к файлам.
     * @throws Exception
     */
    public void pathFile() throws Exception {
        FileInputStream fis;
        Properties properties = new Properties();

        fis = new FileInputStream("chap_003/src/main/resources/app.properties");
        properties.load(fis);

        String logPath = properties.getProperty("log.path");
        String phrasePath = properties.getProperty("phrase.path");
        log = new File(logPath);
        phrase = new File(phrasePath);

    }

    public static void main(String[] args) throws  Exception{
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.pathFile();
        consoleChat.start();
    }
    /**
     * Метод отвечает за работу консольного чата.
     */
    public void start()throws Exception {
        Scanner sc = new Scanner(System.in);
        Command command = null;
        CommandFactory commandFactory = new CommandFactory();
        clearFile(log);
        outer:
        do {
            String commandName = sc.next();
            String str = getPhrase(phrase, generationRandomIntValues(numbersOfLines(phrase)));
            if (commandName.equals("stop")) {
                manipulationWithFile(commandName, log);
                command = commandFactory.getCommand(commandName);
                while (!commandName.equals("start")) {
                    commandName = sc.next();
                    manipulationWithFile(commandName, log);
                }
                continue outer;
            } else if (commandName.equals("exit")) {
                command = commandFactory.getCommand(commandName);
                manipulationWithFile(commandName, log);
            }
            if (!commandName.equals("exit")) {
                System.out.println(str);
                manipulationWithFile(commandName, str, log);
            }
        } while (command == null || !command.isFinish());
    }

    /**
     * Класс содержит команды.
     */
    class CommandFactory {
        private Command[] commands = {
                new StopCommand(),
                new StartCommand(),
                new ExitCommand()
        };

        public Command getCommand(String commandName) {
            for (Command command : commands) {
                if (commandName.equals(command.getName())) {
                    return command;
                }
            }
            return null;
        }
    }

    /**
     * Метод определяет кол-во строк в файле.
     *
     * @param file - файл с фразами.
     * @return - кол-во строк.
     */
    public int numbersOfLines(File file) {
        int number = 0;
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            while ((raf.readLine()) != null) {
                number++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }

    /**
     * Метод дергает случайную строчку из текстового файла.
     *
     * @param file - файл с данными.
     * @return - строку.
     */
    public String getPhrase(File file, int number) {
        String line = null;
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            for (int i = 0; i <= number; i++) {
                line = raf.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    /**
     * Метод генерирует случайное число исходя из кол-ва строк в текстовом файле.
     *
     * @param numbersOfLines - кол-во строк в текстовом файле.
     * @return - номер строки.
     */
    public int generationRandomIntValues(int numbersOfLines) {
        return (int) (Math.random() * numbersOfLines);
    }

    /**
     * Метод записывает строку в файл.
     *
     * @param str
     * @param string1
     * @param file
     */
    public void manipulationWithFile(String str, String string1, File file) {
        final String separator = System.getProperty("line.separator");
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw");) {
            raf.seek(raf.length());
            raf.writeBytes("User" + " " + "-" + " " + str);
            raf.writeBytes(separator);
            raf.writeBytes("PC" + " " + "-" + " " + string1);
            raf.writeBytes(separator);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод записывает команду или строку (если была команда stop).
     *
     * @param str  - команда.
     * @param file - файл.
     */
    public void manipulationWithFile(String str, File file) {
        final String separator = System.getProperty("line.separator");
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw");) {
            raf.seek(raf.length());
            raf.writeBytes("User" + " " + "-" + " " + str);
            raf.writeBytes(separator);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод очищает файл.
     *
     * @param file - файл дя очистки.
     */
    public void clearFile(File file) {
        try (RandomAccessFile dis = new RandomAccessFile(file, "rw")) {
            dis.setLength(0);
            dis.writeBytes("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}