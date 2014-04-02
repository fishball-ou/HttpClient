package oukq.init;

import java.io.File;

public class StaticProperty {
	
	//���ǵ�����
	public static String PATH_FID_16 = "http://cl.man.lv/thread0806.php?fid=16&search=&page=";
	//����ͼƬĬ�ϵ�ַ
	public static String PIC_DIR = "D:/test";
	//���ӳ�ʱ
	public static int TIME_OUT = 50000;
	
	static{
		File f = new File(PIC_DIR);
		if(!f.exists() && !f.isFile()){
			f.mkdir();
		}
	}
}
