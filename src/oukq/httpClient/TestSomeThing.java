package oukq.httpClient;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import oukq.tools.FileUtils;

public class TestSomeThing {
	public static void main(String[] args){
		testRename();
	}
	
	public static void outputSupportImgType(){
		System.out.println("写类型:" +Arrays.toString(ImageIO.getWriterFormatNames()));
        System.out.println("读类型:" +Arrays.toString(ImageIO.getReaderFormatNames()));
	}
	public static void testCurrentTime(){
		Calendar c = Calendar.getInstance();
		StringBuffer time = new StringBuffer();
		time.append(c);
		System.out.println(time);
	}
	
	public static void testDate(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		String d = sf.format(new Date());
		System.out.println(d);
	}
	
	public static void testRename(){
		String fpath = "D://1024List.txt";
		String newName = FileUtils.renameAppendTime(fpath);
		System.out.println(newName);
	}
}
