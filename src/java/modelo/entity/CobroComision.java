/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author QANOVA1
 */
@Entity
@Table(name = "COBRO_COMISION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CobroComision.findAll", query = "SELECT c FROM CobroComision c")
    , @NamedQuery(name = "CobroComision.findById", query = "SELECT c FROM CobroComision c WHERE c.id = :id")
    , @NamedQuery(name = "CobroComision.findByMes", query = "SELECT c FROM CobroComision c WHERE c.mes = :mes")
    , @NamedQuery(name = "CobroComision.findByAnio", query = "SELECT c FROM CobroComision c WHERE c.anio = :anio")
    , @NamedQuery(name = "CobroComision.findByTotalRecaudado", query = "SELECT c FROM CobroComision c WHERE c.totalRecaudado = :totalRecaudado")
    , @NamedQuery(name = "CobroComision.findByPorcentajeAplicado", query = "SELECT c FROM CobroComision c WHERE c.porcentajeAplicado = :porcentajeAplicado")
    , @NamedQuery(name = "CobroComision.findByTotalCobro", query = "SELECT c FROM CobroComision c WHERE c.totalCobro = :totalCobro")})
public class CobroComision implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MES")
    private BigInteger mes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO")
    private BigInteger anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_RECAUDADO")
    private BigInteger totalRecaudado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORCENTAJE_APLICADO")
    private BigDecimal porcentajeAplicado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_COBRO")
    private BigInteger totalCobro;
    @JoinColumn(name = "ESTADO_PAGO_COMISION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EstadoPagoComision estadoPagoComisionId;
    @JoinColumn(name = "MEDICO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Medico medicoId;

    public CobroComision() {
    }

    public CobroComision(BigDecimal id) {
        this.id = id;
    }

    public CobroComision(BigDecimal id, BigInteger mes, BigInteger anio, BigInteger totalRecaudado, BigDecimal porcentajeAplicado, BigInteger totalCobro) {
        this.id = id;
        this.mes = mes;
        this.anio = anio;
        this.totalRecaudado = totalRecaudado;
        this.porcentajeAplicado = porcentajeAplicado;
        this.totalCobro = totalCobro;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getMes() {
        return mes;
    }

    public void setMes(BigInteger mes) {
        this.mes = mes;
    }

    public BigInteger getAnio() {
        return anio;
    }

    public void setAnio(BigInteger anio) {
        this.anio = anio;
    }

    public BigInteger getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTotalRecaudado(BigInteger totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }

    public BigDecimal getPorcentajeAplicado() {
        return porcentajeAplicado;
    }

    public void setPorcentajeAplicado(BigDecimal porcentajeAplicado) {
        this.porcentajeAplicado = porcentajeAplicado;
    }

    public BigInteger getTotalCobro() {
        return totalCobro;
    }

    public void setTotalCobro(BigInteger totalCobro) {
        this.totalCobro = totalCobro;
    }

    public EstadoPagoComision getEstadoPagoComisionId() {
        return estadoPagoComisionId;
    }

    public void setEstadoPagoComisionId(EstadoPagoComision estadoPagoComisionId) {
        this.estadoPagoComisionId = estadoPagoComisionId;
    }

    public Medico getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Medico medicoId) {
        this.medicoId = medicoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobroComision)) {
            return false;
        }
        CobroComision other = (CobroComision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.CobroComision[ id=" + id + " ]";
    }
    
}
