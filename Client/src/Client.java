import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.logging.FileHandler;


public class Client {

	static int port = 3332;
	static String ip = "10.102.22.2"; 
	
	public static void main(String[] args) {
		
		File file = new File("arquivo.txt");  
        if(file.exists() && !file.isDirectory()) { 
            Socket socket;
			try {
				socket = new Socket(ip, port);
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());  
	            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());  
	            User user = new User("Rui", "rui@lsbd.ufc.br");
	            
	            oos.writeObject(user); 
	            	     
	            Object obj = ois.readObject();  
	      
	            User returnUser = (User)obj;
	            System.out.println("Objeto recuperado. User: " + returnUser.getName() + "-" + returnUser.getEmail());
	            System.out.println("Objetos Iguais " + returnUser.equals(user));
     
	            oos.close();  
	            ois.close(); 
	            socket.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}   
        }else{
        	System.out.println("Invalid!");
        }
	}



}
