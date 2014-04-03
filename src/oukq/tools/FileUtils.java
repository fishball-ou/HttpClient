package oukq.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
	/**
	 * 输出到文件里面
	 * @param path
	 * @param content
	 * @return
	 */
	public static String outToNewFile(String path,String content){
		if(null == content || content.isEmpty()){
			return null;
		}
		File f = new File(path);
		if(f.exists()){
			System.out.println("已存在文件,重命名");
			path = renameAppendTime(path);
			System.out.println(path);
			f = new File(path);
		}
		try {
			f.createNewFile();
			FileOutputStream fo = new FileOutputStream(f);
			try {
				fo.write(content.getBytes());
			} catch (Exception e) {
				System.out.println("不能写");
				path = "";
			} finally{
				fo.close();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			path = "";
		}
		return path;
	}
	
	public static String LoadFile(String path){
		StringBuffer content = new StringBuffer();
		File f = new File(path);
		if(!f.exists()||!f.isFile()){
			return null;
		}
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			String line;
			while((line = br.readLine())!= null){
				content.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("文件找不到或读文件错误");
			return null;
		}
		return content.toString();
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
	//文件名加上时间
	public static String renameAppendTime(String path){
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd-HH.mm.ss");
		String d = sf.format(new Date());
		//文件全名
		String file = path.substring(path.lastIndexOf('/')+1);
		//文件目录
		String fileDir = path.substring(0, path.lastIndexOf('/'));
		//文件前缀名
		String fileName = file.substring(0, file.lastIndexOf('.'));
		//文件拓展名
		String fileSuffix = file.substring(file.lastIndexOf(".")+1);
		
		StringBuffer newName = new StringBuffer();
		newName.append(fileDir).append(fileName).append(".").append(d).append(fileSuffix);
		return newName.toString();
	}
}
