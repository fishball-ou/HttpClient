package oukq.httpClient;

import java.util.Arrays;

import javax.imageio.ImageIO;

public class TestSomeThing {
	public static void main(String[] args){
		System.out.println("֧��д��ͼƬ��ʽ:" +Arrays.toString(ImageIO.getWriterFormatNames()));
        System.out.println("֧�ֶ���ͼƬ��ʽ:" +Arrays.toString(ImageIO.getReaderFormatNames()));
	}
}
