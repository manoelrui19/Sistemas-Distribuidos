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
	        
	        Object o = ois.readObject(); 
	        User user = (User)o;
	        System.out.println("Object saved [User:" + user.getName()+","+user.getEmail()+"]");
	        oos.writeObject(user); 
	        
	        ois.close();  
	        oos.close(); 
            
	        return true;
	 }

}
