/**
 * 
 */
package ec.bp.tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.bp.tienda.util.Convert;
import ec.bp.tienda.constant.TiendaConstant;
import ec.bp.tienda.repository.ifc.ITiendaDAO;
import ec.bp.tienda.service.business.TiendaValidacion;
import ec.bp.tienda.service.dto.Respuesta;
import ec.bp.tienda.service.dto.TiendaDTO;
import ec.bp.tienda.service.ifc.ITiendaService;
import ec.bp.tienda.util.exception.ApplicationException;

/**
 * @author Santiago
 *
 */
@Service
@Transactional( rollbackFor = ApplicationException.class)
public class TiendaServiceImp implements ITiendaService{
	
	@Autowired
	private ITiendaDAO repository;

	@Override
	public Iterable<TiendaDTO> consultaByNombre(String nombre) {
		return Convert.tiendaToDTO(repository.findByNombre(nombre.toUpperCase()));	
	}

	@Override
	public Respuesta crearTienda(TiendaDTO peticion) throws ApplicationException {
		TiendaValidacion.validarCamposTienda(peticion);
		repository.save(Convert.tiendaToDTO(peticion));
		return new Respuesta(TiendaConstant.CODIGO_OK,TiendaConstant.MENSAJE_OK);
	}

	@Override
	public Respuesta actualizarTienda(TiendaDTO peticion) throws ApplicationException {
		TiendaValidacion.validarCamposTienda(peticion);
		repository.save(Convert.tiendaToDTO(peticion));
		return new Respuesta(TiendaConstant.CODIGO_OK,TiendaConstant.MENSAJE_OK);
	}

	@Override
	public Respuesta borrarTienda(Long idCliente) throws ApplicationException {
		repository.delete(TiendaValidacion.validarTienda(repository, idCliente));
		return new Respuesta(TiendaConstant.CODIGO_OK,TiendaConstant.MENSAJE_OK);
	}
	
	

}
