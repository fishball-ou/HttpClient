package oukq.tools;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShowPict extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6014691282504974678L;

	public ShowPict(String Path){
		Image img = null;
		try{
			img = ImageIO.read(new File(Path));
		}catch (Exception e) {
			System.out.println("不能显示图片");
		}
		JLabel label = new JLabel(new ImageIcon(img));
		add(label);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
}
