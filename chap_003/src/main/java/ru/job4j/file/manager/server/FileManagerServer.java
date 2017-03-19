package ru.job4j.file.manager.server;

import ru.job4j.Setting;
import ru.job4j.file.manager.Manager;
import ru.job4j.file.manager.operations.DirOperation;
import ru.job4j.file.manager.operations.Operation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Aleksandr Smirnov.
 */
public class FileManagerServer {
    public static void main(String[] args) {
        FileManagerServer fileManagerServer = new FileManagerServer();
        fileManagerServer.startServer();
    }

    public void startServer() {
        final int port = 7000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Manager manager = new Manager();
            System.out.println("Waiting for a client");
            Socket socket = serverSocket.accept();
            System.out.println("Got a client");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);
            String line = null;
            String msg = String.format("%s\n%s%s","Для получения списка команд введите - help.", manager.getCurrentDir(), '>');
            Operation operations = new DirOperation();

            while (true) {
                if(line!=null){
                    msg = manager.start(new File(manager.getHomeDir()), new File(manager.getCurrentDir()),line);
                }
//                byte[] bytes = msg.getBytes();
                byte[] lines = msg.getBytes();
//                int sizeArray = bytes.length;
                int lineSize = lines.length;
//                out.writeInt(sizeArray);
//                out.write(bytes);
                out.writeInt(lineSize);
                out.write(lines);

                line = in.readUTF();
//                out.writeUTF(line);
                out.flush();
                System.out.println("Waiting  for the next line ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
