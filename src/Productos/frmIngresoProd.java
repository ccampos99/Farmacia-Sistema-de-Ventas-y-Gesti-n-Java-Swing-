package Productos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloProducto;
import Clases.Producto;
import jPanel.fondoIngresoProducto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmIngresoProd extends JInternalFrame {
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblPrecio;
	private JTextField txtDescripcion;
	private JLabel lblCodigo_2;
	private JTextField txtPrecio;
	private JComboBox cboOperacion;
	private JLabel lblMan;
	private JTable miTablita;
	private JScrollPane spt;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private DefaultTableModel modelo1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmIngresoProd frame = new frmIngresoProd();
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
	public frmIngresoProd() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1178, 732);
		
		fondoIngresoProducto fip = new fondoIngresoProducto();
		fip.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(fip);
		fip.setLayout(null);
		{
			lblCodigo = new JLabel("Codigo Producto");
			lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodigo.setForeground(Color.BLACK);
			lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblCodigo.setBounds(10, 11, 151, 29);
			fip.add(lblCodigo);
		}
		{
			txtCodigo = new JTextField("");
			txtCodigo.setEditable(false);
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(10, 51, 151, 29);
			fip.add(txtCodigo);
		}
		{
			lblPrecio = new JLabel("Descripcion");
			lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrecio.setForeground(Color.BLACK);
			lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblPrecio.setBounds(10, 91, 111, 29);
			fip.add(lblPrecio);
		}
		{
			txtDescripcion = new JTextField("");
			txtDescripcion.setColumns(10);
			txtDescripcion.setBounds(10, 131, 400, 29);
			fip.add(txtDescripcion);
		}
		{
			lblCodigo_2 = new JLabel("Precio");
			lblCodigo_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodigo_2.setForeground(Color.BLACK);
			lblCodigo_2.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblCodigo_2.setBounds(10, 171, 151, 29);
			fip.add(lblCodigo_2);
		}
		{
			txtPrecio = new JTextField("");
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(10, 211, 151, 29);
			fip.add(txtPrecio);
		}
		{
			cboOperacion = new JComboBox();
			cboOperacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedCboOperacion(e);
				}
			});
			cboOperacion.setModel(new DefaultComboBoxModel(new String[] {"Adicionar", "Consultar", "Modificar", "Eliminar"}));
			cboOperacion.setBounds(198, 51, 212, 29);
			fip.add(cboOperacion);
		}
		{
			lblMan = new JLabel("Mantenimientos");
			lblMan.setForeground(Color.BLACK);
			lblMan.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblMan.setBounds(243, 11, 137, 29);
			fip.add(lblMan);
		}
		{
			spt = new JScrollPane();
			spt.setBounds(10, 274, 737, 377);
			fip.add(spt);
			{
				miTablita = new JTable();
				spt.setViewportView(miTablita);
			}
		}
		{
			btnProcesar = new JButton("Procesar");
			btnProcesar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnProcesar(e);
				}
			});
			btnProcesar.setBounds(198, 173, 212, 29);
			fip.add(btnProcesar);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnBorrar(e);
				}
			});
			btnBorrar.setBounds(198, 211, 212, 29);
			fip.add(btnBorrar);
		}
		
		modelo1 = new DefaultTableModel();
		modelo1.addColumn("CODIGO");
		modelo1.addColumn("DESCRIPCION");
		modelo1.addColumn("PRECIO");
		miTablita.setModel(modelo1);
		
		listar();
	}
	ArregloProducto ap = new ArregloProducto();
	int productoSolicitado = ap.codigoCorrelativo();
	
	
	String leerDescripcion() {
		return txtDescripcion.getText().trim();
	}
	
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	int leerOperacion() {
		return cboOperacion.getSelectedIndex();
	}
	protected void actionPerformedCboOperacion(ActionEvent e) {
		int operacion = leerOperacion();
		 limpiarCampos();
	    switch (operacion) {
	        case 0:
	            if (ap.tamanio() == 0)
	                btnProcesar.setEnabled(true);

	            txtCodigo.setEditable(false);
	            txtCodigo.setText("" + ap.codigoCorrelativo());
	            txtDescripcion.setText("");
	            txtPrecio.setText("");
	            habilitarOpciones(true);
	            txtDescripcion.requestFocus();
	            break;

	        case 1:
	            if (ap.tamanio() > 0) {
	                txtCodigo.setEditable(true);
	                habilitarOpciones(false);
	            }
	            break;

	        case 2:
	            if (!txtCodigo.getText().isEmpty()) {
	                txtCodigo.setEditable(true);
	                habilitarOpciones(true);
	            }
	            break;

	        case 3:
	            if (!txtCodigo.getText().isEmpty()) {
	                txtCodigo.setEditable(true);
	                habilitarOpciones(false);
	            }
	            break;
	    }
	}
	
	private void limpiarCampos() {
	    txtCodigo.setText("");
	    txtDescripcion.setText("");
	    txtPrecio.setText("");
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int operacion = leerOperacion();

	    switch (operacion) {
	        case 0:
	            ingresarProducto();
	            break;

	        case 1:
	            if (!txtCodigo.getText().isEmpty()) {
	                consultarProducto();
	            }
	            break;

	        case 2:
	            if (!txtCodigo.getText().isEmpty()) {
	                modificarProducto();
	            }
	            break;

	        case 3:
	            if (!txtCodigo.getText().isEmpty()) {
	                eliminarProducto();
	            }
	            break;
	    }
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtDescripcion.setText("");
		txtPrecio.setText("");
		txtDescripcion.requestFocus();
	}
	
	void ingresarProducto() {
		int cd = leerCodigo();
		String descripcion = leerDescripcion();
		
		if(descripcion.length()>4) {
			try {
				double precio = leerPrecio();
				Producto nuevo = new Producto(cd,descripcion,precio);
				ap.adicionar(nuevo);
				listar();
				txtCodigo.setText(""+ ap.codigoCorrelativo());
				txtDescripcion.setText("");
				txtPrecio.setText("");
				txtDescripcion.requestFocus();
				
			} catch (Exception e) {
				error("Ingrese precio correcto", txtPrecio);
			}
		} else
			error("Ingrese una descripcion correcta", txtDescripcion);
	}
	void consultarProducto() { 
		if(ap.tamanio()==0) {
			btnProcesar.setEnabled(false);
			habilitarOpciones(false);
			mensaje("No existen productos");
		}
		else 
			try {
				Producto p = ap.buscar(leerCodigo());
				if(p != null) {
					productoSolicitado = p.getCodigoproducto();
					txtDescripcion.setText(p.getDescripcion());
					txtPrecio.setText(""+p.getPrecio());
					txtCodigo.requestFocus();
				}else
					error("El codigo " + leerCodigo()+ "no existe", txtCodigo);
			}
		catch (Exception e) {
			error("Ingrese codigo a consultar", txtCodigo);
		}
	}
	void modificarProducto() {
		int codigo = leerCodigo();
	    Producto p = ap.buscar(codigo);

	    if (p != null) {
	        String descripcion = leerDescripcion();

	        if (descripcion.length() > 0) {
	            String precioTexto = txtPrecio.getText().trim();

	            // Verificar si el precio ingresado es válido
	            if (!precioTexto.isEmpty() && precioTexto.matches("^\\d*\\.?\\d*$")) {
	                double precio = Double.parseDouble(precioTexto);
	                p.setDescripcion(descripcion);
	                p.setPrecio(precio);
	                ap.actualizarArchivo();
	                listar();
	            } else {
	                error("Ingresa un precio válido", txtPrecio);
	            }
	        } else {
	            error("Ingrese descripción correcta", txtDescripcion);
	        }
	    } else {
	        error("El código " + codigo + " no existe", txtCodigo);
	    }
	}
	
	void eliminarProducto() {
		int codigo = leerCodigo();
		int ok = confirmar("Desea eliminar el registro?");
		if(ok ==0) {
			ap.eliminar(codigo);
			listar();
			if(ap.tamanio()>0) {
				productoSolicitado = ap.obtener(0).getCodigoproducto();
				txtCodigo.setText(""+ ap.codigoCorrelativo());
				consultarProducto();
			}
			else {
				productoSolicitado = ap.codigoCorrelativo();
				cboOperacion.setSelectedIndex(0);
			}
		}
	}
	void listar() {
		Producto pc;
		modelo1.setRowCount(0);
		for(int i = 0; i < ap.tamanio(); i++) {
			pc = ap.obtener(i);
			Object[] fila = { pc.getCodigoproducto(),
					pc.getDescripcion(),
					pc.getPrecio()};
			modelo1.addRow(fila);
		}
	}
	void habilitarOpciones(boolean sino) {
		txtDescripcion.setEditable(sino);
		if(leerOperacion()==2);
		txtPrecio.setEditable(sino);
			
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	int confirmar(String s) {
    	return JOptionPane.showConfirmDialog(this, s, "Alerta",0,1,null);
    }
}
