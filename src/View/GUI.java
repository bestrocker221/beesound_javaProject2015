package View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

public class GUI {
	
	private static final double PERC_HALF = 0.5;
	private static final double PERC_QUATER = 0.25;
    private JFrame frame;
    private String pathImage = System.getProperty("user.dir") + System.getProperty("file.separator") + "src"
    		+ System.getProperty("file.separator") + "images" + System.getProperty("file.separator") + "bee4.png";
    
	/*GUI constructor*/
	public GUI() throws IOException {
		//System.out.println(System.getProperty("user.dir"));
		//System.out.println(pathImage);
		
		
		/*THE FRAME*/
		frame = new JFrame("BeeSound example");
		frame.setFont(new Font("Trajan Pro", Font.PLAIN, 12));
		final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int)(dimension.getWidth() * PERC_HALF - dimension.getWidth() * PERC_QUATER);
		int y = (int)(dimension.getHeight() * PERC_HALF - dimension.getHeight() * PERC_QUATER);
		frame.setSize((int) (dimension.getWidth() * 0.5), (int) (dimension.getHeight() * 0.5));
		frame.setLocation(x, y);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setResizable(false);
		frame.setMinimumSize(new Dimension(200, 100));
		
		/*PRINCIPAL PANEL*/
		JPanel bigPanel = new JPanel();
		BorderLayout general = new BorderLayout();
		bigPanel.setLayout(general);
		
		/*SECONDARY PANELS AND COMPONENTS*/
		
		/*LEFT MENU*/
		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(85, 10));
		GridLayout gridLeftPanel = new GridLayout(0, 1, 0, 0);
		leftPanel.setLayout(gridLeftPanel);
		bigPanel.add(leftPanel, BorderLayout.WEST);
		
		/*left buttons*/
		JButton button = new JButton("Brani");
		button.setBorder(null);
		button.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		button.setBackground(new Color(255, 255, 204));
		leftPanel.add(button);
		JButton button_1 = new JButton("Album");
		button_1.setBorder(null);
		button_1.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		button_1.setBackground(new Color(255, 255, 153));
		leftPanel.add(button_1);
		JButton button_2 = new JButton("Artisti");
		button_2.setBorder(null);
		button_2.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		button_2.setBackground(new Color(255, 255, 102));
		leftPanel.add(button_2);
		JButton button_3 = new JButton("Playlist");
		button_3.setBorder(null);
		button_3.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		button_3.setBackground(new Color(255, 255, 51));
		leftPanel.add(button_3);
		JButton button_4 = new JButton("Ultimi");
		button_4.setBorder(null);
		button_4.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		button_4.setBackground(new Color(204, 255, 255));
		leftPanel.add(button_4);
		JButton button_5 = new JButton("Più ascoltati");
		button_5.setBorder(null);
		button_5.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		button_5.setBackground(new Color(153, 255, 255));
		leftPanel.add(button_5);
		
		/*SELECTION PANEL*/
		/*a box layout panel witch contains two panels*/
		JPanel selectionPanel = new JPanel();
		selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.Y_AXIS));
		bigPanel.add(selectionPanel);
		
		/*first panel: grid of records*/
		JPanel listPanel = new JPanel();
		listPanel.setBackground(Color.GRAY);
		listPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		selectionPanel.add(listPanel);
		listPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		/*second panel: information panel about the grid of records. it contains a label*/
		JPanel counterPanel = new JPanel();
		counterPanel.setBackground(Color.DARK_GRAY);
		counterPanel.setMaximumSize(new Dimension(32767, 30));
		selectionPanel.add(counterPanel);				
		/*information label*/
		JLabel counterLabel = new JLabel("Numero brani + minutaggio: ");
		counterLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
		counterLabel.setForeground(new Color(51, 204, 51));
		counterPanel.add(counterLabel);
 
		/*RIGHT PANEL*/
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(new Color(153, 204, 102));
		rightPanel.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    bigPanel.add(rightPanel, BorderLayout.EAST);
	    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
	    
	    /*album/logo image*/
	    File file = new File(pathImage);
	    Image image = ImageIO.read(file);
	    JLabel imageLabel = new JLabel(new ImageIcon(image));	    
	    imageLabel.setPreferredSize(new Dimension((int)(frame.getWidth() * 0.5), 0));
	    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    rightPanel.add(imageLabel);

	    /*label with current song's info*/
	    JLabel currentSongInfo = new JLabel("Current Song's Info");
	    currentSongInfo.setHorizontalAlignment(SwingConstants.CENTER);
	    currentSongInfo.setHorizontalTextPosition(SwingConstants.CENTER);
	    currentSongInfo.setFont(new Font("Dialog", Font.PLAIN, 11));
	    currentSongInfo.setBackground(Color.WHITE);
	    currentSongInfo.setPreferredSize(new Dimension((int)(frame.getWidth() * 0.5), (int)(frame.getHeight() * 0.3)));
	    currentSongInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
	    rightPanel.add(currentSongInfo);   
		
		/*SOUTH PANEL: CONTROL PLAYER'S BUTTONS 
		/*create a new flowlayout*/
		final FlowLayout playerButtonsLayout = new FlowLayout();
		final JPanel playerButtonsPanel = new JPanel(playerButtonsLayout);
		JButton button_8 = new JButton(" << ");
		button_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerButtonsPanel.add(button_8);
		JButton button_7 = new JButton(" ■ ");
		button_7.setForeground(new Color(0, 0, 0));
		playerButtonsPanel.add(button_7);
		JButton button_6 = new JButton(" ► ");
		button_6.setForeground(new Color(0, 128, 0));
		playerButtonsPanel.add(button_6);
		JButton button_9 = new JButton(" >> ");
		button_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerButtonsPanel.add(button_9);
		bigPanel.add(playerButtonsPanel, BorderLayout.SOUTH);
		
		/*TOP MENU
		 *realized with GUI builder*/
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		frame.setJMenuBar(menuBar);
		
		/*jmenu buttons: file, modifica, visualizza, help. Jmenu can contains jmenu items*/
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("SansSerif", Font.PLAIN, 11));
		menuBar.add(mnFile);
		JMenu mnHelp = new JMenu("Info");
		mnHelp.setFont(new Font("SansSerif", Font.PLAIN, 11));
		menuBar.add(mnHelp);
		
		JMenuItem mntmInfoBeesound = new JMenuItem("Info Beesound");
		mntmInfoBeesound.setFont(new Font("Dialog", Font.PLAIN, 11));
		mnHelp.add(mntmInfoBeesound);
		
		/*add choice menu(JMenuItem)for jmenu file*/
		JMenuItem mnFileChoice = new JMenuItem("Import");
		mnFileChoice.setFont(new Font("Dialog", Font.PLAIN, 11));
		mnFile.add(mnFileChoice);
		JMenuItem mnFileChoice_1 = new JMenuItem("Open");
		mnFileChoice_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		mnFile.add(mnFileChoice_1);
		
		JMenuItem mntmClose = new JMenuItem("Exit");
		mntmClose.setFont(new Font("Dialog", Font.PLAIN, 11));
		mnFile.add(mntmClose);

		/*set frame details*/
		frame.getContentPane().add(bigPanel);
		frame.setVisible(true);
	}
	
	/*main*/
	public static void main(String[] args) throws IOException {

		new GUI();
	}
}
