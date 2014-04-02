package tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
	public static String outToNewFile(String path,String content){
		File f = new File(path);
		if(!f.exists()){
			try {
				f.createNewFile();
				FileOutputStream fo = new FileOutputStream(f);
				try {
					fo.write(content.getBytes());
				} catch (Exception e) {
					System.out.println("д��ʧ��");
					path = "";
				} finally{
					fo.close();
				}
			} catch (IOException e) {
				System.out.println("��ַ���Ϸ�");
				path = "";
			}
		}else{
			System.out.println("�ļ��Ѵ���");
			path = "";
		}
		
		return path;
	}
}
