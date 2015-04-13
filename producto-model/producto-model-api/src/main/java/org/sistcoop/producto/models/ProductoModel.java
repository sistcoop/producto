package org.sistcoop.producto.models;

import java.util.List;

import org.sistcoop.producto.models.enums.TipoPersona;

public interface ProductoModel extends Model {

	Integer getId();

	String getCodigo();

	String getDenominacion();

	void setDenominacion(String denominacion);

	TipoPersona getTipoPersona();

	void setTipoPersona(TipoPersona tipoPersona);

	boolean getEstado();

	void desactivar();

	List<ProductoTasaModel> getTasas();

}