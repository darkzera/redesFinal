package redesFinal;


import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;




public class Paint {
	public static void main(String[] args) {
		
		
	
	
		
		Icon iconB = new ImageIcon("blue.gif");

		Icon iconM = new ImageIcon("magenta.gif");

		Icon iconR = new ImageIcon("red.gif");

		Icon iconBl = new ImageIcon("black.gif");

		Icon iconG = new ImageIcon("green.gif");

		JFrame frame = new JFrame("Paint It");
		// Creates a frame with a title of "Paint it"

		Container content = frame.getContentPane();
		// Creates a new container
		content.setLayout(new BorderLayout());
		// sets the layout

		final PadDraw drawPad = new PadDraw();
		// creates a new padDraw, which is pretty much the paint program

		content.add(drawPad, BorderLayout.CENTER);
		// sets the padDraw in the center

		JPanel panel = new JPanel();
		// creates a JPanel
		panel.setPreferredSize(new Dimension(62, 98));
		panel.setMinimumSize(new Dimension(62, 98));
		panel.setMaximumSize(new Dimension(62, 98));
		// This sets the size of the panel

		JButton clearButton = new JButton("Clear");
		// creates the clear button and sets the text as "Clear"
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPad.clear();
				
			}
		});
		
		
		JButton stopButton = new JButton("CHEGA");
		// creates the clear button and sets the text as "Clear"
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPad.stop();
				
			}
		});
		
		
		
		
		
		// this is the clear button, which clears the screen. This pretty
		// much attaches an action listener to the button and when the
		// button is pressed it calls the clear() method

		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPad.send();
				
				try {
					SimpleFileServer.main();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});

		
		panel.add(clearButton);
		panel.add(sendButton);
		panel.add(stopButton);
		// adds the buttons to the panel

		content.add(panel, BorderLayout.SOUTH);
		// sets the panel to the left

		frame.setSize(500, 500);
		// sets the size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// makes it so you can close
		frame.setVisible(true);
		// makes it so you can see it
	}

		
	}




	