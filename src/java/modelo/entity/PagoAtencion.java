/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author QANOVA1
 */
@Entity
@Table(name = "PAGO_ATENCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoAtencion.findAll", query = "SELECT p FROM PagoAtencion p")
    , @NamedQuery(name = "PagoAtencion.findById", query = "SELECT p FROM PagoAtencion p WHERE p.id = :id")
    , @NamedQuery(name = "PagoAtencion.findByMonto", query = "SELECT p FROM PagoAtencion p WHERE p.monto = :monto")
    , @NamedQuery(name = "PagoAtencion.findByFechaHora", query = "SELECT p FROM PagoAtencion p WHERE p.fechaHora = :fechaHora")})
public class PagoAtencion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO")
    private BigInteger monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagoAtencionId")
    private List<AgendaAtencion> agendaAtencionList;
    @JoinColumn(name = "CAJA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Caja cajaId;

    public PagoAtencion() {
    }

    public PagoAtencion(BigDecimal id) {
        this.id = id;
    }

    public PagoAtencion(BigDecimal id, BigInteger monto, Date fechaHora) {
        this.id = id;
        this.monto = monto;
        this.fechaHora = fechaHora;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getMonto() {
        return monto;
    }

    public void setMonto(BigInteger monto) {
        this.monto = monto;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @XmlTransient
    public List<AgendaAtencion> getAgendaAtencionList() {
        return agendaAtencionList;
    }

    public void setAgendaAtencionList(List<AgendaAtencion> agendaAtencionList) {
        this.agendaAtencionList = agendaAtencionList;
    }

    public Caja getCajaId() {
        return cajaId;
    }

    public void setCajaId(Caja cajaId) {
        this.cajaId = cajaId;
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
        if (!(object instanceof PagoAtencion)) {
            return false;
        }
        PagoAtencion other = (PagoAtencion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.PagoAtencion[ id=" + id + " ]";
    }
    
}
