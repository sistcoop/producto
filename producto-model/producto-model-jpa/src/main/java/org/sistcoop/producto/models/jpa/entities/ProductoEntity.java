package org.sistcoop.producto.models.jpa.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.sistcoop.producto.models.enums.TipoPersona;

@Entity
@Table(name = "PRODUCTO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProductoEntity implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    protected String id;
    protected String codigo;
    protected String denominacion;
    protected TipoPersona tipoPersona;
    private String moneda;
    protected boolean estado;

    private Set<CaracteristicaEntity> caracteristicas = new HashSet<CaracteristicaEntity>();
    private Set<TasaEntity> tasas = new HashSet<TasaEntity>();
    private Set<ComisionEntity> comisiones = new HashSet<ComisionEntity>();

    private Timestamp optlk;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Size(min = 1, max = 100)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    @NotNull
    @Size(min = 3, max = 3)
    @NotBlank
    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @NotNull
    @Type(type = "org.hibernate.type.TrueFalseType")
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
    public Set<CaracteristicaEntity> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Set<CaracteristicaEntity> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
    public Set<TasaEntity> getTasas() {
        return tasas;
    }

    public void setTasas(Set<TasaEntity> tasas) {
        this.tasas = tasas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
    public Set<ComisionEntity> getComisiones() {
        return comisiones;
    }

    public void setComisiones(Set<ComisionEntity> comisiones) {
        this.comisiones = comisiones;
    }

    @Version
    public Timestamp getOptlk() {
        return optlk;
    }

    public void setOptlk(Timestamp optlk) {
        this.optlk = optlk;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ProductoEntity))
            return false;
        ProductoEntity other = (ProductoEntity) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
