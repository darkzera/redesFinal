package redesFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComponent;

class PadDraw extends JComponent {
	Image image;
	// this is gonna be your image that you draw on
	Graphics2D graphics2D;
	// this is what we'll be using to draw on
	int currentX, currentY, oldX, oldY;
	// these are gonna hold our mouse coordinates

	// Now for the constructors
	public PadDraw() {
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				oldX = e.getX();
				oldY = e.getY();
			}
		});
		// if the mouse is pressed it sets the oldX & oldY
		// coordinates as the mouses x & y coordinates
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				currentX = e.getX();
				currentY = e.getY();
				if (graphics2D != null)
					graphics2D.drawLine(oldX, oldY, currentX, currentY);
				repaint();
				oldX = currentX;
				oldY = currentY;
			}

		});
		// while the mouse is dragged it sets currentX & currentY as the mouses x and y
		// then it draws a line at the coordinates
		// it repaints it and sets oldX and oldY as currentX and currentY
	}

	public void paintComponent(Graphics g) {
		if (image == null) {
			image = createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D) image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();

		}
		g.drawImage(image, 0, 0, null);
	}
<<<<<<< HEAD
	public void send() {
		try {
			
			
=======

	public void send() {
		try {

>>>>>>> master
			BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null),
					BufferedImage.TYPE_INT_ARGB);
			// Draw the image on to the buffered image
			Graphics2D bGr = bimage.createGraphics();
			bGr.drawImage(image, 0, 0, null);
			String path = "\\Users\\nicol\\Desktop\\ImagemEnviada.png";
			javax.imageio.ImageIO.write(bimage, "PNG", new File(path));
			bGr.dispose();
			HandlerImage.writeObject(HandlerImage.writeImage(bimage, "PNG"));
			System.out.println("salvo em " + path);
			SimpleFileServer.main();
<<<<<<< HEAD
		
		
			
			
=======
>>>>>>> master

		} catch (Exception e) {
			Logger.getLogger(PadDraw.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void clear() {
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
	}
<<<<<<< HEAD

	public boolean stop(boolean stop) {
		return stop = true;
	}
=======
>>>>>>> master

	public void black() {
		graphics2D.setPaint(Color.black);
		repaint();
	}

}
