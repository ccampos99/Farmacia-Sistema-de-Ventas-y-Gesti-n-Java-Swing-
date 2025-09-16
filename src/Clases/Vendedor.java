package Clases;

public class Vendedor {
	

	private int cd, categoria;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String dni;
	
	public Vendedor(int cd, int categoria, String nombres, String apellidos, String telefono, String dni) {
		this.cd = cd;
		this.categoria = categoria;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.dni = dni;
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
    
	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
}
