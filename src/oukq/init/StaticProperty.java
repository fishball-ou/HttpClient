package oukq.init;

import java.io.File;

public class StaticProperty {
	
	//1024listPath
	public static String PATH_FID_16 = "http://cl.man.lv/thread0806.php?fid=16&search=&page=";
	//1024host
	public static String HOST_1024 = "http://cl.man.lv/";
	//本地存放目录
	public static String PIC_DIR = "D:/test";
	//连接超时限制
	public static int TIME_OUT = 50000;
	
	public static int TYPE_163 = 163;
	
	public static int TYPE_1024 = 1024;
	
	static{
		File f = new File(PIC_DIR);
		if(!f.exists() && !f.isFile()){
			f.mkdir();
		}
	}
}
