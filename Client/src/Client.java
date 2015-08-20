import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

	static int port = 3332;
	static String ip = "localhost"; 
	
	public static void main(String[] args) {
		Socket socket;
		byte[] tempBytes;
		
		try {
			// Object to be send
			User user = new User("Joao", 72.56f, 22);			
			socket = new Socket(ip, port);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());  
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());  
                        
            System.out.println("Client Side:");
            
            // Sending a serialized User object
            System.out.println("Sending Object");
            System.out.println("User.name: " + user.getName());
            System.out.println("User.weight: " + user.getWeight());
            System.out.println("User.age: " + user.getAge());
            tempBytes = Utils.serializeObjToByteArray(user);
            System.out.println("Object size: " + tempBytes.length);
            System.out.println("Bytes: " + Utils.bytesToHex(tempBytes));
            oos.writeObject(user);         
                        
            // Receiving a new serialized User object     
            User returnedUser = (User) ois.readObject(); 
            System.out.println("\nReceived Object");
            System.out.println("User.name: " + returnedUser.getName());
            System.out.println("User.weight: " + returnedUser.getWeight());
            System.out.println("User.age: " + returnedUser.getAge());
            tempBytes = Utils.serializeObjToByteArray(returnedUser);
            System.out.println("Object size: " + tempBytes.length);
            System.out.println("Bytes: " + Utils.bytesToHex(tempBytes));
            
            oos.close();  
            ois.close(); 
            socket.close();
            
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}        
	}
}
