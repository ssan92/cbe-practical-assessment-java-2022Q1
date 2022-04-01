/**
 * 
 */
package ec.bp.tienda.repository.ifc;

import org.springframework.data.repository.CrudRepository;

import ec.bp.tienda.repository.entity.Producto;

/**
 * @author Santiago
 *
 */
public interface IProductoDAO extends CrudRepository<Producto, Long> {

}
