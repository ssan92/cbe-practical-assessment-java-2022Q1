/**
 * 
 */
package ec.bp.tienda.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import ec.bp.tienda.controller.ifc.IProductoController;
import ec.bp.tienda.service.ifc.IProductoService;
import ec.bp.tienda.util.exception.ApplicationException;

/**
 * @author Santiago
 *
 */
@Controller
public class ProductoControllerImp implements IProductoController {
	
	@Autowired
	private IProductoService service;




	@Override
	public ResponseEntity<?> crearProducto() {
		try {
			return ResponseEntity.ok(service.crearProducto());
		} catch (ApplicationException e) {
			return ApplicationException.validarResultado(e);
		}
	}

	

}
