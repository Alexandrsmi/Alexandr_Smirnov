package ru.job4j;

import java.io.*;
import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 11.02.2017.
 */
public class DropAbuse {

    public void getDropAbuse(InputStream inputStream, OutputStream outputStream, String[] abuse) throws IOException {

        try (InputStream in = inputStream; OutputStream out = outputStream) {
            Scanner sc  = new Scanner(in);
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                for (String str : abuse) {
                    s = s.replaceAll(str, "");
                }
                out.write(s.getBytes());
            }
        }
    }

}
