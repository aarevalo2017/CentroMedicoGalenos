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
@Table(name = "AGENDA_ATENCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgendaAtencion.findAll", query = "SELECT a FROM AgendaAtencion a")
    , @NamedQuery(name = "AgendaAtencion.findById", query = "SELECT a FROM AgendaAtencion a WHERE a.id = :id")
    , @NamedQuery(name = "AgendaAtencion.findByFechaHora", query = "SELECT a FROM AgendaAtencion a WHERE a.fechaHora = :fechaHora")
    , @NamedQuery(name = "AgendaAtencion.findByFechaEstado", query = "SELECT a FROM AgendaAtencion a WHERE a.fechaEstado = :fechaEstado")})
public class AgendaAtencion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ESTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstado;
    @JoinColumn(name = "AGENDA_DISPONIBLE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AgendaDisponible agendaDisponibleId;
    @JoinColumn(name = "ESTADO_ATENCION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EstadoAtencion estadoAtencionId;
    @JoinColumn(name = "MEDICO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Medico medicoId;
    @JoinColumn(name = "PACIENTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Paciente pacienteId;
    @JoinColumn(name = "PAGO_ATENCION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PagoAtencion pagoAtencionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agendaAtencionId")
    private List<Correo> correoList;

    public AgendaAtencion() {
    }

    public AgendaAtencion(BigDecimal id) {
        this.id = id;
    }

    public AgendaAtencion(BigDecimal id, Date fechaHora, Date fechaEstado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.fechaEstado = fechaEstado;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Date getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    public AgendaDisponible getAgendaDisponibleId() {
        return agendaDisponibleId;
    }

    public void setAgendaDisponibleId(AgendaDisponible agendaDisponibleId) {
        this.agendaDisponibleId = agendaDisponibleId;
    }

    public EstadoAtencion getEstadoAtencionId() {
        return estadoAtencionId;
    }

    public void setEstadoAtencionId(EstadoAtencion estadoAtencionId) {
        this.estadoAtencionId = estadoAtencionId;
    }

    public Medico getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Medico medicoId) {
        this.medicoId = medicoId;
    }

    public Paciente getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Paciente pacienteId) {
        this.pacienteId = pacienteId;
    }

    public PagoAtencion getPagoAtencionId() {
        return pagoAtencionId;
    }

    public void setPagoAtencionId(PagoAtencion pagoAtencionId) {
        this.pagoAtencionId = pagoAtencionId;
    }

    @XmlTransient
    public List<Correo> getCorreoList() {
        return correoList;
    }

    public void setCorreoList(List<Correo> correoList) {
        this.correoList = correoList;
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
        if (!(object instanceof AgendaAtencion)) {
            return false;
        }
        AgendaAtencion other = (AgendaAtencion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.AgendaAtencion[ id=" + id + " ]";
    }
    
}
