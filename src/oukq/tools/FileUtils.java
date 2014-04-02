package oukq.tools;

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
					System.out.println("写入失败");
					path = "";
				} finally{
					fo.close();
				}
			} catch (IOException e) {
				System.out.println("地址不合法");
				path = "";
			}
		}else{
			System.out.println("文件已存在");
			path = "";
		}
		
		return path;
	}
	
	public static String saveFile(byte[] fileBytes,String path){
		File file = new File(path);
		if(file.exists()){
			return null;
		}
		try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		FileOutputStream fo;
		try {
			fo = new FileOutputStream(file);
			fo.write(fileBytes);
			fo.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return path;
	}
}
