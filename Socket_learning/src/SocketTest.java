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
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		InetAddress []address=InetAddress.getAllByName("baidu.com");
		for(InetAddress e:address)
		System.out.println(e.toString());
		
		try{
		Socket s=new Socket();
		s.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov",13),5000);
			s.setSoTimeout(1000);
			InputStream inStream=s.getInputStream();
			Scanner in=new Scanner(inStream);
			
			while(in.hasNextLine()){
				String line=in.nextLine();
				System.out.println(line);
			}
		}
		catch(InterruptedIOException e){
			System.out.println("连接超时");
		}
	}

}
