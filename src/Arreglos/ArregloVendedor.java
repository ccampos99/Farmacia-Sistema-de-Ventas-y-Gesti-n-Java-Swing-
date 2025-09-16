package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.Factura;
import Clases.Producto;
import Clases.Vendedor;
public class ArregloVendedor {
	
	private ArrayList<Vendedor> ven;
	
	//Constructor
	public ArregloVendedor() {
		ven = new ArrayList <Vendedor> ();
		cargarPersonas();
	}
	
	//Operaciones publicas basicas
	
	public void adicionar(Vendedor x) {
		ven.add(x);
		grabarVendedor();
	}
	
	public int tamanio() {
		return ven.size();
	}
	
	public Vendedor obtener(int i) {
		return ven.get(i);
	}
	
	public Vendedor buscar(int cd) {
		Vendedor x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if(x.getCd()==cd)
				return x;
		}
		return null;
	}
	
	public Vendedor buscar(String dni) {
		Vendedor x;
		for(int i = 0; i < tamanio(); i ++) {
			x = obtener(i);
			if(x.getDni().equals(dni))
				return x;
		}
		return null;
	}
	
	public void eliminar(int codigo) {
		Vendedor x = buscar(codigo);
		if(x != null) {
		ven.remove(x);
		grabarVendedor();
		} else {
			System.out.println("No se encontro un vendedor con el codigo especificado");
		}
	}
	
	public void actualizarArchivo() {
		grabarVendedor();
	}
	public void resetearVentasEfectuadas() {
		for(Vendedor vendedor: ven) {
			vendedor.resetearVentasEfectuadas();
		}
	}
	public void generarReportePorVendedores(ArregloFactura af) {
		for(int i = 0; i < af.tamanio(); i++) {
			Factura factura = af.obtener(i);
			int codigoVendedor = factura.getCodigovendedor();
			Vendedor vendedor = buscar(codigoVendedor);
			if(vendedor !=null) {
				vendedor.acumularVentasEfectuadas();
				vendedor.acumularUnidadesVendidas(factura.getUnidades());
				vendedor.acumularImporteTotal(factura.getPrecio());
			}
		}
	}
	
	public String obtenerInformacionDeReportePorVendedores() {
		StringBuilder informacion = new StringBuilder();
		for(Vendedor vendedor : ven) {
			informacion.append("Código de Vendedor: ").append(vendedor.getCd()).append("\n");
	        informacion.append("Ventas Efectuadas: ").append(vendedor.getVentasEfectuadas()).append("\n");
	        informacion.append("Unidades Vendidas: ").append(vendedor.getUnidadesVendidas()).append("\n");
	        informacion.append("Importe Total: ").append(vendedor.getImporteTotal()).append("\n\n");
		}
		return informacion.toString();
	}
	
	public void generarReportePorVendedor(int codigoVendedor, ArregloFactura af, ArregloProducto ap) {
	    Vendedor vendedor = buscar(codigoVendedor);
	    if (vendedor != null) {
	        System.out.println("Reporte de ventas para el vendedor con código " + codigoVendedor + ":\n");
	        for (int i = 0; i < af.tamanio(); i++) {
	            Factura factura = af.obtener(i);
	            if (factura.getCodigovendedor() == codigoVendedor) {
	                Producto producto = ap.buscar(factura.getCodigoproducto());
	                if (producto != null) {
	                    System.out.println("Código de Factura: " + factura.getCodigofactura());
	                    System.out.println("Código de Producto: " + producto.getCodigoproducto());
	                    System.out.println("Unidades Vendidas: " + factura.getUnidades());
	                    System.out.println("Precio Unitario: " + producto.getPrecio());
	                    System.out.println("------------------------------------------");
	                }
	            }
	        }
	    } else {
	        System.out.println("Vendedor con código " + codigoVendedor + " no encontrado.");
	    }
	}
	
	public String obtenerInformacionDeReportePorVendedor(int codigoVendedor, ArregloFactura af, ArregloProducto ap) {
	    Vendedor vendedor = buscar(codigoVendedor);
	    StringBuilder informacion = new StringBuilder();
	    
	    if (vendedor != null) {
	        informacion.append("Reporte de ventas para el vendedor con código ").append(codigoVendedor).append(":\n\n");
	        for (int i = 0; i < af.tamanio(); i++) {
	            Factura factura = af.obtener(i);
	            if (factura.getCodigovendedor() == codigoVendedor) {
	                Producto producto = ap.buscar(factura.getCodigoproducto());
	                if (producto != null) {
	                    informacion.append("Código de Factura: ").append(factura.getCodigofactura()).append("\n");
	                    informacion.append("Código de Producto: ").append(producto.getCodigoproducto()).append("\n");
	                    informacion.append("Unidades Vendidas: ").append(factura.getUnidades()).append("\n");
	                    informacion.append("Precio Unitario: ").append(producto.getPrecio()).append("\n");
	                    informacion.append("------------------------------------------\n");
	                }
	            }
	        }
	    } else {
	        informacion.append("Vendedor con código ").append(codigoVendedor).append(" no encontrado.");
	    }
	    
	    return informacion.toString();
	}
	private void grabarVendedor() {
		try {
			PrintWriter pw;
			String linea;
			Vendedor x;
			pw = new PrintWriter(new FileWriter("vendedor.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCd() + ";" +
					    x.getCategoria() + ";" +
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
			int cd, categoria;
			String linea, nombres, apellidos, telefono, dni;
			String[] s;
			
			br = new BufferedReader(new FileReader("vendedor.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				cd = Integer.parseInt(s[0].trim());
				categoria = Integer.parseInt(s[1].trim());
				nombres = s[2].trim();
				apellidos = s[3].trim();
				telefono = s[4].trim();
				dni = s[5].trim();
				adicionar(new Vendedor(cd, categoria, nombres, apellidos, telefono, dni ));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	//jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
	public boolean verificarExistenciaCodigoVendedor(int codigoVendedor) {
	    return buscar(codigoVendedor) != null; //retorna siempre cuando no sea nulo
	}
	//Codigo automatico
	public int codigoCorrelativo() {
		if(tamanio()== 0)
			return 2001;
		else 
			return obtener(tamanio()-1).getCd()+1;
	}
}


















