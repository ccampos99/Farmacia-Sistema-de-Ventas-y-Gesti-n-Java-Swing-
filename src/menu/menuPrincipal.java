package menu;

import java.awt.EventQueue;
import java.awt.MenuBar;
import Vendedores.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clientes.frmIngresoClie;
import Productos.frmIngresoProd;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;

import jPanel.ImagenesDeFondo;
import reportes.frmGeneralReport;
import ventas.frmVentas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
public class menuPrincipal extends JFrame {

	private JPanel cP;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnReportes;
	private JMenuItem mntmRealizar;
	private JMenuItem mntmRPE;
	private JDesktopPane desktopPane;
	private ImagenesDeFondo Escritorio;
	private JMenuBar menuBar;
	private JMenuItem mntmVendedores;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProductos;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
					frame.setExtendedState(MAXIMIZED_BOTH);
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
	public menuPrincipal() {
		setBackground(new Color(224, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1047, 742);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.setBackground(new Color(176, 224, 230));
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setForeground(new Color(0, 139, 139));
		mnMantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnMantenimiento.setIcon(new ImageIcon(menuPrincipal.class.getResource("/imagenes/mant.png")));
		menuBar.add(mnMantenimiento);
		{
			mntmVendedores = new JMenuItem("Vendedores");
			mntmVendedores.setForeground(new Color(0, 139, 139));
			mntmVendedores.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mntmVendedores.setBackground(new Color(176, 224, 230));
			mntmVendedores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedMntmVendedores(e);
				}
			});
			mnMantenimiento.add(mntmVendedores);
		}
		{
			mntmClientes = new JMenuItem("Clientes");
			mntmClientes.setForeground(new Color(0, 139, 139));
			mntmClientes.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mntmClientes.setBackground(new Color(176, 224, 230));
			mntmClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedMntmClientes(e);
				}
			});
			mnMantenimiento.add(mntmClientes);
		}
		{
			mntmProductos = new JMenuItem("Productos");
			mntmProductos.setForeground(new Color(0, 139, 139));
			mntmProductos.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mntmProductos.setBackground(new Color(176, 224, 230));
			mntmProductos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedMntmProductos(e);
				}
			});
			mnMantenimiento.add(mntmProductos);
		}
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setForeground(new Color(0, 139, 139));
		mnVentas.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnVentas.setIcon(new ImageIcon(menuPrincipal.class.getResource("/imagenes/tienda.png")));
		menuBar.add(mnVentas);
		{
			mntmRealizar = new JMenuItem("Realizar Venta");
			mntmRealizar.setForeground(new Color(0, 139, 139));
			mntmRealizar.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mntmRealizar.setBackground(new Color(176, 224, 230));
			mntmRealizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedMntmRealizar(e);
				}
			});
			mntmRealizar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));
			mnVentas.add(mntmRealizar);
		}
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setForeground(new Color(0, 139, 139));
		mnReportes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnReportes.setIcon(new ImageIcon(menuPrincipal.class.getResource("/imagenes/ver.png")));
		menuBar.add(mnReportes);
		{
			mntmRPE = new JMenuItem("Reportes Generales");
			mntmRPE.setForeground(new Color(0, 139, 139));
			mntmRPE.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mntmRPE.setBackground(new Color(176, 224, 230));
			mntmRPE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedMntmRPE(e);
				}
			});
			mnReportes.add(mntmRPE);
		}
		cP = new JPanel();
		cP.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(cP);
		cP.setLayout(new BorderLayout(0, 0));
		
		{
			Escritorio = new ImagenesDeFondo();
			Escritorio.setBorder(new EmptyBorder(5, 5, 5, 5));
			Escritorio.setLayout(new BorderLayout(0,0));
			cP.add(Escritorio, BorderLayout.CENTER);
		}
	}
	protected void actionPerformedMntmVendedores(ActionEvent e) {
		frmIngresoVen fiv = new frmIngresoVen();
		fiv.setVisible(true);
		Escritorio.add(fiv);
	}
	protected void actionPerformedMntmClientes(ActionEvent e) {
		frmIngresoClie fic = new frmIngresoClie();
		fic.setVisible(true);
		Escritorio.add(fic);
	}
	protected void actionPerformedMntmProductos(ActionEvent e) {
		frmIngresoProd fip = new frmIngresoProd();
		fip.setVisible(true);
		Escritorio.add(fip);
	}
	
	protected void actionPerformedMntmRealizar(ActionEvent e) {
		frmVentas fv = new frmVentas();
	    fv.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		fv.setVisible(true);
	}
	
	protected void actionPerformedMntmRPE(ActionEvent e) {
		frmGeneralReport fg = new frmGeneralReport();
		fg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		fg.setVisible(true);
	}
}
