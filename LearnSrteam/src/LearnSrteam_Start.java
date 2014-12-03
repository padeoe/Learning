import java.io.StringBufferInputStream;

@SuppressWarnings("deprecation")
public class LearnSrteam_Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// StringBufferInputStream用于处理字符串，而不是文件，所以的参数不是路径
		StringBufferInputStream readfile = new StringBufferInputStream(
				"D:/Users/padeoe/Desktop/hello.txt");
		System.out.println(readfile.read());// 读到的是'D'的值
	}
}
