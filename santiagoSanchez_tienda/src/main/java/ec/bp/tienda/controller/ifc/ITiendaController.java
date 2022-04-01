/**
 * 
 */
package ec.bp.tienda.controller.ifc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ec.bp.tienda.service.dto.Respuesta;
import ec.bp.tienda.service.dto.TiendaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Santiago
 *
 */
@Api(tags = "TIENDA", description = "Servicios CRUD para tiendas")
public interface ITiendaController {
	
	@ApiOperation(value = "", nickname = "consultaTiendaByNombre", notes = "consultar las tiendas por el nombre", tags={ "TIENDA", },response = TiendaDTO.class, responseContainer = "List")
	@RequestMapping(value = "/tienda/{nombre}",
    produces = "application/json", 
    method = RequestMethod.GET)
	default ResponseEntity<Iterable<TiendaDTO>> consultaTiendaByNombre(@ApiParam(value = "",required=true, example = "tuti") @PathVariable("nombre") String nombre){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@ApiOperation(value = "", nickname = "crearTienda", notes = "crear una tienda", tags={ "TIENDA", },response = Respuesta.class)
	@RequestMapping(value = "/tienda",
    produces = "application/json", 
    method = RequestMethod.POST)
	default ResponseEntity<?> crearTienda(@RequestBody(required = true) TiendaDTO tiendaDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@ApiOperation(value = "", nickname = "actualizarTienda", notes = "actualiza una tienda", tags={ "TIENDA", },response = Respuesta.class)
	@RequestMapping(value = "/tienda",
    produces = "application/json", 
    method = RequestMethod.PUT)
	default ResponseEntity<?> actualizarTienda(@RequestBody(required = true) TiendaDTO tiendaDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@ApiOperation(value = "", nickname = "borrarTienda", notes = "borra una tienda", tags={ "TIENDA", },response = Respuesta.class)
	@RequestMapping(value = "/tienda/{idTienda}",
    produces = "application/json", 
    method = RequestMethod.DELETE)
	default ResponseEntity<?> borrarTienda(@ApiParam(value = "",required=true, example = "1") @PathVariable("idTienda") Long idtienda){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}
