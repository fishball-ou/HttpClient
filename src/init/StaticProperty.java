package init;

import java.io.File;

public class StaticProperty {
	
	
	//����ͼƬĬ�ϵ�ַ
	public static String PIC_DIR = "D://test/";
	//���ӳ�ʱ
	public static int TIME_OUT = 5000;
	
	static{
		File f = new File(PIC_DIR);
		if(!f.exists() && !f.isFile()){
			f.mkdir();
		}
	}
}
