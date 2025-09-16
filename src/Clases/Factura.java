package Clases;

public class Factura {
	
	private int codigofactura;
	private int codigoproducto;
	private int codigovendedor;
	private int unidades;
	private double precio;
	
	
	public Factura(int codigofactura, int codigoproducto,  int codigovendedor, int unidades, double precio) {
		this.codigofactura = codigofactura;
		this.codigoproducto = codigoproducto;
		this.codigovendedor = codigovendedor;
		this.unidades = unidades;
		this.precio = precio;
	}


	public int getCodigofactura() {
		return codigofactura;
	}


	public void setCodigofactura(int codigofactura) {
		this.codigofactura = codigofactura;
	}


	public int getCodigoproducto() {
		return codigoproducto;
	}


	public void setCodigoproducto(int codigoproducto) {
		this.codigoproducto = codigoproducto;
	}


	public int getCodigovendedor() {
		return codigovendedor;
	}


	public void setCodigovendedor(int codigovendedor) {
		this.codigovendedor = codigovendedor;
	}


	public int getUnidades() {
		return unidades;
	}


	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	
}
