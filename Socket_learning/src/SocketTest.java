import java.io.*;
import java.net.*;
import java.util.*;

/**   
 *    
 * 项目名称：Socket_learning   
 * 类名称：SocketTest
 * 类描述：   
 * 创建人：padeoe   
 * 创建时间：2014年12月4日 下午8:59:41   
 * 修改人：padeoe   
 * 修改时间：2014年12月4日 下午8:59:41   
 * 修改备注：   
 * @version    
 *    
 */

public class SocketTest {
	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Socket_learning a=new Socket_learning();
	    a.createServer();
	//	a.printAllIP("dropbox.com");
	//	a.connect_socket2("time-A.timefreq.bldrdoc.gov", 13);
		
	}

}

class Socket_learning{
	static void connect_socket(String host,int port) throws IOException{
		try{
		Socket s=new Socket();
		//s.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov",13),1000);
		s.connect(new InetSocketAddress(host,port),5000);
		//s.setSoTimeout(5000);
			InputStream inStream=s.getInputStream();
			Scanner in=new Scanner(inStream);
			while(in.hasNextLine()){
				String line=in.nextLine();
				System.out.println(line);
			}
			in.close();
			s.close();
		}
		catch(IOException e){
			System.out.println("连接超时");
		}
	}
	
	static void connect_socket2(String host,int port) {
		try(Socket s=new Socket()){
		s.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov",13),1000);
		s.connect(new InetSocketAddress(host,port),5000);
		//s.setSoTimeout(5000);
			InputStream inStream=s.getInputStream();
			Scanner in=new Scanner(inStream);
			while(in.hasNextLine()){
				String line=in.nextLine();
				System.out.println(line);
			}
			in.close();
			s.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接超时");
		}
	}
	
	static void printAllIP(String address){
		InetAddress[] IP;
		try {
			IP = InetAddress.getAllByName(address);
			for(InetAddress e:IP)
				System.out.println(e.toString());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			System.out.println("无法解析的域名");
		}
		
	}
	
	static void createServer(){
		try(ServerSocket server=new ServerSocket(8189)){
			
			try(Socket incoming=server.accept()){
				InputStream inStream=incoming.getInputStream();
			//	OutputStream outStream=new outStream("UTF-8");
				OutputStream outStream=incoming.getOutputStream();
				try(Scanner in=new Scanner(inStream)){		
					PrintWriter print_to_screen=new PrintWriter(outStream,true);
					print_to_screen.println("Hello,I'm WuKangkang,Please input anything you want)");
					print_to_screen.println("What you have input is:   "+in.nextLine()+"  Goodbye!");
					
				}
				
			}
			
		}
//		catch(){
//			
//		}
 catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	
}
