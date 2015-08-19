import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ProcessCall {
	
    private Socket server;

	
	ProcessCall(Socket server){
		this.server = server;
	}
	
	public void execute() {			
			try {
				processCall(server);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	 private boolean processCall(Socket socket) throws Exception {  
		    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());  
	        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());  
	                               
	        System.out.println("\nServer Side:");
	        
            // Receiving a new serialized User object     
            User user = (User) ois.readObject(); 
            System.out.println("Received Object");
            System.out.println("User.name: " + user.getName());
            System.out.println("User.weight: " + user.getWeight());
            System.out.println("User.age: " + user.getAge());
	        
            // Sending a modified User object
            user.setName("Maria");
            user.setAge(18);
            user.setWeight(56.8f);
            System.out.println("\nSending Object");
            System.out.println("User.name: " + user.getName());
            System.out.println("User.weight: " + user.getWeight());
            System.out.println("User.age: " + user.getAge());
            oos.writeObject(user);            
	                
	        ois.close();  
	        oos.close(); 
            
	        return true;
	 }
}
