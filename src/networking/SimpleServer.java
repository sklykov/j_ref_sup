package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    // demo of simple server waiting for and responding via stdout some commands
    // for running this example, use the Multirun plugin and configure it to run two classes simultaneously
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8085)){
            Socket socket = serverSocket.accept();  // blocks this program until incoming connection is established
            if (socket.isConnected()){ System.out.println("Server connected with client");}
            BufferedReader inputCommands = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            boolean keepListening = true;
            while(keepListening){
                String readLine = inputCommands.readLine();
                if (readLine.equalsIgnoreCase("quit")) {
                    keepListening = false;
                    System.out.println("Received command: " + readLine);
                }
                else if (readLine.length() > 0) System.out.println("Received command: " + readLine);
                try { Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
            }

        } catch (IOException e) {e.printStackTrace();}
    }
}
