package redesFinal;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class Paint {

	public static void main(String[] args) throws IOException {

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
		panel.setPreferredSize(new Dimension(32, 68));
		panel.setMinimumSize(new Dimension(32, 68));
		panel.setMaximumSize(new Dimension(32, 68));
		// This sets the size of the panel

		JButton clearButton = new JButton("Clear");
		// creates the clear button and sets the text as "Clear"
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPad.clear();

			}
		});

		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPad.send();

			}
		});

		panel.add(clearButton);
		panel.add(sendButton);

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
