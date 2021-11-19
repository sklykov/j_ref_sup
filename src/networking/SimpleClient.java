package networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
    public static void main(String[] args) {
        // for running this example, use the Multirun plugin and configure it to run two classes simultaneously
        try(Socket socket = new Socket("localhost", 8085)){
            PrintWriter commands = new PrintWriter(socket.getOutputStream(), true);  // auto flush for sending command
            commands.println("test command");
            try { Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
            commands.println("quit");

        } catch (UnknownHostException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace(); }
    }
}
