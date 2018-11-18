package ui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class UICard extends JLabel implements PropertyListener{
	private int width;
	private int height;
	
	public UICard(int width, int height){
		this.width = width;
		this.height = height;
		setVisible(false);
	}
	
	@Override
	public void onPropertyEvent(PropertyEvent e) {
		// TODO Auto-generated method stub
		String imagePath = "./images/";
		String fileName = ((String) e.getNewValue()).replaceAll("[^a-zA-Z0-9]", "");
		
		if(e.getPropertyName().equals("cardNameChance")){
			imagePath += "chanceCards/";
		}else if(e.getPropertyName().equals("cardNameCommunityChest")){
			imagePath += "communityChestCards/";
		}else if(e.getPropertyName().equals("cardNameRollThree")){
			imagePath += "rollThreeCards/";
		}
		
		imagePath += fileName + ".png";
		
		if(System.getProperty("os.name").contains("Windows")){
			imagePath.replaceAll("\\/", "\\\\");
		}
		System.out.println(imagePath);
		
		Image tmp = null;
		try {
			tmp = ImageIO.read(new File(imagePath));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tmp = tmp.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		this.setIcon(new ImageIcon(tmp));
		this.setVisible(true);
		
		new Timer().schedule(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				UICard.this.setVisible(false);
			}
			
		}, 3000);
	}

}
