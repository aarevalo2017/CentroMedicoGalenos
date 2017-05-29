/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author QANOVA1
 */
@Entity
@Table(name = "PERIODO_CALENDARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodoCalendario.findAll", query = "SELECT p FROM PeriodoCalendario p")
    , @NamedQuery(name = "PeriodoCalendario.findById", query = "SELECT p FROM PeriodoCalendario p WHERE p.id = :id")
    , @NamedQuery(name = "PeriodoCalendario.findByMesDesde", query = "SELECT p FROM PeriodoCalendario p WHERE p.mesDesde = :mesDesde")
    , @NamedQuery(name = "PeriodoCalendario.findByMesHasta", query = "SELECT p FROM PeriodoCalendario p WHERE p.mesHasta = :mesHasta")})
public class PeriodoCalendario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MES_DESDE")
    private BigInteger mesDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MES_HASTA")
    private BigInteger mesHasta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodoCalendarioId")
    private List<LogCalendarioBase> logCalendarioBaseList;

    public PeriodoCalendario() {
    }

    public PeriodoCalendario(BigDecimal id) {
        this.id = id;
    }

    public PeriodoCalendario(BigDecimal id, BigInteger mesDesde, BigInteger mesHasta) {
        this.id = id;
        this.mesDesde = mesDesde;
        this.mesHasta = mesHasta;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getMesDesde() {
        return mesDesde;
    }

    public void setMesDesde(BigInteger mesDesde) {
        this.mesDesde = mesDesde;
    }

    public BigInteger getMesHasta() {
        return mesHasta;
    }

    public void setMesHasta(BigInteger mesHasta) {
        this.mesHasta = mesHasta;
    }

    @XmlTransient
    public List<LogCalendarioBase> getLogCalendarioBaseList() {
        return logCalendarioBaseList;
    }

    public void setLogCalendarioBaseList(List<LogCalendarioBase> logCalendarioBaseList) {
        this.logCalendarioBaseList = logCalendarioBaseList;
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
        if (!(object instanceof PeriodoCalendario)) {
            return false;
        }
        PeriodoCalendario other = (PeriodoCalendario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.PeriodoCalendario[ id=" + id + " ]";
    }
    
}
