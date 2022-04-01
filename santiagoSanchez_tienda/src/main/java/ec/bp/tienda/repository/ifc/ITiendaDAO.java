/**
 * 
 */
package ec.bp.tienda.repository.ifc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ec.bp.tienda.repository.entity.Tienda;


/**
 * @author Santiago
 *
 */
public interface ITiendaDAO extends CrudRepository<Tienda, Long>{
	
	@Query("SELECT t FROM Tienda t where upper(t.nombre)=?1 ")
	public Iterable<Tienda> findByNombre(String nombre);

}
