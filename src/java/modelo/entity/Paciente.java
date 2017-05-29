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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author QANOVA1
 */
@Entity
@Table(name = "PACIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findById", query = "SELECT p FROM Paciente p WHERE p.id = :id")
    , @NamedQuery(name = "Paciente.findByRut", query = "SELECT p FROM Paciente p WHERE p.rut = :rut")
    , @NamedQuery(name = "Paciente.findByDv", query = "SELECT p FROM Paciente p WHERE p.dv = :dv")
    , @NamedQuery(name = "Paciente.findByNombres", query = "SELECT p FROM Paciente p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "Paciente.findByApePaterno", query = "SELECT p FROM Paciente p WHERE p.apePaterno = :apePaterno")
    , @NamedQuery(name = "Paciente.findByApeMaterno", query = "SELECT p FROM Paciente p WHERE p.apeMaterno = :apeMaterno")
    , @NamedQuery(name = "Paciente.findByFechaNac", query = "SELECT p FROM Paciente p WHERE p.fechaNac = :fechaNac")
    , @NamedQuery(name = "Paciente.findByFono1", query = "SELECT p FROM Paciente p WHERE p.fono1 = :fono1")
    , @NamedQuery(name = "Paciente.findByFono2", query = "SELECT p FROM Paciente p WHERE p.fono2 = :fono2")
    , @NamedQuery(name = "Paciente.findByMail", query = "SELECT p FROM Paciente p WHERE p.mail = :mail")
    , @NamedQuery(name = "Paciente.findByHashPass", query = "SELECT p FROM Paciente p WHERE p.hashPass = :hashPass")
    , @NamedQuery(name = "Paciente.findByEstado", query = "SELECT p FROM Paciente p WHERE p.estado = :estado")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT")
    private int rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DV")
    private String dv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "APE_PATERNO")
    private String apePaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "APE_MATERNO")
    private String apeMaterno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "FONO_1")
    private String fono1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "FONO_2")
    private String fono2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "MAIL")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "HASH_PASS")
    private String hashPass;
    @Column(name = "ESTADO")
    private Short estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteId")
    private List<AgendaAtencion> agendaAtencionList;
    @JoinColumn(name = "COMUNA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Comuna comunaId;
    @JoinColumn(name = "SALUD_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Salud saludId;

    public Paciente() {
    }

    public Paciente(BigDecimal id) {
        this.id = id;
    }

    public Paciente(BigDecimal id, int rut, String dv, String nombres, String apePaterno, String apeMaterno, Date fechaNac, String fono1, String fono2, String mail, String hashPass) {
        this.id = id;
        this.rut = rut;
        this.dv = dv;
        this.nombres = nombres;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.fechaNac = fechaNac;
        this.fono1 = fono1;
        this.fono2 = fono2;
        this.mail = mail;
        this.hashPass = hashPass;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getFono1() {
        return fono1;
    }

    public void setFono1(String fono1) {
        this.fono1 = fono1;
    }

    public String getFono2() {
        return fono2;
    }

    public void setFono2(String fono2) {
        this.fono2 = fono2;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<AgendaAtencion> getAgendaAtencionList() {
        return agendaAtencionList;
    }

    public void setAgendaAtencionList(List<AgendaAtencion> agendaAtencionList) {
        this.agendaAtencionList = agendaAtencionList;
    }

    public Comuna getComunaId() {
        return comunaId;
    }

    public void setComunaId(Comuna comunaId) {
        this.comunaId = comunaId;
    }

    public Salud getSaludId() {
        return saludId;
    }

    public void setSaludId(Salud saludId) {
        this.saludId = saludId;
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
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.Paciente[ id=" + id + " ]";
    }
    
}
