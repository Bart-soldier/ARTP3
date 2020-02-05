import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoTCPServer {

    public static void Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        byte[] input;
        byte[] output;

        while(true)
        {
            Socket socket = serverSocket.accept();
            input = new byte[50];
            socket.getInputStream().read(input);

            output = ("> " + new String(input) + "\n").getBytes();
            socket.getOutputStream().write(output);
            socket.close();
        }
    }
}
