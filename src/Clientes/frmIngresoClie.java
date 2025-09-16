package Clientes;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloCliente;
import Clases.Cliente;
import Clases.Vendedor;
import jPanel.fondoIngresoCliente;
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

public class frmIngresoClie extends JInternalFrame {
	private JLabel lblCodigoCliente;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JTextField txtNombres;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblMan;
	private JComboBox cboOperacion;
	private JTable miTablota;
	private JScrollPane spb;
	private DefaultTableModel modelo9;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmIngresoClie frame = new frmIngresoClie();
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
	public frmIngresoClie() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1243, 745);
		
		fondoIngresoCliente fic = new fondoIngresoCliente();
		fic.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(fic);
		fic.setLayout(null);
		{
			lblCodigoCliente = new JLabel("Codigo Cliente");
			lblCodigoCliente.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodigoCliente.setForeground(Color.BLACK);
			lblCodigoCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblCodigoCliente.setBounds(92, 11, 151, 29);
			fic.add(lblCodigoCliente);
		}
		{
			txtCodigo = new JTextField("1001");
			txtCodigo.setEditable(false);
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(10, 51, 312, 29);
			fic.add(txtCodigo);
		}
		{
			lblNombre = new JLabel("Nombres");
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setForeground(Color.BLACK);
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNombre.setBounds(10, 91, 151, 29);
			fic.add(lblNombre);
		}
		{
			txtNombres = new JTextField();
			txtNombres.setColumns(10);
			txtNombres.setBounds(10, 131, 151, 29);
			fic.add(txtNombres);
		}
		{
			lblApellidos = new JLabel("Apellidos");
			lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
			lblApellidos.setForeground(Color.BLACK);
			lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblApellidos.setBounds(171, 91, 151, 29);
			fic.add(lblApellidos);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(171, 131, 151, 29);
			fic.add(txtApellidos);
		}
		{
			lblTelefono = new JLabel("Telefono");
			lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
			lblTelefono.setForeground(Color.BLACK);
			lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblTelefono.setBounds(10, 171, 151, 29);
			fic.add(lblTelefono);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(10, 211, 151, 29);
			fic.add(txtTelefono);
		}
		{
			lblDni = new JLabel("DNI");
			lblDni.setHorizontalAlignment(SwingConstants.CENTER);
			lblDni.setForeground(Color.BLACK);
			lblDni.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblDni.setBounds(171, 171, 151, 29);
			fic.add(lblDni);
		}
		{
			txtDni = new JTextField();
			txtDni.setColumns(10);
			txtDni.setBounds(171, 211, 151, 29);
			fic.add(txtDni);
		}
		{
			lblMan = new JLabel("Mantenimientos");
			lblMan.setForeground(Color.BLACK);
			lblMan.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblMan.setBounds(402, 11, 137, 29);
			fic.add(lblMan);
		}
		{
			cboOperacion = new JComboBox();
			cboOperacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedCboOperacion(e);
				}
			});
			cboOperacion.setModel(new DefaultComboBoxModel(new String[] {"Adicionar", "Consultar", "Modificar", "Eliminar"}));
			cboOperacion.setBounds(357, 51, 212, 29);
			fic.add(cboOperacion);
		}
		{
			spb = new JScrollPane();
			spb.setBounds(10, 270, 765, 391);
			fic.add(spb);
			{
				miTablota = new JTable();
				spb.setViewportView(miTablota);
			}
		}
		
		modelo9 = new DefaultTableModel();
		modelo9.addColumn("CÓDIGO");
		modelo9.addColumn("NOMBRES");
		modelo9.addColumn("APELLIDOS");
		modelo9.addColumn("TELEFONO");
		modelo9.addColumn("DNI");
		miTablota.setModel(modelo9);
		{
			btnRegistrar = new JButton("Ok");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnRegistrar(e);
				}
			});
			btnRegistrar.setBounds(360, 131, 209, 29);
			fic.add(btnRegistrar);
		}
		
		listar();
	}
	
	ArregloCliente ac = new ArregloCliente();
	int codigoSolicitado = ac.codigoCorrelativo();
	private JButton btnRegistrar;
	
	void ingresarVendedor() {
		int cd = leerCodigo();
		String nombre = leerNombre();
		String apellido = leerApellidos();
		String telefono = leerTelefono();
		
		if(nombre.length()>0 && apellido.length() >0 && telefono.length()>0) {
			String dni = leerDni();
			if(dni.length() >0)
				if(ac.buscar(dni)== null)
					try {
						Cliente nuevo = new Cliente(cd, nombre, apellido, telefono,dni);
						ac.adicionar(nuevo);
						listar();
						txtCodigo.setText("" + ac.codigoCorrelativo());
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
		if(ac.tamaño()==0) {
			btnRegistrar.setEnabled(false);
			habilitarOpciones(false);
			mensaje("No existen vendedores");
		}
		else
			try {
				Cliente v = ac.buscar(leerCodigo());
				if(v != null) {
					codigoSolicitado = v.getCodigocliente();
					txtNombres.setText(v.getNombres());
					txtDni.setText(v.getDni());
					txtApellidos.setText(""+v.getApellidos());
					txtTelefono.setText(""+v.getTelefono());
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
		Cliente v = ac.buscar(codigoSolicitado);
		String nombre = leerNombre();
		if(nombre.length()>0)
			try {
				String apellido = leerApellidos();
				try {
					String telefono = leerTelefono();
					v.setApellidos(apellido);
					v.setNombres(nombre);
					v.setTelefono(telefono);
					ac.actualizarArchivo();
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
		int ok = confirmar("� Desea eliminar el registro ?");
		if (ok == 0) {
			ac.eliminar(codigo);
			listar();
			if (ac.tamaño() > 0) {
				codigoSolicitado = ac.obtener(0).getCodigocliente();
				txtCodigo.setText("" + codigoSolicitado);
				consultarVendedor();
			}
			else {
				codigoSolicitado = ac.codigoCorrelativo();
				cboOperacion.setSelectedIndex(0);
			}
		}
	}
	void listar() {
		Cliente vx;
		modelo9.setRowCount(0);
		for (int i=0; i<ac.tamaño(); i++){
			vx = ac.obtener(i);
			Object[] fila = { vx.getCodigocliente(),
					          vx.getNombres(),
					          vx.getApellidos(),
					          vx.getTelefono(),
					          vx.getDni()};
			modelo9.addRow(fila);
		}
	}
	void habilitarOpciones(boolean sino) {
		txtNombres.setEditable(sino);
		if(leerOperacion()==2)
			txtDni.setEditable(false);
		else
			txtDni.setEditable(sino);
		    txtApellidos.setEditable(sino);
		    txtTelefono.setEditable(sino);
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
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
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


    int confirmar(String s) {
    	return JOptionPane.showConfirmDialog(this, s, "Alerta",0,1,null);
    }
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		int posOperacion = leerOperacion();
		switch(posOperacion) {
		case 0:
			ingresarVendedor();
			break;
		case 1:
			consultarVendedor();
			break;
		case 2:
			modificarVendedor();
			break;
		case 3:
			eliminarVendedor();
			break;
		}
	}
	protected void actionPerformedCboOperacion(ActionEvent e) {
		int posOperacion = leerOperacion();
		switch(posOperacion) {
		case 0:
			if(ac.tamaño()==0)
				btnRegistrar.setEnabled(true);
			    txtCodigo.setEditable(false);
			    txtCodigo.setText(""+ ac.codigoCorrelativo());
			    txtNombres.setText("");
			    txtApellidos.setText("");
			    txtDni.setText("");
			    txtTelefono.setText("");
			    habilitarOpciones(true);
			    txtNombres.requestFocus();
			    break;
		case 1:
			if(ac.tamaño()>0)
				txtCodigo.setEditable(true);
			txtCodigo.setText(""+ codigoSolicitado);
			habilitarOpciones(false);
			consultarVendedor();
			txtCodigo.requestFocus();
			break;
		
		case 2:
			txtCodigo.setEditable(true);
			txtCodigo.setText("" + codigoSolicitado);
			habilitarOpciones(true);
			consultarVendedor();
			txtNombres.requestFocus();
			break;
			
		case 3:
			txtCodigo.setEditable(true);
			txtCodigo.setText(""+ codigoSolicitado);
			habilitarOpciones(false);
			consultarVendedor();
		}
	}
}
