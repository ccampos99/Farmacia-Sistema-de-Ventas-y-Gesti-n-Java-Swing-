package Vendedores;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import jPanel.fondoIngresoVendedor;
import javax.swing.JInternalFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import Arreglos.ArregloVendedor;
import Clases.Vendedor;
import Vendedores.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class frmIngresoVen extends JInternalFrame {
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblCategoria;
	JComboBox <String> cboCategoria;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblDni;
	private JTextField txtDni;
	private JButton btnRegistrar;
	private DefaultTableModel modelo9;
	private JTable miTable;
	private JScrollPane scrollPane;
	private JButton btnBorrar;
	private JComboBox cboOperacion;
	private JLabel lblMan;
		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmIngresoVen frame = new frmIngresoVen();
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
	public frmIngresoVen() {
		setTitle("Mantenimiento Vendedores");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1036, 806);
		
		fondoIngresoVendedor iv = new fondoIngresoVendedor();
		iv.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(iv);
		iv.setLayout(null);
		{
			lblCodigo = new JLabel("Codigo Vendedor");
			lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodigo.setForeground(new Color(0, 139, 139));
			lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblCodigo.setBounds(10, 11, 151, 29);
			iv.add(lblCodigo);
		}
		{
			txtCodigo = new JTextField("" + av.codigoCorrelativo());
			txtCodigo.setEditable(false);
			txtCodigo.setBackground(new Color(176, 224, 230));
			txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtCodigo.setForeground(new Color(0, 139, 139));
			txtCodigo.setBounds(10, 51, 151, 29);
			iv.add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		{
			lblCategoria = new JLabel("Categoria");
			lblCategoria.setForeground(new Color(0, 139, 139));
			lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblCategoria.setBounds(199, 11, 96, 29);
			iv.add(lblCategoria);
		}
		{
			cboCategoria = new JComboBox();
			cboCategoria.setForeground(new Color(0, 139, 139));
			cboCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
			cboCategoria.setBackground(new Color(176, 224, 230));
			cboCategoria.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
			cboCategoria.setBounds(171, 51, 151, 29);
			iv.add(cboCategoria);
		}
		{
			lblNombres = new JLabel("Nombres");
			lblNombres.setForeground(new Color(0, 139, 139));
			lblNombres.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNombres.setBounds(38, 91, 96, 29);
			iv.add(lblNombres);
		}
		{
			txtNombres = new JTextField();
			txtNombres.setEditable(false);
			txtNombres.setBackground(new Color(176, 224, 230));
			txtNombres.setColumns(10);
			txtNombres.setBounds(10, 131, 151, 29);
			iv.add(txtNombres);
		}
		{
			lblApellidos = new JLabel("Apellidos");
			lblApellidos.setForeground(new Color(0, 139, 139));
			lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblApellidos.setBounds(199, 91, 96, 29);
			iv.add(lblApellidos);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setEditable(false);
			txtApellidos.setBackground(new Color(176, 224, 230));
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(171, 131, 151, 29);
			iv.add(txtApellidos);
		}
		{
			lblTelefono = new JLabel("Telefono");
			lblTelefono.setForeground(new Color(0, 139, 139));
			lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblTelefono.setBounds(38, 171, 96, 29);
			iv.add(lblTelefono);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setEditable(false);
			txtTelefono.setBackground(new Color(176, 224, 230));
			txtTelefono.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedTxtTelefono(e);
				}
			});
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(10, 211, 151, 29);
			iv.add(txtTelefono);
		}
		{
			lblDni = new JLabel("DNI");
			lblDni.setForeground(new Color(0, 139, 139));
			lblDni.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblDni.setBounds(199, 171, 96, 29);
			iv.add(lblDni);
		}
		{
			txtDni = new JTextField();
			txtDni.setEditable(false);
			txtDni.setBackground(new Color(176, 224, 230));
			txtDni.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedTxtDni(e);
				}
			});
			txtDni.setColumns(10);
			txtDni.setBounds(171, 211, 151, 29);
			iv.add(txtDni);
		}
		{
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnRegistrar(e);
				}
			});
			btnRegistrar.setBounds(38, 251, 96, 39);
			iv.add(btnRegistrar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 301, 1000, 464);
			iv.add(scrollPane);
			{
				miTable = new JTable();
				miTable.setFont(new Font("Tahoma", Font.BOLD, 11));
				miTable.setBackground(new Color(176, 224, 230));
				miTable.setForeground(new Color(0, 139, 139));
				scrollPane.setViewportView(miTable);
			}
		}

		modelo9 = new DefaultTableModel();
		modelo9.addColumn("CÓDIGO");
		modelo9.addColumn("CATEGORIA");
		modelo9.addColumn("NOMBRES");
		modelo9.addColumn("APELLIDOS");
		modelo9.addColumn("TELEFONO");
		modelo9.addColumn("DNI");
		miTable.setModel(modelo9);
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnBorrar(e);
				}
			});
			btnBorrar.setBounds(199, 251, 96, 39);
			iv.add(btnBorrar);
		}
		{
			cboOperacion = new JComboBox();
			cboOperacion.setForeground(new Color(0, 139, 139));
			cboOperacion.setFont(new Font("Tahoma", Font.BOLD, 11));
			cboOperacion.setBackground(new Color(176, 224, 230));
			cboOperacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedCboOperacion(e);
				}
			});
			cboOperacion.setModel(new DefaultComboBoxModel(new String[] {"Adicionar", "Consultar", "Modificar", "Eliminar"}));
			cboOperacion.setBounds(332, 51, 212, 29);
			iv.add(cboOperacion);
		}
		{
			lblMan = new JLabel("Mantenimientos");
			lblMan.setForeground(new Color(0, 139, 139));
			lblMan.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblMan.setBounds(371, 11, 137, 29);
			iv.add(lblMan);
		}
		listar();
		

	}
	
	ArregloVendedor av = new ArregloVendedor();
	int codigoSolicitado = av.codigoCorrelativo();
	
	
	protected void actionPerformedCboOperacion(ActionEvent e) {
	    int posOperacion = leerOperacion();
	    limpiarCampos();

	    switch (posOperacion) {
	        case 0:
	            if (av.tamanio() == 0) {
	                btnRegistrar.setEnabled(true);
	            }

	            txtCodigo.setEditable(false);
	            txtCodigo.setText("" + av.codigoCorrelativo());
	            txtNombres.setText("");
	            txtApellidos.setText("");
	            txtDni.setText("");
	            txtTelefono.setText("");
	            cboCategoria.setSelectedIndex(0); // Asegúrate de que el índice sea 0 para la operación de adición
	            habilitarOpciones(true);
	            txtNombres.requestFocus();
	            break;

	        case 1:
	            txtCodigo.setEditable(true);
	            habilitarOpciones(false); // Deshabilitar campos para consulta
	            break;

	        case 2:
	            txtCodigo.setEditable(true);
	            habilitarOpciones(false); // Deshabilitar campos antes de introducir el código
	            // Aquí deberías consultar el vendedor y habilitar los campos con la información obtenida
	            consultarVendedor();
	            habilitarOpciones(true); // Habilitar campos para modificar después de introducir el código
	            txtNombres.requestFocus();
	            break;
	        case 3:
	            txtCodigo.setEditable(true);
	            habilitarOpciones(false); // Deshabilitar campos para eliminación
	            break;
	    }
	}
	private void limpiarCampos() {
	    txtCodigo.setText("");
	    txtNombres.setText("");
	    txtApellidos.setText("");
	    txtTelefono.setText("");
	    txtDni.setText("");
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		int posOperacion = leerOperacion();
		switch(posOperacion) {
		case 0:
			ingresarVendedor();
			break;
		case 1:
			if (!txtCodigo.getText().isEmpty()) {
                consultarVendedor();
            }
			break;
		case 2:
			if (!txtCodigo.getText().isEmpty()) {
                modificarVendedor();
            }
            break;
		case 3:
			if (!txtCodigo.getText().isEmpty()) {
                eliminarVendedor();
            }
            break;
		}
	}
	
	void ingresarVendedor() {
		int cd = leerCodigo();
		String nombre = leerNombre();
		String apellido = leerApellidos();
		String telefono = leerTelefono();
		
		if(nombre.length()>0 && apellido.length() >0 && telefono.length()>0) {
			String dni = leerDni();
			if(dni.length() >0)
				if(av.buscar(dni)== null)
					try {
						int categoria = leerCategoria();
						Vendedor nuevo = new Vendedor(cd,categoria, nombre, apellido, telefono,dni);
						av.adicionar(nuevo);
						listar();
						txtCodigo.setText("" + av.codigoCorrelativo());
						txtNombres.setText("");
						txtApellidos.setText("");
						txtTelefono.setText("");
						txtDni.setText("");
						txtNombres.requestFocus();
					} catch (Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Fallo: " + e.getMessage());
					}
				else
					error("El DNI " + dni + " ya existe", txtDni);
			else
				error("Ingrese DNI correcto", txtDni);
		}
		else
			errorM("Ingrese NOMBRE, APELLIDO o NUMERO correcto", txtNombres, txtApellidos, txtTelefono);
	}
	void consultarVendedor() {
		if(av.tamanio()==0) {
			btnRegistrar.setEnabled(false);
			habilitarOpciones(false);
			mensaje("No existen vendedores");
		}
		else
			try {
				Vendedor v = av.buscar(leerCodigo());
				if(v != null) {
					codigoSolicitado = v.getCd();
					txtNombres.setText(v.getNombres());
					txtDni.setText(v.getDni());
					txtApellidos.setText(""+v.getApellidos());
					txtTelefono.setText(""+v.getTelefono());
					cboCategoria.setSelectedIndex(v.getCategoria());
					txtCodigo.requestFocus();
				}
				else
					error("El codigo " + leerCodigo() + "no existe", txtCodigo);
			} 
		catch (Exception e) {
				error("Ingrese codigo a consultar", txtCodigo);
			}
	}
	void modificarVendedor() {
		int codigo = leerCodigo();
		Vendedor v = av.buscar(codigo);
		String nombre = leerNombre();
		if(nombre.length()>0)
			try {
				String apellido = leerApellidos();
				try {
					String telefono = leerTelefono();
					int categoria = leerCategoria();
					v.setApellidos(apellido);
					v.setNombres(nombre);
					v.setCategoria(categoria);
					v.setTelefono(telefono);
					av.actualizarArchivo();
					listar();
				} catch (Exception e) {
					error("Ingrese telefono valido", txtTelefono);
				}
			} catch (Exception e) {
				error("Ingrese apellido valido", txtApellidos);
			}
		else {
			error("Ingrese nombre correcto", txtNombres);
		}
	}
	void eliminarVendedor() {
		int codigo = leerCodigo();
		int ok = confirmar("¿Desea eliminar el registro ?");
		if (ok == 0) {
			av.eliminar(codigo);
			listar();
			if (av.tamanio() > 0) {
				codigoSolicitado = av.obtener(0).getCd();
				txtCodigo.setText("" + codigoSolicitado);
				consultarVendedor();
			}
			else {
				codigoSolicitado = av.codigoCorrelativo();
				cboOperacion.setSelectedIndex(0);
			}
		}
	}
	void listar() {
		Vendedor vx;
		modelo9.setRowCount(0);
		for (int i=0; i<av.tamanio(); i++){
			vx = av.obtener(i);
			Object[] fila = { vx.getCd(),
					          enTextoEstadoCivil(vx.getCategoria()),
					          vx.getNombres(),
					          vx.getApellidos(),
					          vx.getTelefono(),
					          vx.getDni()};
			modelo9.addRow(fila);
		}
	}
	//METODOS TIPO VOID CON PARAMETROS
	void habilitarOpciones(boolean sino) {
		txtNombres.setEditable(sino);
		if(leerOperacion()==2)
			txtDni.setEditable(false);
		else
			txtDni.setEditable(sino);
		    txtApellidos.setEditable(sino);
		    txtTelefono.setEditable(sino);
		    cboCategoria.setEnabled(sino);
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void errorM(String s, JTextField txt, JTextField txb, JTextField txd) {
		mensaje(s);
		txt.setText("");
		txb.setText("");
		txd.setText("");
		txt.requestFocus();
	}
	
	//metodos que retornar valor sin parametros
		int leerCodigo() {
			return Integer.parseInt(txtCodigo.getText().trim());
		}
		
		int leerCategoria() {
			return cboCategoria.getSelectedIndex();
		}
		int leerOperacion() {
			return cboOperacion.getSelectedIndex();
		}
		
		String leerNombre() {
			return txtNombres.getText().trim();
		}
		
		String leerApellidos() {
			return txtApellidos.getText().trim();
		}
		
		String leerTelefono() {
			return txtTelefono.getText().trim();
		}
		
		String leerDni() {
			return txtDni.getText().trim();
		}
		//JJJJJ
	    String enTextoEstadoCivil(int i) {
		return cboCategoria.getItemAt(i);
	}
	    int confirmar(String s) {
	    	return JOptionPane.showConfirmDialog(this, s, "Alerta",0,1,null);
	    }
	
	protected void keyTypedTxtTelefono(KeyEvent e) {
		if(!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
	}
	protected void keyTypedTxtDni(KeyEvent e) {
		if(!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
		txtNombres.requestFocus();
	}
}
