package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.Cliente;
import Clases.Vendedor;

public class ArregloCliente {
	private ArrayList<Cliente> clie;
	
	//Constructor
	public ArregloCliente() {
		clie= new ArrayList <Cliente> ();
		cargarPersonas();
	}
	
	public void adicionar (Cliente x) {
		 clie.add(x);
		 grabarCliente();// tambien se adiciona en el txt
	}
	
	public int tamaño() {
		return clie.size();
	}
	
	public Cliente obtener(int i) {
		return clie.get(i);
	}
	
	public Cliente buscar(int cd) {
		Cliente x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if(x.getCodigocliente()==cd)
				return x;
		}
		return null;
	}
	public boolean verificarExistenciaCodigoCliente(int codigoCliente) {
		return buscar(codigoCliente) != null;
	}
	public Cliente buscar(String dni) {
		Cliente x;
		for(int i = 0; i < tamaño(); i ++) {
			x = obtener(i);
			if(x.getDni().equals(dni))
				return x;
		}
		return null;
	}
	public void eliminar(int codigo) {
		Cliente x = buscar(codigo);
		if(x != null) {
		clie.remove(x);
		grabarCliente();
		}else {
			System.out.println("No se encontro un cliente con el codigo especificado");
		}
	}
	
	public void actualizarArchivo() {
		grabarCliente();
	}
	private void grabarCliente() {
		try {
			PrintWriter pw;
			String linea;
			Cliente x;
			pw = new PrintWriter(new FileWriter("cliente.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigocliente() + ";" +
						x.getNombres() + ";" +
						x.getApellidos() + ";" +
						x.getTelefono() + ";" +
						x.getDni();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarPersonas() {
		try {
			BufferedReader br;
			int cd;
			String linea, nombres, apellidos, telefono, dni;
			String[] s;
			
			br = new BufferedReader(new FileReader("cliente.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				cd = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				telefono = s[3].trim();
				dni = s[4].trim();
				adicionar(new Cliente(cd, nombres, apellidos, telefono, dni ));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	//Codigo automatico
	public int codigoCorrelativo() {
		if(tamaño()== 0)
			return 1001;
		else 
			return obtener(tamaño()-1).getCodigocliente()+1;
	}
}
