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
@Table(name = "SALUD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salud.findAll", query = "SELECT s FROM Salud s")
    , @NamedQuery(name = "Salud.findById", query = "SELECT s FROM Salud s WHERE s.id = :id")
    , @NamedQuery(name = "Salud.findByDescripcion", query = "SELECT s FROM Salud s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Salud.findByPorc", query = "SELECT s FROM Salud s WHERE s.porc = :porc")})
public class Salud implements Serializable {

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
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORC")
    private BigDecimal porc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saludId")
    private List<Colaborador> colaboradorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saludId")
    private List<Paciente> pacienteList;

    public Salud() {
    }

    public Salud(BigDecimal id) {
        this.id = id;
    }

    public Salud(BigDecimal id, String descripcion, BigDecimal porc) {
        this.id = id;
        this.descripcion = descripcion;
        this.porc = porc;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPorc() {
        return porc;
    }

    public void setPorc(BigDecimal porc) {
        this.porc = porc;
    }

    @XmlTransient
    public List<Colaborador> getColaboradorList() {
        return colaboradorList;
    }

    public void setColaboradorList(List<Colaborador> colaboradorList) {
        this.colaboradorList = colaboradorList;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
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
        if (!(object instanceof Salud)) {
            return false;
        }
        Salud other = (Salud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entity.Salud[ id=" + id + " ]";
    }
    
}
