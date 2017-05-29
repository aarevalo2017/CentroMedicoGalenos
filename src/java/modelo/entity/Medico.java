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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MEDICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findById", query = "SELECT m FROM Medico m WHERE m.id = :id")
    , @NamedQuery(name = "Medico.findByObs", query = "SELECT m FROM Medico m WHERE m.obs = :obs")
    , @NamedQuery(name = "Medico.findByComision", query = "SELECT m FROM Medico m WHERE m.comision = :comision")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 255)
    @Column(name = "OBS")
    private String obs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMISION")
    private BigDecimal comision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoId")
    private List<AgendaAtencion> agendaAtencionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoId")
    private List<CobroComision> cobroComisionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoId")
    private List<AgendaDisponible> agendaDisponibleList;
    @JoinColumn(name = "COLABORADOR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Colaborador colaboradorId;
    @JoinColumn(name = "ESPECIALIDAD_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Especialidad especialidadId;

    public Medico() {
    }

    public Medico(BigDecimal id) {
        this.id = id;
    }

    public Medico(BigDecimal id, BigDecimal comision) {
        this.id = id;
        this.comision = comision;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    @XmlTransient
    public List<AgendaAtencion> getAgendaAtencionList() {
        return agendaAtencionList;
    }

    public void setAgendaAtencionList(List<AgendaAtencion> agendaAtencionList) {
        this.agendaAtencionList = agendaAtencionList;
    }

    @XmlTransient
    public List<CobroComision> getCobroComisionList() {
        return cobroComisionList;
    }

    public void setCobroComisionList(List<CobroComision> cobroComisionList) {
        this.cobroComisionList = cobroComisionList;
    }

    @XmlTransient
    public List<AgendaDisponible> getAgendaDisponibleList() {
        return agendaDisponibleList;
    }

    public void setAgendaDisponibleList(List<AgendaDisponible> agendaDisponibleList) {
        this.agendaDisponibleList = agendaDisponibleList;
    }

    public Colaborador getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Colaborador colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public Especialidad getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(Especialidad especialidadId) {
        this.especialidadId = especialidadId;
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
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.Medico[ id=" + id + " ]";
    }
    
}
