package other;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost",81);
		
		OutputStream outputStream = socket.getOutputStream();
		
		while(true){
			Scanner scanner = new Scanner(System.in);
			outputStream.write(scanner.next().getBytes());
		}
	}
}
