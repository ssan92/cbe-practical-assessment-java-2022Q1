/**
 * 
 */
package ec.bp.tienda.service.ifc;

import ec.bp.tienda.service.dto.Respuesta;
import ec.bp.tienda.service.dto.TiendaDTO;
import ec.bp.tienda.util.exception.ApplicationException;

/**
 * @author Santiago
 *
 */
public interface ITiendaService {
	
    public Iterable<TiendaDTO> consultaByNombre(String nombre);
	
	public Respuesta crearTienda(TiendaDTO peticion) throws ApplicationException;
	
	public Respuesta actualizarTienda(TiendaDTO peticion) throws ApplicationException;
	
	public Respuesta borrarTienda(Long idCliente) throws ApplicationException;

}
