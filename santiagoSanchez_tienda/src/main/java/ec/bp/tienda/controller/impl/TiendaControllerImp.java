/**
 * 
 */
package ec.bp.tienda.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import ec.bp.tienda.controller.ifc.ITiendaController;
import ec.bp.tienda.service.dto.TiendaDTO;
import ec.bp.tienda.service.ifc.ITiendaService;
import ec.bp.tienda.util.exception.ApplicationException;

/**
 * @author Santiago
 *
 */
@Controller
public class TiendaControllerImp implements ITiendaController {
	
	@Autowired
	private ITiendaService service;

	@Override
	public ResponseEntity<Iterable<TiendaDTO>> consultaTiendaByNombre(String nombre) {
		return ResponseEntity.ok(service.consultaByNombre(nombre));
	}

	@Override
	public ResponseEntity<?> crearTienda(TiendaDTO tiendaDTO) {
		try {
			return ResponseEntity.ok(service.crearTienda(tiendaDTO));
		} catch (ApplicationException e) {
			return ApplicationException.validarResultado(e);
		}
	}

	@Override
	public ResponseEntity<?> actualizarTienda(TiendaDTO tiendaDTO) {
		try {
			return ResponseEntity.ok(service.crearTienda(tiendaDTO));
		} catch (ApplicationException e) {
			return ApplicationException.validarResultado(e);
		}
	}

	@Override
	public ResponseEntity<?> borrarTienda(Long idtienda) {
		try {
			return ResponseEntity.ok(service.borrarTienda(idtienda));
		} catch (ApplicationException e) {
			return ApplicationException.validarResultado(e);
		}
	}

}
