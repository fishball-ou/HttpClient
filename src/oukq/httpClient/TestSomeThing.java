package oukq.httpClient;

import java.util.Arrays;

import javax.imageio.ImageIO;

public class TestSomeThing {
	public static void main(String[] args){
		System.out.println("支持写的图片格式:" +Arrays.toString(ImageIO.getWriterFormatNames()));
        System.out.println("支持读的图片格式:" +Arrays.toString(ImageIO.getReaderFormatNames()));
	}
}
