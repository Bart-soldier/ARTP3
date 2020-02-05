import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) throws IOException {
        if(args.length < 1){
            System.out.println("You need to enter the server name and the port.\n");
            System.exit(1);
        }
        int port = Integer.parseInt(args[1]);
        EchoTCPClient.Client(args[0], port);
    }
}
