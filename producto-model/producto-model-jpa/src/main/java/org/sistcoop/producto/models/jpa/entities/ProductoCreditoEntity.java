package org.sistcoop.producto.models.jpa.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "PRODUCTO_CREDITO")
@PrimaryKeyJoinColumn
@NamedQueries({
        @NamedQuery(name = "ProductoCreditoEntity.findAll", query = "SELECT p FROM ProductoCreditoEntity p"),
        @NamedQuery(name = "ProductoCreditoEntity.findByCodigo", query = "SELECT p FROM ProductoCreditoEntity p WHERE p.codigo = :codigo") })
public class ProductoCreditoEntity extends ProductoEntity {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private BigDecimal montoMinimo;
    private BigDecimal montoMaximo;

    @NotNull
    @Min(value = 1)
    @Max(value = 1000000)
    public BigDecimal getMontoMinimo() {
        return montoMinimo;
    }

    public void setMontoMinimo(BigDecimal montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    @NotNull
    @Min(value = 1)
    @Max(value = 1000000)
    public BigDecimal getMontoMaximo() {
        return montoMaximo;
    }

    public void setMontoMaximo(BigDecimal montoMaximo) {
        this.montoMaximo = montoMaximo;
    }

}
