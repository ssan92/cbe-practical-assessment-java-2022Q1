/**
 * 
 */
package ec.bp.tienda.service.dto;


/**
 * @author Santiago
 *
 */
public class TiendaDTO {
	
	private Long idTienda;
	private String nombre;
	private String categoria;
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
	
	

}
