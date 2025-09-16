package jPanel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class fondoIngresoProducto extends javax.swing.JDesktopPane {
	
	public fondoIngresoProducto() {
		this.setSize(400,280);
	}
	
	@Override 
	public void paintComponent(Graphics g) {
		Dimension tamanio = getSize();
		ImageIcon imagenfondo = new ImageIcon(getClass().getResource("/imagenes/ahoraSi.jpg"));
		g.drawImage(imagenfondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
