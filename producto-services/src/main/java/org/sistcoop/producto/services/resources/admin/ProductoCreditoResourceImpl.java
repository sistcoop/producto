package org.sistcoop.producto.services.resources.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.sistcoop.producto.client.resource.ProductoCreditoResource;
import org.sistcoop.producto.models.ProductoCreditoModel;
import org.sistcoop.producto.models.ProductoCreditoProvider;
import org.sistcoop.producto.models.enums.TipoPersona;
import org.sistcoop.producto.models.utils.ModelToRepresentation;
import org.sistcoop.producto.models.utils.RepresentationToModel;
import org.sistcoop.producto.representations.idm.ProductoCreditoRepresentation;

@Stateless
public class ProductoCreditoResourceImpl implements ProductoCreditoResource {

	@Inject
	private ProductoCreditoProvider productoCreditoProvider;

	@Inject
	private RepresentationToModel representationToModel;

	@Context
	protected UriInfo uriInfo;

	@Override
	public ProductoCreditoRepresentation findById(Integer id) {
		ProductoCreditoModel model = productoCreditoProvider.getProductoCreditoById(id);
		ProductoCreditoRepresentation rep = ModelToRepresentation.toRepresentation(model);
		return rep;
	}
	
	@Override
	public ProductoCreditoRepresentation findByCodigo(String codigo) {
		ProductoCreditoModel model = productoCreditoProvider.getProductoCreditoByCodigo(codigo);
		ProductoCreditoRepresentation rep = ModelToRepresentation.toRepresentation(model);
		return rep;
	}
	
	@Override
	public ProductoCreditoRepresentation findByDenominacion(String denominacion) {
		ProductoCreditoModel model = productoCreditoProvider.getProductoByDenominacion(denominacion);
		ProductoCreditoRepresentation rep = ModelToRepresentation.toRepresentation(model);
		return rep;
	}

	@Override
	public Response create(ProductoCreditoRepresentation productoCreditoRepresentation) {
		ProductoCreditoModel model = representationToModel.createProductoCredito(productoCreditoRepresentation, productoCreditoProvider);
		return Response.created(uriInfo.getAbsolutePathBuilder().path(model.getId().toString()).build()).header("Access-Control-Expose-Headers", "Location").entity(model.getId()).build();
	}

	@Override
	public void update(int id, ProductoCreditoRepresentation productoCreditoRepresentacion) {
		ProductoCreditoModel model = productoCreditoProvider.getProductoCreditoById(id);
		
		model.setCodigo(productoCreditoRepresentacion.getCodigo());
		model.setDenominacion(productoCreditoRepresentacion.getDenominacion());
		model.setTipoPersona(TipoPersona.valueOf(productoCreditoRepresentacion.getTipoPersona()));
		model.setMoneda(productoCreditoRepresentacion.getMoneda());
		model.setMontoMinimo(productoCreditoRepresentacion.getMontoMinimo());
		model.setMontoMinimo(productoCreditoRepresentacion.getMontoMinimo());
		model.commit();
	}

	@Override
	public void delete(int id) {
		throw new InternalServerErrorException();
	}

	@Override
	public void desactivar(int id) {
		ProductoCreditoModel model = productoCreditoProvider.getProductoCreditoById(id);
		boolean result = productoCreditoProvider.desactivarProducto(model);
		if (!result)
			throw new InternalServerErrorException();
	}

	@Override
	public List<ProductoCreditoRepresentation> findAll(String tipoPersona, Boolean estado) {
		List<ProductoCreditoModel> list = productoCreditoProvider.getProductos(TipoPersona.valueOf(tipoPersona), estado);
		List<ProductoCreditoRepresentation> result = new ArrayList<ProductoCreditoRepresentation>();
		for (ProductoCreditoModel productoCreditoModel : list) {
			result.add(ModelToRepresentation.toRepresentation(productoCreditoModel));
		}
		return result;
	}

}
