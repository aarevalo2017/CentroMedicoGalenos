/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author QANOVA1
 */
@Entity
@Table(name = "CORREO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correo.findAll", query = "SELECT c FROM Correo c")
    , @NamedQuery(name = "Correo.findById", query = "SELECT c FROM Correo c WHERE c.id = :id")
    , @NamedQuery(name = "Correo.findByFechaHora", query = "SELECT c FROM Correo c WHERE c.fechaHora = :fechaHora")})
public class Correo implements Serializable {

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
    @JoinColumn(name = "AGENDA_ATENCION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AgendaAtencion agendaAtencionId;
    @JoinColumn(name = "ESTADO_CORREO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EstadoCorreo estadoCorreoId;
    @JoinColumn(name = "TIPO_CORREO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TipoCorreo tipoCorreoId;

    public Correo() {
    }

    public Correo(BigDecimal id) {
        this.id = id;
    }

    public Correo(BigDecimal id, Date fechaHora) {
        this.id = id;
        this.fechaHora = fechaHora;
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

    public AgendaAtencion getAgendaAtencionId() {
        return agendaAtencionId;
    }

    public void setAgendaAtencionId(AgendaAtencion agendaAtencionId) {
        this.agendaAtencionId = agendaAtencionId;
    }

    public EstadoCorreo getEstadoCorreoId() {
        return estadoCorreoId;
    }

    public void setEstadoCorreoId(EstadoCorreo estadoCorreoId) {
        this.estadoCorreoId = estadoCorreoId;
    }

    public TipoCorreo getTipoCorreoId() {
        return tipoCorreoId;
    }

    public void setTipoCorreoId(TipoCorreo tipoCorreoId) {
        this.tipoCorreoId = tipoCorreoId;
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
        if (!(object instanceof Correo)) {
            return false;
        }
        Correo other = (Correo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.Correo[ id=" + id + " ]";
    }
    
}
