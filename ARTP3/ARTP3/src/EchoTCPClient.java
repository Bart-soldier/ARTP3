import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EchoTCPClient {

    boolean testClient = false;
    int testMessageNumber = 0;
    byte[] output;


    public void Client(String server, int port) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String string;
        byte[] input;


        while(true) {
            string = getInput(scanner);

            Socket socket = new Socket(server, port);

            output = (string + "\n").getBytes();
            socket.getOutputStream().write(output);

            if(string.equals("EndConnection\n")){
                System.out.println("Ending Connection ...");
                socket.close();
                return;
            }

            input = new byte[50];
            socket.getInputStream().read(input);

            System.out.println(new String(input));
            socket.close();
        }
    }

    private String getInput(Scanner scanner){
        if (testClient){
            if (testMessageNumber == 2){
                return "EndConnection\n";
            }
            testMessageNumber++;
            return  ("message" + testMessageNumber);
        }

        try {
            System.out.print("Enter message : ");
            return scanner.nextLine() + "\n";
        }
        catch(Exception e) {return "";}

    }

    public void setTestClient(boolean testClient) {
        this.testClient = testClient;
    }
}
