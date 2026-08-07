package level3.chatapplication;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class Client {
	    public static void main(String[] args) {
	        try {
	            Socket socket = new Socket("localhost", 5000);
	            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
	            Scanner scanner = new Scanner(System.in);
	            System.out.println(reader.readLine());
	            while (true) {
	                System.out.print("You: ");
	                String message =scanner.nextLine();
	                writer.println(message);
	                String response =reader.readLine();
	                System.out.println(response);
	                if (message.equalsIgnoreCase("exit")) {
	                    break;
	                }
	            }
	            scanner.close();
	            socket.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
