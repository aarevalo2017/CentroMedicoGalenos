/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author QANOVA1
 */
@Entity
@Table(name = "ESTADO_ATENCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoAtencion.findAll", query = "SELECT e FROM EstadoAtencion e")
    , @NamedQuery(name = "EstadoAtencion.findById", query = "SELECT e FROM EstadoAtencion e WHERE e.id = :id")
    , @NamedQuery(name = "EstadoAtencion.findByDescipcion", query = "SELECT e FROM EstadoAtencion e WHERE e.descipcion = :descipcion")})
public class EstadoAtencion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCIPCION")
    private String descipcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoAtencionId")
    private List<AgendaAtencion> agendaAtencionList;

    public EstadoAtencion() {
    }

    public EstadoAtencion(BigDecimal id) {
        this.id = id;
    }

    public EstadoAtencion(BigDecimal id, String descipcion) {
        this.id = id;
        this.descipcion = descipcion;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    @XmlTransient
    public List<AgendaAtencion> getAgendaAtencionList() {
        return agendaAtencionList;
    }

    public void setAgendaAtencionList(List<AgendaAtencion> agendaAtencionList) {
        this.agendaAtencionList = agendaAtencionList;
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
        if (!(object instanceof EstadoAtencion)) {
            return false;
        }
        EstadoAtencion other = (EstadoAtencion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.EstadoAtencion[ id=" + id + " ]";
    }
    
}
