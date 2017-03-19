package ru.job4j.file.manager.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Aleksandr Smirnov.
 */
public class FileManagerClient{
    public static void main(String[] args) throws UnknownHostException {
        FileManagerClient fileManagerClient = new FileManagerClient();
        fileManagerClient.startClient();
    }
    public void startClient() throws UnknownHostException {
        final int port = 7000;
        String address = "127.0.0.1";
        InetAddress inetAddress = InetAddress.getByName(address);
        try(Socket socket = new Socket(inetAddress, port)) {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String line;
            while (true){

                int sizeArray = in.readInt();
                byte[] bytes = new byte[sizeArray];
                in.read(bytes,0,sizeArray);
                line = new String(bytes);
                System.out.print(line);
                line = keyboard.readLine();
                out.writeUTF(line);
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
