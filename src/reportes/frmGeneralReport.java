package reportes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloFactura;
import Arreglos.ArregloProducto;
import Arreglos.ArregloVendedor;
import Clases.Producto;
import jPanel.fondoReportes;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class frmGeneralReport extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblGeneralPorProductos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmGeneralReport dialog = new frmGeneralReport();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmGeneralReport() {
		setTitle("Reportes Generales");
		setBounds(100, 100, 1108, 849);
		fondoReportes fr = new fondoReportes();
		fr.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(fr);
		fr.setLayout(null);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			lblGeneralPorProductos = new JLabel("");
			lblGeneralPorProductos.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mousePressedLblGeneralPorProductos(e);
				}
			});
			lblGeneralPorProductos.setIcon(new ImageIcon(frmGeneralReport.class.getResource("/imagenes/finalProducto.png")));
			lblGeneralPorProductos.setBounds(10, 48, 154, 86);
			fr.add(lblGeneralPorProductos);
		}
		{
			JLabel lblGPP = new JLabel("Reporte general por productos:");
			lblGPP.setForeground(new Color(0, 139, 139));
			lblGPP.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblGPP.setBounds(10, 23, 201, 14);
			fr.add(lblGPP);
		}
		{
			JLabel lblGPV = new JLabel("Reporte general por vendedores:");
			lblGPV.setForeground(new Color(0, 139, 139));
			lblGPV.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblGPV.setBounds(10, 163, 211, 14);
			fr.add(lblGPV);
		}
		{
			lblGeneralVendedores = new JLabel("");
			lblGeneralVendedores.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mousePressedLblGeneralVendedores(e);
				}
			});
			lblGeneralVendedores.setIcon(new ImageIcon(frmGeneralReport.class.getResource("/imagenes/finalVendedor.png")));
			lblGeneralVendedores.setBounds(20, 188, 154, 86);
			fr.add(lblGeneralVendedores);
		}
		{
			JLabel lblReportePorVendedor = new JLabel("Reporte por vendedor:");
			lblReportePorVendedor.setForeground(new Color(0, 139, 139));
			lblReportePorVendedor.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblReportePorVendedor.setBounds(10, 307, 211, 14);
			fr.add(lblReportePorVendedor);
		}
		{
			lblPorVendedor = new JLabel("");
			lblPorVendedor.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mousePressedLblPorVendedor(e);
				}
			});
			lblPorVendedor.setIcon(new ImageIcon(frmGeneralReport.class.getResource("/imagenes/ase.png")));
			lblPorVendedor.setBounds(10, 333, 154, 86);
			fr.add(lblPorVendedor);
		}
		{
			JLabel lblReportePorProducto = new JLabel("Reporte por producto:");
			lblReportePorProducto.setForeground(new Color(0, 139, 139));
			lblReportePorProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblReportePorProducto.setBounds(10, 430, 211, 14);
			fr.add(lblReportePorProducto);
		}
		{
			lblPorProducto = new JLabel("");
			lblPorProducto.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mousePressedLblPorProducto(e);
				}
			});
			lblPorProducto.setIcon(new ImageIcon(frmGeneralReport.class.getResource("/imagenes/product.png")));
			lblPorProducto.setBounds(20, 455, 154, 86);
			fr.add(lblPorProducto);
		}
		{
			JLabel lblReporteDePrecios = new JLabel("Reporte de precios:");
			lblReporteDePrecios.setForeground(new Color(0, 139, 139));
			lblReporteDePrecios.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblReporteDePrecios.setBounds(10, 552, 211, 14);
			fr.add(lblReporteDePrecios);
		}
		{
			JLabel lblPrecios = new JLabel("");
			lblPrecios.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mousePressedLblPrecios(e);
				}
			});
			lblPrecios.setIcon(new ImageIcon(frmGeneralReport.class.getResource("/imagenes/daw.png")));
			lblPrecios.setBounds(20, 577, 154, 86);
			fr.add(lblPrecios);
		}
		{
			txtCodigoVendedor = new JTextField();
			txtCodigoVendedor.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mousePressedTxtCodigoVendedor(e);
				}
			});
			txtCodigoVendedor.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtCodigoVendedor.setForeground(new Color(0, 139, 139));
			txtCodigoVendedor.setBackground(new Color(176, 224, 230));
			txtCodigoVendedor.setBounds(192, 305, 86, 20);
			fr.add(txtCodigoVendedor);
			txtCodigoVendedor.setColumns(10);
		}
		{
			txtCodigoProducto = new JTextField();
			txtCodigoProducto.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mousePressedTxtCodigoProducto(e);
				}
			});
			txtCodigoProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtCodigoProducto.setForeground(new Color(0, 139, 139));
			txtCodigoProducto.setBackground(new Color(176, 224, 230));
			txtCodigoProducto.setColumns(10);
			txtCodigoProducto.setBounds(192, 428, 86, 20);
			fr.add(txtCodigoProducto);
		}
		{
			lblSiCero = new JLabel("");
			lblSiCero.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mousePressedLblSiCero(e);
				}
			});
			lblSiCero.setIcon(new ImageIcon(frmGeneralReport.class.getResource("/imagenes/si.png")));
			lblSiCero.setBounds(202, 332, 63, 63);
			fr.add(lblSiCero);
		}
		{
			lblSiUno = new JLabel("");
			lblSiUno.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mousePressedLblSiUno(e);
				}
			});
			lblSiUno.setIcon(new ImageIcon(frmGeneralReport.class.getResource("/imagenes/si.png")));
			lblSiUno.setBounds(202, 455, 63, 63);
			fr.add(lblSiUno);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(621, 23, 461, 776);
			fr.add(scrollPane);
			{
				txtS = new JTextArea();
				txtS.setEditable(false);
				txtS.setBackground(new Color(176, 224, 230));
				txtS.setForeground(new Color(0, 139, 139));
				txtS.setFont(new Font("Monospaced", Font.BOLD, 13));
				scrollPane.setViewportView(txtS);
			}
		}
		{
			JLabel lblPorPrecaucinAsegurese = new JLabel("Por precaución, asegurese de presionar tres veces cada opción a ejecutar!");
			lblPorPrecaucinAsegurese.setForeground(new Color(0, 139, 139));
			lblPorPrecaucinAsegurese.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPorPrecaucinAsegurese.setBounds(10, 779, 525, 20);
			fr.add(lblPorPrecaucinAsegurese);
		}
		
		setLocationRelativeTo(null);
	}
	//INSTANCIAMENTO DE ARREGLOS----------------
    ArregloProducto prod = new ArregloProducto();
 	ArregloFactura fac = new ArregloFactura();
 	ArregloVendedor ven = new ArregloVendedor();
 	//------------------------------------------
 	private JTextField txtCodigoVendedor;
 	private JTextField txtCodigoProducto;
 	private JTextArea txtS;
 	private JLabel lblPorProducto;
 	private JLabel lblSiUno;
 	private JLabel lblPorVendedor;
 	private JLabel lblSiCero;
 	private JLabel lblGeneralVendedores;
 	
 	//REPORTE GENERAL POR PRODUCTOS----------
 	protected void mousePressedLblGeneralPorProductos(MouseEvent e) {
 		prod.resetearVentasEfectuadas();
		prod.generarReportePorProducto(fac);
		txtS.setText(prod.obtenerInformacionDeReporte());
	}
	//REPORTE DE PRECIOS---------------------
	protected void mousePressedLblPrecios(MouseEvent e) {
		txtS.setText("");
		generarReporteDePrecios();
	}
	
	public  void generarReporteDePrecios() {
        double precioPromedio = 0.0;
        double precioMayor = Double.MIN_VALUE;
        double precioMenor = Double.MAX_VALUE;
        ArrayList<Producto> productos = prod.obtenerProductos();
        
        for (Producto producto : productos) {
            double precio = producto.getPrecio();
            precioPromedio += precio;

            if (precio > precioMayor) {
                precioMayor = precio;
            }

            if (precio < precioMenor) {
                precioMenor = precio;
            }
        }

        int cantidadProductos = productos.size();
        precioPromedio /= cantidadProductos;

        txtS.append("Precio Promedio: " + precioPromedio+"\n");
        txtS.append("Precio Mayor: " + precioMayor+"\n");
        txtS.append("Precio Menor: " + precioMenor+"\n");
    }
	//------------------------------------------
	//REPORTE GENERAL POR VENDEDORES------------
	protected void mousePressedLblGeneralVendedores(MouseEvent e) {
		ven.resetearVentasEfectuadas();
		ven.generarReportePorVendedores(fac);
		txtS.setText(ven.obtenerInformacionDeReportePorVendedores());
	}
	//------------------------------------------
	//REPORTE POR VENDEDOR----------------------
	int leerCodigoVendedor() {
		return Integer.parseInt(txtCodigoVendedor.getText().trim());
	}
	protected void mousePressedLblPorVendedor(MouseEvent e) {
		txtCodigoProducto.setEnabled(true);
		lblSiUno.setEnabled(true);
		lblPorProducto.setEnabled(true);
		try {
		reportePorVendedor();
		txtCodigoVendedor.setText("");
		}catch(Exception ad) {
			JOptionPane.showMessageDialog(null, "Introduza el codigo respectivo antes de ejecutar el reporte");
		}
	}
	protected void mousePressedLblSiCero(MouseEvent e) {
		try {
			int codigoVendedor = leerCodigoVendedor();
			System.out.println("Codigo vendedor: " + codigoVendedor);
			}catch(Exception ep) {
				JOptionPane.showMessageDialog(null, "Por favor introduce un codigo de vendedor");
			}
	}
	
	void reportePorVendedor() {
		int codigoVendedor = leerCodigoVendedor();
		ven.generarReportePorVendedor(codigoVendedor, fac, prod);
		txtS.setText(ven.obtenerInformacionDeReportePorVendedor(codigoVendedor, fac, prod));
	}
	//-------------------------------------------
	//REPORTE POR PRODUCTO-----------------------
	int leerCodigoProducto() {
		return Integer.parseInt(txtCodigoProducto.getText().trim());
	}
	
	protected void mousePressedLblPorProducto(MouseEvent e) {
		txtCodigoVendedor.setEnabled(true);
		lblSiCero.setEnabled(true);
		lblPorVendedor.setEnabled(true);
		try {
		reportePorProducto();
		txtCodigoProducto.setText("");
		}catch(Exception ed) {
			JOptionPane.showMessageDialog(null, "Introduzca el codigo respectivo antes de ejecutar el reporte");
		}
	}
	
	void reportePorProducto() {
		int codigoProducto = leerCodigoProducto();
		prod.reportePorProducto(codigoProducto, fac, ven);
		txtS.setText(prod.obtenerInformacionDeReportePorProducto(codigoProducto, fac, ven));
	}
	protected void mousePressedLblSiUno(MouseEvent e) {
		try {
			int codigoProducto = leerCodigoProducto();
			System.out.println("Codigo Producto: " + codigoProducto);
		
			}catch(Exception ed) {
				JOptionPane.showMessageDialog(null, "Por favor introduce un codigo de producto");
			}
	}
	//-------------------------------------------
	protected void mousePressedTxtCodigoVendedor(MouseEvent e) {
		txtCodigoProducto.setEnabled(false);
		lblSiUno.setEnabled(false);
		lblPorProducto.setEnabled(false);
	}
	protected void mousePressedTxtCodigoProducto(MouseEvent e) {
		txtCodigoVendedor.setEnabled(false);
		lblSiCero.setEnabled(false);
		lblPorVendedor.setEnabled(false);
	}
	//-----------------------

}
