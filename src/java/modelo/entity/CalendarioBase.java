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
@Table(name = "CALENDARIO_BASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalendarioBase.findAll", query = "SELECT c FROM CalendarioBase c")
    , @NamedQuery(name = "CalendarioBase.findById", query = "SELECT c FROM CalendarioBase c WHERE c.id = :id")
    , @NamedQuery(name = "CalendarioBase.findByFecha", query = "SELECT c FROM CalendarioBase c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CalendarioBase.findByHoraInicio", query = "SELECT c FROM CalendarioBase c WHERE c.horaInicio = :horaInicio")
    , @NamedQuery(name = "CalendarioBase.findByHoraTermino", query = "SELECT c FROM CalendarioBase c WHERE c.horaTermino = :horaTermino")})
public class CalendarioBase implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_TERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaTermino;
    @JoinColumn(name = "LOG_CALENDARIO_BASE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private LogCalendarioBase logCalendarioBaseId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calendarioBaseId")
    private List<AgendaDisponible> agendaDisponibleList;

    public CalendarioBase() {
    }

    public CalendarioBase(BigDecimal id) {
        this.id = id;
    }

    public CalendarioBase(BigDecimal id, Date fecha, Date horaInicio, Date horaTermino) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(Date horaTermino) {
        this.horaTermino = horaTermino;
    }

    public LogCalendarioBase getLogCalendarioBaseId() {
        return logCalendarioBaseId;
    }

    public void setLogCalendarioBaseId(LogCalendarioBase logCalendarioBaseId) {
        this.logCalendarioBaseId = logCalendarioBaseId;
    }

    @XmlTransient
    public List<AgendaDisponible> getAgendaDisponibleList() {
        return agendaDisponibleList;
    }

    public void setAgendaDisponibleList(List<AgendaDisponible> agendaDisponibleList) {
        this.agendaDisponibleList = agendaDisponibleList;
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
        if (!(object instanceof CalendarioBase)) {
            return false;
        }
        CalendarioBase other = (CalendarioBase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.CalendarioBase[ id=" + id + " ]";
    }
    
}
