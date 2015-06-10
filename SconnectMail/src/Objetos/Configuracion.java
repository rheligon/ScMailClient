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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pbcgcp
 */
@Entity
@Table(name = "Configuracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracion.findAll", query = "SELECT c FROM Configuracion c"),
    @NamedQuery(name = "Configuracion.findById", query = "SELECT c FROM Configuracion c WHERE c.id = :id"),
    @NamedQuery(name = "Configuracion.findByMailServidor", query = "SELECT c FROM Configuracion c WHERE c.mailServidor = :mailServidor"),
    @NamedQuery(name = "Configuracion.findByMailPuerto", query = "SELECT c FROM Configuracion c WHERE c.mailPuerto = :mailPuerto"),
    @NamedQuery(name = "Configuracion.findByMailUsuario", query = "SELECT c FROM Configuracion c WHERE c.mailUsuario = :mailUsuario"),
    @NamedQuery(name = "Configuracion.findByMailClave", query = "SELECT c FROM Configuracion c WHERE c.mailClave = :mailClave"),
    @NamedQuery(name = "Configuracion.findByDirEntrada", query = "SELECT c FROM Configuracion c WHERE c.dirEntrada = :dirEntrada"),
    @NamedQuery(name = "Configuracion.findByDirSalida", query = "SELECT c FROM Configuracion c WHERE c.dirSalida = :dirSalida"),
    @NamedQuery(name = "Configuracion.findByDirProcesado", query = "SELECT c FROM Configuracion c WHERE c.dirProcesado = :dirProcesado"),
    @NamedQuery(name = "Configuracion.findByDirLog", query = "SELECT c FROM Configuracion c WHERE c.dirLog = :dirLog")})
public class Configuracion implements Serializable {
    @Lob
    @Column(name = "PlantillaInputAsunto")
    private String plantillaInputAsunto;
    @Lob
    @Column(name = "PlantillaInputEncabezado")
    private String plantillaInputEncabezado;
    @Lob
    @Column(name = "PlantillaInputFirma")
    private String plantillaInputFirma;
    @Lob
    @Column(name = "PlantillaOutputAsunto")
    private String plantillaOutputAsunto;
    @Lob
    @Column(name = "PlantillaOutputEncabezado")
    private String plantillaOutputEncabezado;
    @Lob
    @Column(name = "PlantillaOutputFirma")
    private String plantillaOutputFirma;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "MailServidor")
    private String mailServidor;
    @Column(name = "MailPuerto")
    private Integer mailPuerto;
    @Column(name = "MailUsuario")
    private String mailUsuario;
    @Column(name = "MailClave")
    private String mailClave;
    @Column(name = "DirEntrada")
    private String dirEntrada;
    @Column(name = "DirSalida")
    private String dirSalida;
    @Column(name = "DirProcesado")
    private String dirProcesado;
    @Column(name = "DirLog")
    private String dirLog;

    public Configuracion() {
    }

    public Configuracion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMailServidor() {
        return mailServidor;
    }

    public void setMailServidor(String mailServidor) {
        this.mailServidor = mailServidor;
    }

    public Integer getMailPuerto() {
        return mailPuerto;
    }

    public void setMailPuerto(Integer mailPuerto) {
        this.mailPuerto = mailPuerto;
    }

    public String getMailUsuario() {
        return mailUsuario;
    }

    public void setMailUsuario(String mailUsuario) {
        this.mailUsuario = mailUsuario;
    }

    public String getMailClave() {
        return mailClave;
    }

    public void setMailClave(String mailClave) {
        this.mailClave = mailClave;
    }

    public String getDirEntrada() {
        return dirEntrada;
    }

    public void setDirEntrada(String dirEntrada) {
        this.dirEntrada = dirEntrada;
    }

    public String getDirSalida() {
        return dirSalida;
    }

    public void setDirSalida(String dirSalida) {
        this.dirSalida = dirSalida;
    }

    public String getDirProcesado() {
        return dirProcesado;
    }

    public void setDirProcesado(String dirProcesado) {
        this.dirProcesado = dirProcesado;
    }

    public String getDirLog() {
        return dirLog;
    }

    public void setDirLog(String dirLog) {
        this.dirLog = dirLog;
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
        if (!(object instanceof Configuracion)) {
            return false;
        }
        Configuracion other = (Configuracion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objetos.Configuracion[ id=" + id + " ]";
    }

    public String getPlantillaInputAsunto() {
        return plantillaInputAsunto;
    }

    public void setPlantillaInputAsunto(String plantillaInputAsunto) {
        this.plantillaInputAsunto = plantillaInputAsunto;
    }

    public String getPlantillaInputEncabezado() {
        return plantillaInputEncabezado;
    }

    public void setPlantillaInputEncabezado(String plantillaInputEncabezado) {
        this.plantillaInputEncabezado = plantillaInputEncabezado;
    }

    public String getPlantillaInputFirma() {
        return plantillaInputFirma;
    }

    public void setPlantillaInputFirma(String plantillaInputFirma) {
        this.plantillaInputFirma = plantillaInputFirma;
    }

    public String getPlantillaOutputAsunto() {
        return plantillaOutputAsunto;
    }

    public void setPlantillaOutputAsunto(String plantillaOutputAsunto) {
        this.plantillaOutputAsunto = plantillaOutputAsunto;
    }

    public String getPlantillaOutputEncabezado() {
        return plantillaOutputEncabezado;
    }

    public void setPlantillaOutputEncabezado(String plantillaOutputEncabezado) {
        this.plantillaOutputEncabezado = plantillaOutputEncabezado;
    }

    public String getPlantillaOutputFirma() {
        return plantillaOutputFirma;
    }

    public void setPlantillaOutputFirma(String plantillaOutputFirma) {
        this.plantillaOutputFirma = plantillaOutputFirma;
    }
    
}
