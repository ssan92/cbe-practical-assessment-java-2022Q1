/**
 * 
 */
package ec.bp.tienda.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IteratorUtils;
import org.modelmapper.ModelMapper;

import ec.bp.tienda.repository.entity.Producto;
import ec.bp.tienda.service.command.model.Prod;
import ec.bp.tienda.repository.entity.Tienda;
import ec.bp.tienda.service.dto.TiendaDTO;



/**
 * @author Santiago
 *
 */
public class Convert {
	
	public static List<TiendaDTO> tiendaToDTO(Iterable<Tienda> entitys) {
		ModelMapper modelMapper =new ModelMapper();
		List<Tienda> list= IteratorUtils.toList(entitys.iterator());
		List<TiendaDTO> dtos = list
				  .stream()
				  .map(entity -> modelMapper.map(entity, TiendaDTO.class))
				  .collect(Collectors.toList());
		return dtos;
	}
	
	public static Tienda tiendaToDTO(TiendaDTO dto) {
		return new ModelMapper().map(dto, Tienda.class);
	}
	
	public static List<Producto> mockToEntity(List<Prod> list) {
		List<Producto> productos=new ArrayList<Producto>();
		for (Prod prod : list) {
			Producto producto=new Producto();
			producto.setIdProducto(Long.valueOf(prod.getId()));
			producto.setCodigo(prod.getCod());
			producto.setNombre(prod.getName());
			producto.setPrecio(prod.getPrice());
			producto.setStock(prod.getStock());
			productos.add(producto);
		}
		return productos;
	}

}
