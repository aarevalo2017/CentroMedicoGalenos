/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CAJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caja.findAll", query = "SELECT c FROM Caja c")
    , @NamedQuery(name = "Caja.findById", query = "SELECT c FROM Caja c WHERE c.id = :id")
    , @NamedQuery(name = "Caja.findByFhApertura", query = "SELECT c FROM Caja c WHERE c.fhApertura = :fhApertura")
    , @NamedQuery(name = "Caja.findByFhCierre", query = "SELECT c FROM Caja c WHERE c.fhCierre = :fhCierre")})
public class Caja implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FH_APERTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fhApertura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FH_CIERRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fhCierre;
    @JoinColumn(name = "COLABORADOR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Colaborador colaboradorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajaId")
    private List<PagoAtencion> pagoAtencionList;

    public Caja() {
    }

    public Caja(BigDecimal id) {
        this.id = id;
    }

    public Caja(BigDecimal id, Date fhApertura, Date fhCierre) {
        this.id = id;
        this.fhApertura = fhApertura;
        this.fhCierre = fhCierre;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFhApertura() {
        return fhApertura;
    }

    public void setFhApertura(Date fhApertura) {
        this.fhApertura = fhApertura;
    }

    public Date getFhCierre() {
        return fhCierre;
    }

    public void setFhCierre(Date fhCierre) {
        this.fhCierre = fhCierre;
    }

    public Colaborador getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Colaborador colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    @XmlTransient
    public List<PagoAtencion> getPagoAtencionList() {
        return pagoAtencionList;
    }

    public void setPagoAtencionList(List<PagoAtencion> pagoAtencionList) {
        this.pagoAtencionList = pagoAtencionList;
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
        if (!(object instanceof Caja)) {
            return false;
        }
        Caja other = (Caja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.Caja[ id=" + id + " ]";
    }
    
}
