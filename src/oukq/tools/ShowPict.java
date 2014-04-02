package oukq.tools;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShowPict extends JFrame{
	public ShowPict(String Path){
		Image img = null;
		try{
			img = ImageIO.read(new File(Path));
		}catch (Exception e) {
			System.out.println("Œﬁ∑®∂¡»°Õº∆¨");
		}
		JLabel label = new JLabel(new ImageIcon(img));
		add(label);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
}
