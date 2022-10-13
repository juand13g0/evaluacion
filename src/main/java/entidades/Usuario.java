package entidades;

public class Usuario {

	private String nombre;
	private String apellidos;
	private String nif;
	private String fechaNacimiento;
	private String email;
	
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellidos, String nif, String fechaNacimiento, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getNif() {
		return nif;
	}
	
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", fechaNacimiento="
				+ fechaNacimiento + ", email=" + email + "]";
	}
	
}
