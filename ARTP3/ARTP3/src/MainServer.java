import java.io.IOException;

public class MainServer {

    public static void main(String[] args) throws IOException {
        System.out.println("Server Starting");
        EchoTCPServer.Server();

    }
}