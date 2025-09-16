package Clases;

public class Producto {
	
	private int codigoproducto;
	private String descripcion;
	private double precio;
	
	public Producto(int codigoproducto, String descripcion, double precio) {
		this.codigoproducto = codigoproducto;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	private int ventasEfectuadas;
    private int unidadesVendidas;
    private double importeTotal;
    
    public int getVentasEfectuadas() {
        return ventasEfectuadas;
    }
    public void resetearVentasEfectuadas() {
        ventasEfectuadas = 0;
        unidadesVendidas = 0;
        importeTotal = 0.0;
    }
    
    public void acumularVentasEfectuadas() {
        ventasEfectuadas++;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void acumularUnidadesVendidas(int unidades) {
        unidadesVendidas = unidades;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void acumularImporteTotal(double importe) {
        importeTotal = importe;
    }

	public int getCodigoproducto() {
		return codigoproducto;
	}


	public void setCodigoproducto(int codigoproducto) {
		this.codigoproducto = codigoproducto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
}
