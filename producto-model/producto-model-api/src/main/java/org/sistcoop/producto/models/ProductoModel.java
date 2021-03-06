package org.sistcoop.producto.models;

import java.util.List;

import org.sistcoop.producto.models.enums.TipoPersona;

public interface ProductoModel extends Model {

    String getId();

    String getCodigo();

    String getDenominacion();

    void setDenominacion(String denominacion);

    TipoPersona getTipoPersona();

    void setTipoPersona(TipoPersona tipoPersona);

    String getMoneda();

    boolean getEstado();

    void desactivar();

    List<CaracteristicaModel> getCaracteristicas();

    List<TasaModel> getTasas();

    List<ComisionModel> getComisiones();

}