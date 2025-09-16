package ventas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import Clases.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloCliente;
import Arreglos.ArregloFactura;
import Arreglos.ArregloProducto;
import Arreglos.ArregloVendedor;
import jPanel.fondoVentas;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmVentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JTextField txtVendedor;
	private JLabel lblCodigoCliente;
	private JTextField txtCliente;
	private JLabel lblCodigoProducto;
	private JTextField txtProducto;
	private JLabel lblUnidades;
	private JTextField txtUnidades;
	private JLabel lblConfirmar;
	private JLabel lblNewLabel_1;
	private JTable miTablet;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo9;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmVentas dialog = new frmVentas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmVentas() {
		setTitle("Realizar Ventas");
		setBounds(100, 100, 1029, 756);
		fondoVentas fv = new fondoVentas();
		fv.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(fv);
		fv.setLayout(null);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
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
			lblCodigo = new JLabel("Codigo Vendedor");
			lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodigo.setForeground(new Color(0, 139, 139));
			lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblCodigo.setBounds(10, 11, 151, 29);
			fv.add(lblCodigo);
		}
		{
			txtVendedor = new JTextField("");
			txtVendedor.setForeground(new Color(0, 139, 139));
			txtVendedor.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtVendedor.setBackground(new Color(176, 224, 230));
			txtVendedor.setColumns(10);
			txtVendedor.setBounds(10, 51, 151, 29);
			fv.add(txtVendedor);
		}
		{
			lblCodigoCliente = new JLabel("Codigo Cliente");
			lblCodigoCliente.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodigoCliente.setForeground(new Color(0, 139, 139));
			lblCodigoCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblCodigoCliente.setBounds(171, 11, 151, 29);
			fv.add(lblCodigoCliente);
		}
		{
			txtCliente = new JTextField("");
			txtCliente.setForeground(new Color(0, 139, 139));
			txtCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtCliente.setBackground(new Color(176, 224, 230));
			txtCliente.setColumns(10);
			txtCliente.setBounds(171, 51, 151, 29);
			fv.add(txtCliente);
		}
		{
			lblCodigoProducto = new JLabel("Codigo Producto");
			lblCodigoProducto.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodigoProducto.setForeground(new Color(0, 139, 139));
			lblCodigoProducto.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblCodigoProducto.setBounds(10, 110, 151, 29);
			fv.add(lblCodigoProducto);
		}
		{
			txtProducto = new JTextField("");
			txtProducto.setForeground(new Color(0, 139, 139));
			txtProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtProducto.setBackground(new Color(176, 224, 230));
			txtProducto.setColumns(10);
			txtProducto.setBounds(10, 150, 151, 29);
			fv.add(txtProducto);
		}
		{
			lblUnidades = new JLabel("Unidades");
			lblUnidades.setHorizontalAlignment(SwingConstants.CENTER);
			lblUnidades.setForeground(new Color(0, 139, 139));
			lblUnidades.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblUnidades.setBounds(171, 110, 151, 29);
			fv.add(lblUnidades);
		}
		{
			txtUnidades = new JTextField("");
			txtUnidades.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtUnidades.setForeground(new Color(0, 139, 139));
			txtUnidades.setBackground(new Color(176, 224, 230));
			txtUnidades.setColumns(10);
			txtUnidades.setBounds(171, 150, 151, 29);
			fv.add(txtUnidades);
		}
		{
			lblConfirmar = new JLabel("");
			lblConfirmar.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mousePressedLblConfirmar(e);
				}
			});
			lblConfirmar.setIcon(new ImageIcon(frmVentas.class.getResource("/imagenes/si.png")));
			lblConfirmar.setBounds(56, 202, 63, 63);
			fv.add(lblConfirmar);
		}
		{
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(frmVentas.class.getResource("/imagenes/no.png")));
			lblNewLabel_1.setBounds(216, 202, 63, 63);
			fv.add(lblNewLabel_1);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 282, 993, 424);
			fv.add(scrollPane);
			{
				miTablet = new JTable();
				scrollPane.setViewportView(miTablet);
			}
		}
		setLocationRelativeTo(null);
		
		modelo9 = new DefaultTableModel();
		modelo9.addColumn("CODIGO CLIENTE");
		modelo9.addColumn("CODIGO VENDEDOR");
		modelo9.addColumn("CODIGO PRODUCTO");
		modelo9.addColumn("DESCRIPCION");
		modelo9.addColumn("PRECIO UNITARIO");
		modelo9.addColumn("IMPORTE SUBTOTAL");
		modelo9.addColumn("IMPORTE IGV");
		modelo9.addColumn("TOTAL PAGAR");
		miTablet.setModel(modelo9);
		
		
	}
	ArregloFactura af = new ArregloFactura();
	ArregloProducto ap = new ArregloProducto();
	ArregloCliente ac = new ArregloCliente();
	ArregloVendedor av = new ArregloVendedor();
	int codigoSolicitado = af.codigoCorrelativo();
	
	void generarFactura() {
		int codProducto = leerCodProducto();
	    int codVendedor = leerCodVendedor();
	    int codCliente = leerCodCliente();
	    int unidadesVenta = leerUnidadesVenta();
	    
	 // Verificar existencia de códigos
	    if (!ap.verificarExistenciaCodigoProducto(codProducto)) {
	        JOptionPane.showMessageDialog(null, "Código de producto no encontrado");
	        return; // Salir del método si el producto no existe
	    }// en caso no exista 

	    if (!av.verificarExistenciaCodigoVendedor(codVendedor)) {
	        JOptionPane.showMessageDialog(null, "Código de vendedor no encontrado");
	        return; // Salir del método si el vendedor no existe
	    }

	    if (!ac.verificarExistenciaCodigoCliente(codCliente)) {
	        JOptionPane.showMessageDialog(null, "Código de cliente no encontrado");
	        return; // Salir del método si el cliente no existe
	    }
	    
	    Producto producto = ap.buscar(codProducto); // previamente obtenido del arreglo
	    Vendedor vendedor = av.buscar(codVendedor);
	    Cliente cliente = ac.buscar(codCliente);
	    //variables con operaciones simples 
	    double precioUnitaro = producto.getPrecio();
	    double subtotal = unidadesVenta * precioUnitaro;
	    double igv = subtotal * 0.18;
	    double totalPagar = subtotal + igv;
	    
	    Factura nuevaFactura = new Factura(af.codigoCorrelativo(),codProducto, codVendedor, unidadesVenta, totalPagar);
	    af.adicionar(nuevaFactura);
	    
	    Object[] fila = {codCliente, codVendedor, codProducto, producto.getDescripcion(), precioUnitaro,
	    		subtotal, igv, totalPagar};//Object permite objetos de todo tipo de valores para luego poder agregarlos a la tabla 
	    modelo9.addRow(fila);
	}
	void verificarCodProd() {
		int codProducto = leerCodProducto();
		if(!ap.verificarExistenciaCodigoProducto(codProducto)) {
			JOptionPane.showMessageDialog(null, "Código de Producto no encontrado");

		}
	}
	void verificarCodVendedor() {
		int codVendedor = leerCodVendedor();
		if(!av.verificarExistenciaCodigoVendedor(codVendedor)) {
			JOptionPane.showMessageDialog(null, "Código de Vendedor no encontrado");

		}
	}
	void verificarCodCliente() {
		int codCliente = leerCodCliente();
		if(!ac.verificarExistenciaCodigoCliente(codCliente)) {
			JOptionPane.showMessageDialog(null, "Código de cliente no encontrado");
		}
	}
	int leerCodProducto () {
		return Integer.parseInt(txtProducto.getText().trim());
	}
	int leerCodVendedor () {
		return Integer.parseInt(txtVendedor.getText().trim());
	}
	int leerCodCliente () {
		return Integer.parseInt(txtCliente.getText().trim());
	}
	int leerUnidadesVenta () {
		return Integer.parseInt(txtUnidades.getText().trim());
	}
	protected void mousePressedLblConfirmar(MouseEvent e) {
		try {
			generarFactura();
			JOptionPane.showMessageDialog(null, "Venta realizada");
			txtVendedor.setText("");
			txtCliente.setText("");
			txtProducto.setText("");
			txtUnidades.setText("");
			txtVendedor.requestFocus();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "FALLO");
		}
		
	}
}
