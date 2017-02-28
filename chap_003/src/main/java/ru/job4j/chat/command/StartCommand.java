package ru.job4j.chat.command;

import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 */
public class StartCommand extends NotFinishCommand {
    @Override
    public String getName() {
        return "start";
    }

    @Override
    public String execute(String stack, Scanner sc) {
        return stack;
    }
}
