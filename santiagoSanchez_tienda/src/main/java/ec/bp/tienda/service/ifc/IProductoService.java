/**
 * 
 */
package ec.bp.tienda.service.ifc;

import ec.bp.tienda.service.dto.Respuesta;
import ec.bp.tienda.util.exception.ApplicationException;

/**
 * @author Santiago
 *
 */


public interface IProductoService {
	
	public Respuesta crearProducto() throws ApplicationException;
	

}
