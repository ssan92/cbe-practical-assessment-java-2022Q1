/**
 * 
 */
package ec.bp.tienda.repository.ifc;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ec.bp.tienda.repository.entity.TiendaProducto;
import ec.bp.tienda.repository.entity.TiendaProductoId;

/**
 * @author Santiago
 *
 */
public interface ITiendaProductoDAO extends CrudRepository<TiendaProducto, TiendaProductoId> {
	
	@Query("select t from TiendaProducto t where t.id.tienda.idTienda=?1")
	public List<TiendaProducto> findbyIdTienda(Long idTienda);

}
