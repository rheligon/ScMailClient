/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pbcgvb
 */
@Entity
@Table(name = "Licencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Licencia.findAll", query = "SELECT l FROM Licencia l"),
    @NamedQuery(name = "Licencia.findById", query = "SELECT l FROM Licencia l WHERE l.id = :id"),
    @NamedQuery(name = "Licencia.findByBic", query = "SELECT l FROM Licencia l WHERE l.bic = :bic"),
    @NamedQuery(name = "Licencia.findByFechaVencimiento", query = "SELECT l FROM Licencia l WHERE l.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "Licencia.findBySalt", query = "SELECT l FROM Licencia l WHERE l.salt = :salt"),
    @NamedQuery(name = "Licencia.findByHash", query = "SELECT l FROM Licencia l WHERE l.hash = :hash")})
public class Licencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "BIC")
    private String bic;
    @Basic(optional = false)
    @Column(name = "FechaVencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @Column(name = "Salt")
    private String salt;
    @Basic(optional = false)
    @Column(name = "Hash")
    private String hash;

    public Licencia() {
    }

    public Licencia(Long id) {
        this.id = id;
    }

    public Licencia(Long id, String bic, Date fechaVencimiento, String salt, String hash) {
        this.id = id;
        this.bic = bic;
        this.fechaVencimiento = fechaVencimiento;
        this.salt = salt;
        this.hash = hash;
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

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
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
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objetos.Licencia[ id=" + id + " ]";
    }
    
}
