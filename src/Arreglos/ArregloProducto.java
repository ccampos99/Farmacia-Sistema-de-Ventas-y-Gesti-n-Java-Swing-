package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.print.attribute.standard.PrinterLocation;

import Clases.Factura;
import Clases.Producto;
import Clases.Vendedor;
public class ArregloProducto {
	
	private ArrayList<Producto> prod;
	
	public ArregloProducto() {
		prod = new ArrayList<Producto>();
		cargarProducto();
	}
	
	public void adicionar(Producto p) {
		prod.add(p);
		grabarProducto();
	}
	
	public int tamanio() {
		return prod.size();
	}
	
	public Producto obtener(int pos) {
		return prod.get(pos);
	}
	public ArrayList<Producto> obtenerProductos(){
		return prod;
	}
	public Producto buscar(int codpro) {
		Producto p;
		for(int i = 0; i < tamanio(); i++) {
			p = obtener(i);
			if(p.getCodigoproducto()==codpro)
				return p;
		}
		return null;
	}
	public Producto buscarPrecio(double precio) {
		Producto p;
		for(int i = 0; i < tamanio(); i++) {
			p = obtener(i);
			if(p.getPrecio()==precio)
				return p;
		}
		return null;
	}
	
	public void eliminar(int codigo) {
		Producto p = buscar(codigo);
		if(p != null) {
		prod.remove(p);
		grabarProducto();
		}else {
			System.out.println("No se encontro un producto con el codigo especificado");
		}
	}
	public void actualizarArchivo() {
		grabarProducto();
	}
	private void grabarProducto() {
		try {
			PrintWriter pw;
			String linea;
			Producto p;
			pw = new PrintWriter(new FileWriter("producto.txt"));
			for(int i = 0; i < tamanio(); i++) {
				p = obtener(i);
				linea = p.getCodigoproducto() + ";"+
				        p.getDescripcion() + ";" +
						p.getPrecio();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}
	public void generarReportePorProducto(ArregloFactura af) {
		for(int i = 0; i < af.tamanio(); i++) {
			Factura factura = af.obtener(i);
			int codigoProducto = factura.getCodigoproducto();
			Producto producto = buscar(codigoProducto);
			if(producto != null) {
				producto.acumularVentasEfectuadas();
				producto.acumularUnidadesVendidas(factura.getUnidades());
				producto.acumularImporteTotal(factura.getPrecio());
			}
		}
	}
	
	public String obtenerInformacionDeReporte() {
        StringBuilder informacion = new StringBuilder();
        for (Producto producto : prod) {
            informacion.append("Código de Producto: ").append(producto.getCodigoproducto()).append("\n");
            informacion.append("Ventas Efectuadas: ").append(producto.getVentasEfectuadas()).append("\n");
            informacion.append("Unidades Vendidas: ").append(producto.getUnidadesVendidas()).append("\n");
            informacion.append("Importe Total: ").append(producto.getImporteTotal()).append("\n\n");
        }
        return informacion.toString();
    }
	
	public void reportePorProducto(int codigoProducto, ArregloFactura af, ArregloVendedor av) {
		Producto producto = buscar(codigoProducto);
		if(producto != null) {
			System.out.println("Reporte de ventas para el producto con código " + codigoProducto + ":\n");
			for(int i = 0; i < af.tamanio(); i++) {
				Factura factura = af.obtener(i);
				if(factura.getCodigoproducto()==codigoProducto) {
					Vendedor vendedor = av.buscar(factura.getCodigovendedor());
						if(vendedor != null) {
							 System.out.println("Código de Factura: " + factura.getCodigofactura());
							 System.out.println("Código de Vendedor: " + vendedor.getCd());
							 System.out.println("Unidades Vendidas: " + factura.getUnidades());
							 System.out.println("Precio Unitario: " + producto.getPrecio());
							 System.out.println("------------------------------------------");
						}
					
				}
			}
		}else {
	        System.out.println("Producto con código " + codigoProducto + " no encontrado.");
	    }
	}
	
	public String obtenerInformacionDeReportePorProducto(int codigoProducto, ArregloFactura af, ArregloVendedor av) {
		Producto producto = buscar(codigoProducto);
		StringBuilder informacion = new StringBuilder();
		
		if(producto != null) {
			informacion.append("Reporte de ventas para el producto con código ").append(codigoProducto).append(":\n\n");
			for(int i = 0; i < af.tamanio(); i++) {
				Factura factura = af.obtener(i);
				if(factura.getCodigoproducto()==codigoProducto) {
					Vendedor vendedor = av.buscar(factura.getCodigovendedor());
					if(vendedor != null) {
						informacion.append("Código de Factura: ").append(factura.getCodigofactura()).append("\n");
						informacion.append("Código de Vendedor: ").append(vendedor.getCd()).append("\n");
						informacion.append("Unidades Vendidas: ").append(factura.getUnidades()).append("\n");
						informacion.append("Precio Unitario: ").append(producto.getPrecio()).append("\n");
	                    informacion.append("------------------------------------------\n");
					}
				}
			}
		} else {
			informacion.append("Producto con código ").append(codigoProducto).append(" no encontrado.");
		}
		return informacion.toString();
	}
	public void resetearVentasEfectuadas() {
        for (Producto producto : prod) {
            producto.resetearVentasEfectuadas();
        }
    }
	private void cargarProducto() {
		try {
			BufferedReader br;
			int codpro;
			String linea, desc;
			double pre;
			String[] s;
			
			br = new BufferedReader(new FileReader("producto.txt"));
			while((linea = br.readLine()) != null) {
				s = linea.split(";");
				codpro = Integer.parseInt(s[0].trim());
				desc = s[1].trim();
				pre = Double.parseDouble(s[2].trim());
				adicionar(new Producto(codpro, desc, pre));
			}
			br.close();
		} catch (Exception e) {
		
		}
	}
	public boolean verificarExistenciaCodigoProducto(int codigoProducto) {
	    return buscar(codigoProducto) != null;
	}
	public int codigoCorrelativo() {
		if(tamanio() == 0)
			return 3001;
		else
			return obtener(tamanio()-1).getCodigoproducto()+1;
	}
	//importante para reporte por precio
	
}
