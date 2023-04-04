/*
 * used these WindowBuilder options: 1. JLabel 2. JToolBar 3. groupLayout 4. JPanel 5. 
 */
package media_player;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.Scrollbar;




	public class MediaFrame extends JFrame implements MouseListener, ActionListener, ChangeListener{      //allows the frame to use mouse listener and action listener
		JLabel musicLabel;
		JLabel playLabel;
		GroupLayout groupLayout;
		JSlider playSlider;
		JButton uploadFiles;
		private JFileChooser fileChooser;        //enables user to select file
		private JTextField selectedFileField;    //Holds name of file
		private JTextArea outputArea;         // Holds file output
		
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MediaFrame frame = new MediaFrame();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public MediaFrame() {
			getContentPane().setBackground(new Color(0x4B4F4C));
			initComponents();
			ImageIcon mainImage = new ImageIcon("D:/eclipseWorkspaces/SENG102Java/MediaPlayer/filter_b_and_w_black_24dp.png");             //creates an ImageIcon
			this.setIconImage(mainImage.getImage()); 
			this.setTitle("Abstract Player");
			this.setVisible(true);
		}

		private void initComponents() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1920, 1080);
			
			
			//containToolBar
			JToolBar containToolBar = new JToolBar();
			containToolBar.setOrientation(SwingConstants.VERTICAL);
			containToolBar.setBackground(new Color(0xBAA48A));
			containToolBar.setPreferredSize(new Dimension(30, 100));
			
			//listPanel
			JPanel listPanel = new JPanel();
			listPanel.setBackground(new Color(0x708090));
			listPanel.setPreferredSize(new Dimension(1280, 720));
				
			
				
				
			//groupLayout
			groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(containToolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(listPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(525, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(containToolBar, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addGap(71))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(37)
						.addComponent(listPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(88))
			);
			
			
			//listPanel's uploadFiles Button
			uploadFiles = new JButton("Upload Files");
			uploadFiles.setIcon(new ImageIcon("D:/eclipseWorkspaces/SENG102Java/workingMediaPlayer/src/media_assets/file_upload_black_24dp.png"));
			uploadFiles.addActionListener(this); //FIXME DONT HAVE SEPERATE ACTION LISTENER
			listPanel.add(uploadFiles);          //makes uploadFiles button visible
			fileChooser = new JFileChooser();    //creates JFileChooser object to be used with uploadButton 
			
			
			//navigationToolBar
			JToolBar navigationToolBar = new JToolBar();
			navigationToolBar.setOrientation(SwingConstants.VERTICAL);
			navigationToolBar.setBackground(new Color(0xBAA48A));
			containToolBar.add(navigationToolBar);
			
				//music button
				musicLabel = new JLabel();
				musicLabel.setIcon(new ImageIcon("D:\\eclipseWorkspaces\\icons\\music_note_black_24dp.png"));
				musicLabel.addMouseListener(this);               //allows response to mouse events
				navigationToolBar.add(musicLabel);
				
				//movie button
				JLabel movLabel = new JLabel("");
				movLabel.setIcon(new ImageIcon("D:\\eclipseWorkspaces\\icons\\movie_black_24dp.png"));
				navigationToolBar.add(movLabel);
				
				//tv button
				JLabel tvLabel = new JLabel("");
				tvLabel.setIcon(new ImageIcon("D:\\eclipseWorkspaces\\icons\\tv_black_24dp.png"));
				navigationToolBar.add(tvLabel);
			
				
					//mediaToolBar
					JToolBar mediaToolBar = new JToolBar();
					mediaToolBar.setRollover(true);
					mediaToolBar.setOrientation(SwingConstants.VERTICAL);
					mediaToolBar.setBackground(new Color(0xBAA48A));
					containToolBar.add(mediaToolBar);
					
					
						//play button
						playLabel = new JLabel();
						playLabel.setIcon(new ImageIcon("D:\\eclipseWorkspaces\\icons\\play_circle_black_24dp.png"));
						playLabel.addMouseListener(this);               //allows response to mouse events
						mediaToolBar.add(playLabel);
						
						
				

			
		
			getContentPane().setLayout(groupLayout);
			
		}
		
		
		
	
		//musicLabel MouseListeners - FIXME how do i use multiple mouseEvents
			public void mouseClicked1(MouseEvent d) {                 //invoked when the mouse button has been clicked (pressed and released) on a component
			musicLabel.setIcon(new ImageIcon("D:/eclipseWorkspaces/SENG102Java/workingMediaPlayer/src/media_assets/music_note_white_24dp.png"));
			System.out.println("mouse clicked music");
			}
		
			public void mouseEntered1(MouseEvent d) {                //invoked when the mouse enters a component
				musicLabel.setIcon(new ImageIcon("D:/eclipseWorkspaces/SENG102Java/workingMediaPlayer/src/media_assets/music_note_white_24dp.png"));
			}
		
			public void mouseExited1(MouseEvent d) {                //invoked when the mouse exits a component
				
				musicLabel.setIcon(new ImageIcon("D:/eclipseWorkspaces/SENG102Java/workingMediaPlayer/src/media_assets/music_note_black_24dp.png"));
			}
			public void mousePressed1(MouseEvent d) {                //invoked when a mouse button has been pressed on a component
				
				musicLabel.setIcon(new ImageIcon("D:/eclipseWorkspaces/SENG102Java/workingMediaPlayer/src/media_assets/music_note_white_24dp.png"));
			}
			public void mouseReleased1(MouseEvent d) {             //invoked when a mouse button has been released on a component
				
				musicLabel.setIcon(new ImageIcon("D:/eclipseWorkspaces/SENG102Java/workingMediaPlayer/src/media_assets/music_note_black_24dp.png"));
			}

		//playLabel MouseListeners
			
			public void mouseClicked(MouseEvent e) {                 //invoked when the mouse button has been clicked (pressed and released) on a component
				if(e.getSource()==playLabel) {
				
				PlayFrame pFrame = new PlayFrame();
				pFrame.setVisible(true);
				System.out.println("mouse clicked play");
				}
			}
			
			
			public void mouseEntered(MouseEvent e) {                //invoked when the mouse enters a component
				playLabel.setIcon(new ImageIcon("D:/eclipseWorkspaces/SENG102Java/workingMediaPlayer/src/media_assets/play_circle_white_24dp.png"));
				
			}
	
			
			public void mouseExited(MouseEvent e) {                //invoked when the mouse exits a component
				
				playLabel.setIcon(new ImageIcon("D:\\eclipseWorkspaces\\icons\\play_circle_black_24dp.png"));
			}
	
			
			public void mousePressed(MouseEvent e) {                //invoked when a mouse button has been pressed on a component
				
				playLabel.setIcon(new ImageIcon("D:/eclipseWorkspaces/SENG102Java/workingMediaPlayer/src/media_assets/play_circle_white_24dp.png"));
			}
	
			public void mouseReleased(MouseEvent e) {             //invoked when a mouse button has been released on a component
			
				playLabel.setIcon(new ImageIcon("D:\\eclipseWorkspaces\\icons\\play_circle_black_24dp.png"));
			}

			
		/**playSlider change method
		 * 
		 */
			@Override
			public void stateChanged(ChangeEvent arg0) {
				playLabel.setText("Play: " + playSlider.getValue());  //FIXME 
			}

			
			/**upload button action method
			 * 
			 */
			@Override
			public void actionPerformed(ActionEvent event) {
				FileInputStream fileByteStream = null;        //file input stream
				Scanner inFS = null;                          // scanner object
				String readLine;                             //input from file
				File readFile = null;				        //input file
				int fileChooserVal;                         //file chooser --must be int
				
				//opens the fileChooser dialogue (new pop-up screen) and gets the file to open
				fileChooserVal = fileChooser.showOpenDialog(this);
				fileChooser.setDialogTitle("Open File");
				
				//check if file was selected
				if(fileChooserVal == JFileChooser.APPROVE_OPTION) {          //signals that a user pressed the open button
					readFile = fileChooser.getSelectedFile();
				
					// Update selected file field
			        selectedFileField.setText(readFile.getName());
			         
			        //ensure file is valid
					if (readFile.canRead()) {
						try {
							fileByteStream = new FileInputStream(readFile);
							inFS = new Scanner(fileByteStream);
							
							// Clear output area
				            outputArea.setText(""); 
				            
				            // Read until end-of-file
				            while (inFS.hasNext()) {
				                readLine = inFS.nextLine();
				                outputArea.append(readLine + "\n");
				               }
						}catch(IOException e){
							outputArea.append("\n\nError occurred while creating file stream! " + e.getMessage());
						}
					}
					else {
						// Can't read file
			            // Show failure dialog
			            JOptionPane.showMessageDialog(this, "Can't read file!");
					}
				}	
			}
			
		
		
		
	}


