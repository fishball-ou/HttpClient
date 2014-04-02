package init;

import java.io.File;

public class StaticProperty {
	
	
	//下载图片默认地址
	public static String PIC_DIR = "D://test/";
	//连接超时
	public static int TIME_OUT = 5000;
	
	static{
		File f = new File(PIC_DIR);
		if(!f.exists() && !f.isFile()){
			f.mkdir();
		}
	}
}
