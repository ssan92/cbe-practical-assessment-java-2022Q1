/**
 * 
 */
package ec.bp.tienda.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.bp.tienda.constant.TiendaConstant;
import ec.bp.tienda.repository.entity.Producto;
import ec.bp.tienda.repository.entity.Tienda;
import ec.bp.tienda.repository.entity.TiendaProducto;
import ec.bp.tienda.repository.entity.TiendaProductoId;
import ec.bp.tienda.repository.ifc.IProductoDAO;
import ec.bp.tienda.repository.ifc.ITiendaDAO;
import ec.bp.tienda.repository.ifc.ITiendaProductoDAO;
import ec.bp.tienda.service.business.TiendaValidacion;
import ec.bp.tienda.service.command.consumer.ConsultaProductoMockCommand;
import ec.bp.tienda.service.command.model.ConsultaProductoMockRespuesta;
import ec.bp.tienda.service.dto.Respuesta;
import ec.bp.tienda.service.ifc.IProductoService;
import ec.bp.tienda.util.Convert;
import ec.bp.tienda.util.exception.ApplicationException;

/**
 * @author Santiago
 *
 */
@Service
public class ProductoServiceImp implements IProductoService {
	
	@Autowired
	private IProductoDAO repository;
	
	@Autowired
	private ITiendaProductoDAO repoTiendaProd;
	
	@Autowired
	private ITiendaDAO repoTienda;
	
	@Autowired
	private ConsultaProductoMockCommand command;

	@Override
	public Respuesta crearProducto() throws ApplicationException {
		ConsultaProductoMockRespuesta mock= (ConsultaProductoMockRespuesta) command.execute(null);
		List<Producto> list=Convert.mockToEntity(mock.getProds());
		list= TiendaValidacion.validarProducto(list);
		repository.saveAll(list);
		asignarProductoAtienda(list);
		return new Respuesta(TiendaConstant.CODIGO_OK,TiendaConstant.MENSAJE_OK);
	}
	
	public void asignarProductoAtienda(List<Producto> productos) {
		Iterable<Tienda>lisTienda= repoTienda.findAll();
		for (Tienda tienda : lisTienda) {
			for (Producto producto : productos) {
				List<TiendaProducto> list=new ArrayList<TiendaProducto>();
				list.add(new TiendaProducto(new TiendaProductoId(tienda, producto)));
				repoTiendaProd.saveAll(list);
			}
		}
		
		
	}

}
