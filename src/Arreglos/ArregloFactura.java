package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.Factura;


public class ArregloFactura {
	
	private ArrayList<Factura> fac;
	
	public ArregloFactura() {
		fac = new ArrayList<Factura>();

        cargarFacturas();
	}
	
	public void adicionar(Factura x) {
		fac.add(x);
		grabarFactura();
	}
	
	public int tamanio() {
		return fac.size();
	}
	
	public Factura obtener(int i) {
		return fac.get(i);
	}
	
	public Factura buscar(int codigo) {
		Factura x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if(x.getCodigofactura()==codigo)
				return x;
		}
		return null;
	}
	public void actualizarArchivo() {
		grabarFactura();
	}
	private void grabarFactura() {
		try {
			PrintWriter pw;
			String linea;
			Factura x;
			pw = new PrintWriter(new FileWriter("factura.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigofactura() + ";" +
				        x.getCodigoproducto() + ";"+
						x.getCodigovendedor() + ";"+
				        x.getUnidades() + ";" +
						x.getPrecio();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void cargarFacturas() {
		try {
			BufferedReader br;
			int codigoFactura, codigoProducto,  codigoVendedor, unidades;
			double precio;
			String linea;
	        String[] s;
	        br = new BufferedReader(new FileReader("factura.txt"));
	        while((linea = br.readLine())!=null) {
	        	s = linea.split(";");
	        	codigoFactura = Integer.parseInt(s[0].trim());
	            codigoProducto = Integer.parseInt(s[1].trim());
	        	codigoVendedor = Integer.parseInt(s[2].trim());
	        	unidades = Integer.parseInt(s[3].trim());
	            precio = Double.parseDouble(s[4].trim());
	        	
	        	adicionar(new Factura(codigoFactura,codigoProducto,codigoVendedor,unidades,precio));
	        }
	        
	        br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int codigoCorrelativo() {
		if(tamanio() == 0)
			return 4001;
		else
			return obtener(tamanio()-1).getCodigofactura()+1;
	}
	
	
}
