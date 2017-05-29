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
@Table(name = "LOG_CALENDARIO_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogCalendarioBase.findAll", query = "SELECT l FROM LogCalendarioBase l")
    , @NamedQuery(name = "LogCalendarioBase.findById", query = "SELECT l FROM LogCalendarioBase l WHERE l.id = :id")
    , @NamedQuery(name = "LogCalendarioBase.findByFhCreacion", query = "SELECT l FROM LogCalendarioBase l WHERE l.fhCreacion = :fhCreacion")})
public class LogCalendarioBase implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FH_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fhCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logCalendarioBaseId")
    private List<CalendarioBase> calendarioBaseList;
    @JoinColumn(name = "PERIODO_CALENDARIO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PeriodoCalendario periodoCalendarioId;

    public LogCalendarioBase() {
    }

    public LogCalendarioBase(BigDecimal id) {
        this.id = id;
    }

    public LogCalendarioBase(BigDecimal id, Date fhCreacion) {
        this.id = id;
        this.fhCreacion = fhCreacion;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFhCreacion() {
        return fhCreacion;
    }

    public void setFhCreacion(Date fhCreacion) {
        this.fhCreacion = fhCreacion;
    }

    @XmlTransient
    public List<CalendarioBase> getCalendarioBaseList() {
        return calendarioBaseList;
    }

    public void setCalendarioBaseList(List<CalendarioBase> calendarioBaseList) {
        this.calendarioBaseList = calendarioBaseList;
    }

    public PeriodoCalendario getPeriodoCalendarioId() {
        return periodoCalendarioId;
    }

    public void setPeriodoCalendarioId(PeriodoCalendario periodoCalendarioId) {
        this.periodoCalendarioId = periodoCalendarioId;
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
        if (!(object instanceof LogCalendarioBase)) {
            return false;
        }
        LogCalendarioBase other = (LogCalendarioBase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.LogCalendarioBase[ id=" + id + " ]";
    }
    
}
