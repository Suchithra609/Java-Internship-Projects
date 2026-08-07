package level3.chatapplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class ClientHandler extends Thread {
	    private Socket socket;
	    public ClientHandler(Socket socket) {
	        this.socket = socket;
	    }
	    @Override
	    public void run() {
	        try {
	            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
	            writer.println("Welcome to Chat Server!");
	            String message;
	            while ((message = reader.readLine()) != null) {
	                System.out.println("Client: " + message);
	                writer.println("Server Received: " + message);
	            }
	            socket.close();
	        } catch (IOException e) {
	            System.out.println("Client Disconnected");
	        }
	    }
	}
