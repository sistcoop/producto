package org.sistcoop.producto.models.jpa;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sistcoop.producto.models.ProductoCreditoModel;
import org.sistcoop.producto.models.ProductoCuentaPersonalModel;
import org.sistcoop.producto.models.ProductoCuentaPersonalProvider;
import org.sistcoop.producto.models.enums.TipoPersona;

@Named
@Stateless
@Local(ProductoCuentaPersonalProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaProductoProvider implements ProductoCuentaPersonalProvider {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public ProductoCuentaPersonalModel addProductoCredito(String denominacion,
			TipoPersona tipoPersona, List<String> monedas,
			BigDecimal montoMinimo, BigDecimal montoMaximo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean desactivarProducto(ProductoCuentaPersonalModel productoModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductoCuentaPersonalModel getProductoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoCuentaPersonalModel> getProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoCreditoModel> getProductos(TipoPersona tipoPersona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoCreditoModel> getProductos(boolean estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoCreditoModel> getProductos(TipoPersona tipoPersona,
			boolean estado) {
		// TODO Auto-generated method stub
		return null;
	}

}
