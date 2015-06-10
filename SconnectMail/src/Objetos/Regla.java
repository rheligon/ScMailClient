/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pbcgcp
 */
@Entity
@Table(name = "Regla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regla.findAll", query = "SELECT r FROM Regla r"),
    @NamedQuery(name = "Regla.findById", query = "SELECT r FROM Regla r WHERE r.id = :id"),
    @NamedQuery(name = "Regla.findByBic", query = "SELECT r FROM Regla r WHERE r.bic = :bic"),
    @NamedQuery(name = "Regla.findByMt", query = "SELECT r FROM Regla r WHERE r.mt = :mt"),
    @NamedQuery(name = "Regla.findByIo", query = "SELECT r FROM Regla r WHERE r.io = :io"),
    @NamedQuery(name = "Regla.findByMonto", query = "SELECT r FROM Regla r WHERE r.monto = :monto"),
    @NamedQuery(name = "Regla.findByMoneda", query = "SELECT r FROM Regla r WHERE r.moneda = :moneda"),
    @NamedQuery(name = "Regla.findByDescripcion", query = "SELECT r FROM Regla r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Regla.findByMailToDpto", query = "SELECT r FROM Regla r WHERE r.mailToDpto = :mailToDpto"),
    @NamedQuery(name = "Regla.findByMailToCliente", query = "SELECT r FROM Regla r WHERE r.mailToCliente = :mailToCliente")})
public class Regla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "BIC")
    private String bic;
    @Column(name = "MT")
    private Integer mt;
    @Column(name = "IO")
    private String io;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Monto")
    private Double monto;
    @Column(name = "Moneda")
    private String moneda;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "MailToDpto")
    private String mailToDpto;
    @Column(name = "MailToCliente")
    private Character mailToCliente;

    public Regla() {
    }

    public Regla(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public Integer getMt() {
        return mt;
    }

    public void setMt(Integer mt) {
        this.mt = mt;
    }

    public String getIo() {
        return io;
    }

    public void setIo(String io) {
        this.io = io;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMailToDpto() {
        return mailToDpto;
    }

    public void setMailToDpto(String mailToDpto) {
        this.mailToDpto = mailToDpto;
    }

    public Character getMailToCliente() {
        return mailToCliente;
    }

    public void setMailToCliente(Character mailToCliente) {
        this.mailToCliente = mailToCliente;
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
        if (!(object instanceof Regla)) {
            return false;
        }
        Regla other = (Regla) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objetos.Regla[ id=" + id + " ]";
    }
    
}
