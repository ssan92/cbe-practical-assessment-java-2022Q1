package ec.bp.tienda.service.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ec.bp.tienda.constant.TiendaConstant;
import ec.bp.tienda.repository.entity.Producto;
import ec.bp.tienda.repository.entity.Tienda;
import ec.bp.tienda.repository.ifc.ITiendaDAO;
import ec.bp.tienda.service.dto.TiendaDTO;
import ec.bp.tienda.util.exception.ApplicationException;
import ec.bp.tienda.util.exception.Error.TipoErrorEnum;

/**
 * @author Santiago
 * 
 * */

public class TiendaValidacion {
	
	public static void validarCamposTienda(TiendaDTO peticion ) throws ApplicationException{
		if(peticion.getCategoria()==null || "".equals(peticion.getCategoria())) {
			throw new ApplicationException(TiendaConstant.CATEGORIA,TipoErrorEnum.SOLICITUD_INVALIDA);
		}
		if(peticion.getNombre()==null || "".equals(peticion.getNombre())) {
			throw new ApplicationException(TiendaConstant.NOMBRE_TIENDA,TipoErrorEnum.SOLICITUD_INVALIDA);
		}
	}
	
	public static Tienda validarTienda(ITiendaDAO repoTienda,Long idTienda)throws ApplicationException{
		Optional<Tienda> optional= repoTienda.findById(idTienda);
		if(optional.isEmpty()) {
			throw new ApplicationException(TiendaConstant.NO_TIENDA+idTienda,TipoErrorEnum.SOLICITUD_INVALIDA);
		}
		return optional.get();
	}
	
	public static List<Producto> validarProducto(List<Producto> list)throws ApplicationException{
		List<Producto> newList=new ArrayList<Producto>();
		for (Producto producto : list) {
			if((producto.getStock()>5)) {
				newList.add(producto);
			}
		}
		return newList;
		
	}

}
