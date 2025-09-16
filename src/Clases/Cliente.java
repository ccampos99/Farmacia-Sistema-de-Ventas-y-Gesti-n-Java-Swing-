package Clases;

public class Cliente {
	
	private int codigocliente;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String dni;
	
	
	public Cliente(int codigocliente, String nombres, String apellidos, String telefono, String dni) {
		this.codigocliente = codigocliente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.dni = dni;
	}


	public int getCodigocliente() {
		return codigocliente;
	}


	public void setCodigocliente(int codigocliente) {
		this.codigocliente = codigocliente;
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
