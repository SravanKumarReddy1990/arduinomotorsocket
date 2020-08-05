import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket listener = new ServerSocket(9090);
        try{
            while(true){
                Socket socket = listener.accept();
                socket.setKeepAlive(true);
                System.out.println("Client Connected");
                try{
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println("Client response: " + in.readLine());

//                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//                    System.out.println("Sending Message...");
//                    out.write("forward");
//                    out.flush();
int i=0;
while(true){
  Scanner console = new Scanner(System.in);

      // Get length from the user.
      System.out.print("Enter length ");
     String direction = console.next();

    try{
BufferedWriter outs = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    System.out.println("Sending Message...");
                    outs.write(direction);
                    outs.flush();
Thread.sleep(5000);
i++;
}catch(InterruptedException e){System.out.println(e);}  
}

                } finally {
	
 

                  //  socket.close();
                }
            }
        } finally {
            listener.close();
        }
    }

}
