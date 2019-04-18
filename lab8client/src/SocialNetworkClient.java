import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocialNetworkClient {
    private final static String SERVER_ADDRESS = "127.0.0.1";
    private final static int PORT = 8100;
    public static void main(String[] args) throws IOException {
        SocialNetworkClient client = new SocialNetworkClient();
        while (true) {
            String request = client.readFromKeyboard();
            if (request.equalsIgnoreCase("exit")) {
                client.sendRequestToServer(request);
                break;
            } else {
                client.sendRequestToServer(request);
            }
        }
    }

    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void sendRequestToServer(String request) throws IOException {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
        ) {
            out.println(request);
            // Wait the response from the server ("Hello World!")
            String response = in.readLine ();
            System.out.println(response);
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}