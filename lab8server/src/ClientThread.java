import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientThread extends Thread {
    private Socket socket = null;
    private final SocialNetworkServer server;
    private boolean logged;
    // Create the constructor that receives a reference to the server and to the client socket

    public ClientThread(SocialNetworkServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //client -> server stream
            String request = in.readLine();
            String response = execute(request);
            PrintWriter out = new PrintWriter(socket.getOutputStream()); //server -> client stream
            out.println(response);
            out.flush();

        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private String execute(String request) {
        if(request.startsWith("exit")){
            System.out.println("Clientul s-a deconectat cu succes.");
            String response = "Te-ai deconectat cu succes!";
            return response;

        } else {
            System.out.println("Server received the request ... " + request); // display the message: "Server received the request ... "
            String response = "Am primit mesajul '" + request + "'";
            return response;
        }

    }

}


