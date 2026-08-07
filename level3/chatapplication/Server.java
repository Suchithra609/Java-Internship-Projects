package level3.chatapplication;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	    public static void main(String[] args) {
	        try {
	            ServerSocket serverSocket = new ServerSocket(5000);
	            System.out.println("Server Started...");
	            System.out.println("Waiting for clients...");
	            while (true) {
	                Socket socket = serverSocket.accept();
	                System.out.println("New Client Connected: " + socket.getInetAddress());
	                ClientHandler client = new ClientHandler(socket);
	                client.start();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
