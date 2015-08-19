import java.net.ServerSocket;
import java.net.Socket;


public class Server extends Thread{
	
	public static final int PORT = 3332;
	private ServerSocket serverSocket;  
	
	 @Override  
	    public void run() {  
	        try {  
	            serverSocket = new ServerSocket(PORT);  
	            System.out.println("Connecting...Server Ok!");
	            
	            while (true) {  
	                Socket s = serverSocket.accept();          
	                ProcessCall process = new ProcessCall(s);
	                process.execute();
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  

	 public static void main(String[] args) {  
	        new Server().start();  
	   } 
	    

}
