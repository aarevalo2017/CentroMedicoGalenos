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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "AGENDA_DISPONIBLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgendaDisponible.findAll", query = "SELECT a FROM AgendaDisponible a")
    , @NamedQuery(name = "AgendaDisponible.findById", query = "SELECT a FROM AgendaDisponible a WHERE a.id = :id")
    , @NamedQuery(name = "AgendaDisponible.findByEstado", query = "SELECT a FROM AgendaDisponible a WHERE a.estado = :estado")})
public class AgendaDisponible implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private BigInteger estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agendaDisponibleId")
    private List<AgendaAtencion> agendaAtencionList;
    @JoinColumn(name = "CALENDARIO_BASE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CalendarioBase calendarioBaseId;
    @JoinColumn(name = "HORA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Hora horaId;
    @JoinColumn(name = "MEDICO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Medico medicoId;

    public AgendaDisponible() {
    }

    public AgendaDisponible(BigDecimal id) {
        this.id = id;
    }

    public AgendaDisponible(BigDecimal id, BigInteger estado) {
        this.id = id;
        this.estado = estado;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<AgendaAtencion> getAgendaAtencionList() {
        return agendaAtencionList;
    }

    public void setAgendaAtencionList(List<AgendaAtencion> agendaAtencionList) {
        this.agendaAtencionList = agendaAtencionList;
    }

    public CalendarioBase getCalendarioBaseId() {
        return calendarioBaseId;
    }

    public void setCalendarioBaseId(CalendarioBase calendarioBaseId) {
        this.calendarioBaseId = calendarioBaseId;
    }

    public Hora getHoraId() {
        return horaId;
    }

    public void setHoraId(Hora horaId) {
        this.horaId = horaId;
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
        if (!(object instanceof AgendaDisponible)) {
            return false;
        }
        AgendaDisponible other = (AgendaDisponible) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.AgendaDisponible[ id=" + id + " ]";
    }
    
}
