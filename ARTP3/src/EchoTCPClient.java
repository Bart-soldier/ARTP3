import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EchoTCPClient {
    public static void Client(String server, int port) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String string;
        byte[] input;
        byte[] output;

        while(true) {
            try {
                System.out.print("Enter message : ");
                string = scanner.nextLine() + "\n";
            }
            catch(Exception e) {break;}

            Socket socket = new Socket(server, port);

            output = (string + "\n").getBytes();
            socket.getOutputStream().write(output);

            input = new byte[50];
            socket.getInputStream().read(input);

            System.out.println(new String(input));
            socket.close();
        }
    }
}
