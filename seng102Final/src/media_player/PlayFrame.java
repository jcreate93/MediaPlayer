package media_player;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import java.awt.BorderLayout;

public class PlayFrame extends JFrame{
	
	
	
	PlayFrame(){
	//create a frame
	   //JFrame this = new JFrame();                    //creates a new frame when mouse is clicked
	this.setSize(new Dimension(500, 200));
	
	//add image to this
	ImageIcon mainIcon = new ImageIcon("D:/eclipseWorkspaces/SENG102Java/MediaPlayer/filter_b_and_w_black_24dp.png");             //creates an ImageIcon
	this.setIconImage(mainIcon.getImage()); 
	
	//set title on this
	this.setTitle("Playback");
	
	
	//add playSlider
	JSlider playSlider = new JSlider();
	playSlider = new JSlider(0,300,0);          //parenthesis stand for: (minimum, maximum, starting point)
	playSlider.setPreferredSize(new Dimension(400,100));          //Dimension(width,height)
	playSlider.setPaintTicks(true);                              //displays tick markings
	playSlider.setMinorTickSpacing(5);                         //how often you want tick marks
	playSlider.setPaintTrack(true);             
	playSlider.setMajorTickSpacing(50);                         //sets ticks that are longer for every 10 ticks
	//playSlider.addChangeListener(this);
	//playSlider.setPaintLabels(true);                           //displays the numbers for each tick
	
	
	//create a panel to house playSlider
	JPanel playPanel = new JPanel();
	playPanel.add(playSlider);
	getContentPane().add(playPanel, BorderLayout.SOUTH);
	
	//create a label to show the value of the slider
	JLabel playLabel = new JLabel();
	playLabel.setText("Play: " + playSlider.getValue());  //FIXME need time code label 00:00:00  //see state changed 
	playPanel.add(playLabel);
	
	
// add this second slider		//add volumeSlider
	JSlider volumeSlider = new JSlider(0, 100,50);
	volumeSlider.setPreferredSize(new Dimension(50,50));
	volumeSlider.setPaintTicks(true);
	volumeSlider.setMinorTickSpacing(5);
	volumeSlider.setPaintTrack(true);
	volumeSlider.setMajorTickSpacing(10); 
	volumeSlider.setPaintLabels(true);
	//volumeSlider.setFont(new Font("MV Boli", Font.PLAIN, 9));          //new Font(changes the font, sets the styling of font, changes the size of font)
	volumeSlider.setOrientation(SwingConstants.VERTICAL);              //changes the slider to be vertical instead of horizontal. could have: (SwingConstants.HORIZONTAL);
	
	
	//create a panel to house volumeSlider
	JPanel volumePanel = new JPanel();
	volumePanel.add(volumeSlider);
	
	this.add(volumePanel);
	
	
	
	//add volumeLabel
	 JLabel volumeLabel = new JLabel();
	 volumeLabel.setText("Volume: " + volumeSlider.getValue());          //show the value of where the slider is located on the line by using: volumeSlider.getValue();
	
	 
	
	this.setVisible(true);
	   
}
	//playSlider change
	/*@Override
	public void stateChanged(ChangeEvent arg0) {
		playLabel.setText("Play: " + playSlider.getValue());  //FIXME 
	}*/
}
