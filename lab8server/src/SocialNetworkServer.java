import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SocialNetworkServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean running = false;

    public static void main(String[] args)  throws IOException {
        SocialNetworkServer server = new SocialNetworkServer();
        server.init();
        server.waitForClients(); //... handle the exceptions!
        server.stop();
    }
    public void init(){// Implement the init() method: create the serverSocket and set running to true
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        }
    }
    public void waitForClients() throws IOException{
        // Implement the waitForClients() method: while running is true, create a new socket
        //for every incoming client and start a ClientThread to execute its request.
        System.out.println ("Waiting for a client ...");
        while (true) {
           // System.out.println ("Waiting for a client ...");
            Socket socket = serverSocket.accept();
            // Execute the client's request in a new thread
            new ClientThread(this, socket).start();//to be modified.. different constructor
        }
    }


    public void stop() throws IOException {
        this.running = false;
        serverSocket.close();
    }

}