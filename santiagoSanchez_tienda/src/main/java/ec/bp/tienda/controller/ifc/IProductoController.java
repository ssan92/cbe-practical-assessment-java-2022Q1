/**
 * 
 */
package ec.bp.tienda.controller.ifc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ec.bp.tienda.service.dto.Respuesta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Santiago
 *
 */
@Api(tags = "PRODUCTO", description = "Servicios CRUD para productos")
public interface IProductoController {
	
	
	
	@ApiOperation(value = "", nickname = "crearProducto", notes = "crear una producto", tags={ "PRODUCTO", },response = Respuesta.class)
	@RequestMapping(value = "/producto",
    produces = "application/json", 
    method = RequestMethod.POST)
	default ResponseEntity<?> crearProducto() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
}
