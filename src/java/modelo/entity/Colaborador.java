/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "COLABORADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colaborador.findAll", query = "SELECT c FROM Colaborador c")
    , @NamedQuery(name = "Colaborador.findById", query = "SELECT c FROM Colaborador c WHERE c.id = :id")
    , @NamedQuery(name = "Colaborador.findByRut", query = "SELECT c FROM Colaborador c WHERE c.rut = :rut")
    , @NamedQuery(name = "Colaborador.findByDv", query = "SELECT c FROM Colaborador c WHERE c.dv = :dv")
    , @NamedQuery(name = "Colaborador.findByNombre", query = "SELECT c FROM Colaborador c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Colaborador.findByApePaterno", query = "SELECT c FROM Colaborador c WHERE c.apePaterno = :apePaterno")
    , @NamedQuery(name = "Colaborador.findByApeMaterno", query = "SELECT c FROM Colaborador c WHERE c.apeMaterno = :apeMaterno")
    , @NamedQuery(name = "Colaborador.findBySexo", query = "SELECT c FROM Colaborador c WHERE c.sexo = :sexo")
    , @NamedQuery(name = "Colaborador.findByFechaNac", query = "SELECT c FROM Colaborador c WHERE c.fechaNac = :fechaNac")
    , @NamedQuery(name = "Colaborador.findByFono1", query = "SELECT c FROM Colaborador c WHERE c.fono1 = :fono1")
    , @NamedQuery(name = "Colaborador.findByFono2", query = "SELECT c FROM Colaborador c WHERE c.fono2 = :fono2")
    , @NamedQuery(name = "Colaborador.findByDireccion", query = "SELECT c FROM Colaborador c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Colaborador.findByMail", query = "SELECT c FROM Colaborador c WHERE c.mail = :mail")
    , @NamedQuery(name = "Colaborador.findByHashPass", query = "SELECT c FROM Colaborador c WHERE c.hashPass = :hashPass")
    , @NamedQuery(name = "Colaborador.findBySueldo", query = "SELECT c FROM Colaborador c WHERE c.sueldo = :sueldo")})
public class Colaborador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "RUT")
    private String rut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DV")
    private Character dv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
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
    @Column(name = "SEXO")
    private Character sexo;
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
    @Size(max = 13)
    @Column(name = "FONO_2")
    private String fono2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUELDO")
    private BigInteger sueldo;
    @JoinColumn(name = "AFP_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Afp afpId;
    @JoinColumn(name = "CARGO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cargo cargoId;
    @JoinColumn(name = "COMUNA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Comuna comunaId;
    @JoinColumn(name = "ESTADO_CIVIL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EstadoCivil estadoCivilId;
    @JoinColumn(name = "SALUD_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Salud saludId;
    @JoinColumn(name = "SUCURSAL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sucursal sucursalId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradorId")
    private List<Caja> cajaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradorId")
    private List<Medico> medicoList;

    public Colaborador() {
    }

    public Colaborador(BigDecimal id) {
        this.id = id;
    }

    public Colaborador(BigDecimal id, String rut, Character dv, String nombre, String apePaterno, String apeMaterno, Character sexo, Date fechaNac, String fono1, String direccion, String mail, String hashPass, BigInteger sueldo) {
        this.id = id;
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.fono1 = fono1;
        this.direccion = direccion;
        this.mail = mail;
        this.hashPass = hashPass;
        this.sueldo = sueldo;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Character getDv() {
        return dv;
    }

    public void setDv(Character dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public BigInteger getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigInteger sueldo) {
        this.sueldo = sueldo;
    }

    public Afp getAfpId() {
        return afpId;
    }

    public void setAfpId(Afp afpId) {
        this.afpId = afpId;
    }

    public Cargo getCargoId() {
        return cargoId;
    }

    public void setCargoId(Cargo cargoId) {
        this.cargoId = cargoId;
    }

    public Comuna getComunaId() {
        return comunaId;
    }

    public void setComunaId(Comuna comunaId) {
        this.comunaId = comunaId;
    }

    public EstadoCivil getEstadoCivilId() {
        return estadoCivilId;
    }

    public void setEstadoCivilId(EstadoCivil estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }

    public Salud getSaludId() {
        return saludId;
    }

    public void setSaludId(Salud saludId) {
        this.saludId = saludId;
    }

    public Sucursal getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Sucursal sucursalId) {
        this.sucursalId = sucursalId;
    }

    @XmlTransient
    public List<Caja> getCajaList() {
        return cajaList;
    }

    public void setCajaList(List<Caja> cajaList) {
        this.cajaList = cajaList;
    }

    @XmlTransient
    public List<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
        this.medicoList = medicoList;
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
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.Colaborador[ id=" + id + " ]";
    }
    
}
