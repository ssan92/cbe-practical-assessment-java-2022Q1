/**
 * 
 */
package ec.bp.tienda.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Santiago
 *
 */
@Entity
@Table(name = "Tienda")
public class Tienda implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tienda")
	private Long idTienda;
	
	@Column(length = 30)
	private String nombre;
	
	@Column(length = 30)
	private String categoria;
	
	@Column(name="usuario_propietario",length = 30)
	private String usuarioPropietario;

	public Long getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(Long idTienda) {
		this.idTienda = idTienda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getUsuarioPropietario() {
		return usuarioPropietario;
	}

	public void setUsuarioPropietario(String usuarioPropietario) {
		this.usuarioPropietario = usuarioPropietario;
	}
	
	public Tienda(Long idTienda) {
		this.idTienda = idTienda;
	}
	
	public Tienda() {
	}

}
