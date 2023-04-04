package media_player;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class PlayFrame extends JFrame {

	PlayFrame() {

		this.setSize(new Dimension(500, 200));

		ImageIcon mainIcon = new ImageIcon(
				"D:/eclipseWorkspaces/SENG102Java/MediaPlayer/filter_b_and_w_black_24dp.png");
		this.setIconImage(mainIcon.getImage());

		this.setTitle("Playback");

		JSlider playSlider = new JSlider();
		playSlider = new JSlider(0, 300, 0);
		playSlider.setPreferredSize(new Dimension(400, 100));
		playSlider.setPaintTicks(true);
		playSlider.setMinorTickSpacing(5);
		playSlider.setPaintTrack(true);
		playSlider.setMajorTickSpacing(50);

		JPanel playPanel = new JPanel();
		playPanel.add(playSlider);
		getContentPane().add(playPanel, BorderLayout.SOUTH);

		JLabel playLabel = new JLabel();
		playPanel.add(playLabel);

		JSlider volumeSlider = new JSlider(0, 100, 50);
		volumeSlider.setPreferredSize(new Dimension(50, 50));
		volumeSlider.setPaintTicks(true);
		volumeSlider.setMinorTickSpacing(5);
		volumeSlider.setPaintTrack(true);
		volumeSlider.setMajorTickSpacing(10);
		volumeSlider.setPaintLabels(true);

		volumeSlider.setOrientation(SwingConstants.VERTICAL);

		JPanel volumePanel = new JPanel();
		volumePanel.add(volumeSlider);

		this.add(volumePanel);

		JLabel volumeLabel = new JLabel();
		volumeLabel.setText("Volume: " + volumeSlider.getValue());

		this.setVisible(true);

	}

}
