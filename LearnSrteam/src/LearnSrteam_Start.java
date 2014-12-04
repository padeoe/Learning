import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Scanner;

/**
 * @author padeoe
 *
 */
@SuppressWarnings("deprecation")
public class LearnSrteam_Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//获取可用字符集
		Map<String,Charset> charset=Charset.availableCharsets();
		System.out.println("当前可用的字符集有：");
		for(String name:charset.keySet())
			System.out.println(name);
		//使用UTF-8进行文本输入

		//从文件读取字节
		File datafile=new File("data3.txt");
		datafile.createNewFile();
		PrintWriter write_data_file=new PrintWriter(new FileWriter(datafile));
		write_data_file.print("这是一行中文文本，它被从输入流中写入文件，又被解码读到字节数组中，最后被编码写进输出流，输出到屏幕");
		write_data_file.close();
				Charset cset=Charset.forName("Unicode");
		Scanner read=new Scanner(new FileInputStream(datafile));
		String text=read.nextLine();
		ByteBuffer buffer=cset.encode(text);
		byte[] bytes=buffer.array();
		ByteBuffer bbuf=ByteBuffer.wrap(bytes, 0, bytes.length);
		CharBuffer cbuf=cset.decode(bbuf);
		String newstr=cbuf.toString();
		System.out.println(newstr);
		
		
		
		
		
		//		String filepath="C:\\Users\\padeoe\\Desktop\\data.txt";
//		PrintWriter out=new PrintWriter(filepath);
//		out.print("hello");
//		out.flush();
//		InputStreamReader in=new InputStreamReader(new FileInputStream(filepath),"Unicode");
//		
////		OutputStreamWriter out=new OutputStreamWriter(System.out,"Unicode");
//		out.write(in.read());
//		in.close();
		// StringBufferInputStream用于处理字符串，而不是文件，所以的参数不是路径
	//	StringBufferInputStream readfile = new StringBufferInputStream(
	//	"D:/Users/padeoe/Desktop/hello.txt");
	//	System.out.println(readfile.read());// 读到的是'D'的值
//		ReadFile_Unicode("C:\\Users\\padeoe\\Desktop\\data.txt");
	//	ReadFile_Unicode("C:\\Users\\padeoe\\Desktop\\data.txt");
//		ReadFile_Unicode2("C:\\Users\\padeoe\\Desktop\\data2.txt");
		
	}

	public static void ReadFile_Unicode(String filepath) throws IOException {
		FileInputStream read_Unicode=new FileInputStream(filepath);	
		DataInputStream din=new DataInputStream(read_Unicode);
//		double s=din.readDouble();
//		System.out.println(s);
		System.out.println(din.readDouble());
		read_Unicode.close();

	}
//	public static void ReadFile_Unicode2(String filepath) throws IOException {
//		FileReader read_Unicode=new FileReader(filepath);	
//		System.out.println(read_Unicode.read());
//		System.out.println(read_Unicode.read());
//		
//		
//		read_Unicode.close();
//	}

}

class A {

}
