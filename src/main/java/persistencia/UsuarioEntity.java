package persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(length=50, nullable=false, unique=false)
	private String nombre;
	
	@Column(length=50, nullable=false, unique=false)
	private String apellidos;
	
	@Column(length=9, nullable=false, unique=true)
	private String nif;
	
	@Column(name = "fecha_nacimiento",length=20, nullable=false, unique=false)
	private String fechaNacimiento;
	
	@Column(length=50, nullable=false, unique=false)
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "UsuarioEntity [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif
				+ ", fechaNacimiento=" + fechaNacimiento + ", email=" + email + "]";
	}
	
}
