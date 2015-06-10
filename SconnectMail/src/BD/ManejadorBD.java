   /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import Objetos.Cliente;
import Objetos.Configuracion;
import Objetos.Licencia;
import Objetos.Regla;
import java.util.List;
import java.util.Vector;
import javax.persistence.NoResultException;
import javax.persistence.Query;


/**
 *
 * @author pbcgcp
 */
public class ManejadorBD{

   
   public static boolean setRegla(Regla regla){
        boolean result = false;      
       
        try{
            SesionBD.getInstance().getEm().getTransaction().begin();
            SesionBD.getInstance().getEm().persist(regla);
            SesionBD.getInstance().getEm().getTransaction().commit();    
            
            result = true;
            
        }
        catch(Exception ex){            
            SesionBD.getInstance().getEm().getTransaction().rollback();         
            return result;
        }       
        
        return result;
   }

   public static void updateRegla(Regla regla){
         
       try{
           SesionBD.getInstance().getEm().getTransaction().begin();

            //Busca el id de la regla con el codigo que se le pasa para poder modificar
            Query q = SesionBD.getInstance().getEm().createNamedQuery("Regla.findById");
            q.setParameter("id",regla.getId());
            Regla reg =(Regla) q.getSingleResult();

            reg.setIo(regla.getIo());
            reg.setMailToCliente(regla.getMailToCliente());
            reg.setMailToDpto(regla.getMailToDpto());
            reg.setDescripcion(regla.getDescripcion());
            reg.setMoneda(regla.getMoneda());
            reg.setMonto(regla.getMonto());
            reg.setMt(regla.getMt());           

            SesionBD.getInstance().getEm().persist(reg);

            SesionBD.getInstance().getEm().getTransaction().commit();
        }
        catch(NoResultException ex){}
        catch(Exception ex1){System.out.println(ex1);
            SesionBD.getInstance().getEm().getTransaction().rollback();           
        }
    } 
    
   public static boolean deleteRegla(Long idRegla){
        
       try{
            SesionBD.getInstance().getEm().getTransaction().begin();

            Query q = SesionBD.getInstance().getEm().createNamedQuery("Regla.findById");
            q.setParameter("id",idRegla);
            Regla regla =(Regla) q.getSingleResult();

            SesionBD.getInstance().getEm().remove(regla);

            SesionBD.getInstance().getEm().getTransaction().commit();

            return true;
        }
        catch(NoResultException ex){return false;}
        catch(Exception ex1){
            SesionBD.getInstance().getEm().getTransaction().rollback();
            return false;
        }
        
   }

//   public static Regla getRegla(BigDecimal id){
//        Alertas alerta = null;

//        try{
//            Query q = SesionBD.getInstance().getEm().createNamedQuery("Alertas.findByIdalertas");
//            q.setParameter("idalertas",id);
//
//            alerta = (Alertas) q.getSingleResult();
//        }
//        catch(Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return alerta;
//   }
     
   public static List getReglas(){
        List Reglas = null;
        
        try{    
            Query q = SesionBD.getInstance().getEm().createNamedQuery("Regla.findAll");
            Reglas = q.getResultList();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

        return Reglas;
    }
   
   
   
   //================= CONFIGURACION
   //=================
   
   public static void setConfiguracion(Vector datos){
        try{          
            Configuracion configuracion = null;

            Query q = SesionBD.getInstance().getEm().createQuery("SELECT c FROM Configuracion c");  

            if(q.getResultList().isEmpty()){
               configuracion = new Configuracion(); 
            }
            else{
               configuracion = (Configuracion) q.getSingleResult();
            }

            configuracion.setDirEntrada(datos.get(0).toString());
            configuracion.setDirProcesado(datos.get(1).toString());
            configuracion.setDirLog(datos.get(2).toString());
            configuracion.setMailServidor(datos.get(3).toString());
            if(!datos.get(4).toString().equals("")){configuracion.setMailPuerto(Integer.parseInt(datos.get(4).toString()));}
            configuracion.setMailUsuario(datos.get(5).toString());

            //Password servidor de alertas
            DesEncrypter encrypter = new DesEncrypter("ertg-yguy-4446-hjk756-hjfg54-fttu9-d4fc");
            if(!datos.get(6).toString().equals("")){
                String encrypted = encrypter.encrypt(datos.get(6).toString());
                configuracion.setMailClave(encrypted);
            }

            SesionBD.getInstance().getEm().getTransaction().begin();

            SesionBD.getInstance().getEm().persist(configuracion);

            SesionBD.getInstance().getEm().getTransaction().commit(); 

        }
        catch(Exception ex){
            SesionBD.getInstance().getEm().getTransaction().begin();
            SesionBD.getInstance().getEm().getTransaction().rollback();            
        }          
    }
   
   
   public static Vector getConfiguracion(){
        Vector datos = new Vector();
        try{         
            Query q = SesionBD.getInstance().getEm().createQuery("SELECT c FROM Configuracion c");
                        
            if(!q.getResultList().isEmpty()){
              
                Configuracion configuracion = (Configuracion) q.getSingleResult();
                                
                datos.add(configuracion.getDirEntrada());
                datos.add(configuracion.getDirProcesado());   
                datos.add(configuracion.getDirLog()); 
                datos.add(configuracion.getMailServidor()); 
                datos.add(configuracion.getMailPuerto()); 
                datos.add(configuracion.getMailUsuario()); 
                datos.add(configuracion.getMailClave());                  
            }              
               
        }
        catch(Exception ex){ System.out.println(ex);            
        }
        return datos; 
    }
   
   //REFACTORIZAR CODIGO DE LA PANTALLA CONFIGURACION PARA USAR EL OBJETO COMPLETO DEVUELTO POR ESTE QUERY
   
    public static Configuracion getConfiguracion1(){
        Configuracion conf = new Configuracion();
        try{         
            Query q = SesionBD.getInstance().getEm().createQuery("SELECT c FROM Configuracion c");
                        
            if(!q.getResultList().isEmpty()){
              
                conf = (Configuracion) q.getSingleResult();                             
            }         
        }
        catch(Exception ex){ System.out.println(ex);            
        }
        return conf; 
    }
    
    public static boolean setPlantilla(Configuracion conf){
        try{          
            Configuracion configuracion = null;

            Query q = SesionBD.getInstance().getEm().createQuery("SELECT c FROM Configuracion c");  

            if(q.getResultList().isEmpty()){
               configuracion = new Configuracion(); 
            }
            else{
               configuracion = (Configuracion) q.getSingleResult();
            }

            configuracion.setPlantillaInputAsunto(conf.getPlantillaInputAsunto());
            configuracion.setPlantillaInputEncabezado(conf.getPlantillaInputEncabezado());
            configuracion.setPlantillaInputFirma(conf.getPlantillaInputFirma());
            configuracion.setPlantillaOutputAsunto(conf.getPlantillaOutputAsunto());
            configuracion.setPlantillaOutputEncabezado(conf.getPlantillaOutputEncabezado());
            configuracion.setPlantillaOutputFirma(conf.getPlantillaOutputFirma());            

            SesionBD.getInstance().getEm().getTransaction().begin();

            SesionBD.getInstance().getEm().persist(configuracion);

            SesionBD.getInstance().getEm().getTransaction().commit(); 
            
            return true;
        }
        catch(Exception ex){
            SesionBD.getInstance().getEm().getTransaction().begin();
            SesionBD.getInstance().getEm().getTransaction().rollback();     
            return false;
        }          
    }

   
   
   
   //================= CLIENTES
   //=================
   
    public static int setCliente(String cuentaVieja, String cuentaNueva, String correo) {        
         try{          
            Cliente cliente = null;
            
            //se verifica que no este en BD el nombre nuevo de cliente
            Query q0 = SesionBD.getInstance().getEm().createNamedQuery("Cliente.findByNombre");            
            q0.setParameter("nombre", cuentaNueva);
                        
            if(!q0.getResultList().isEmpty() && !cuentaVieja.equals(cuentaNueva)){               
                    return -1; //Error Cliente en BD                                                  
            }
            else if (cuentaVieja.isEmpty()) {
               cliente = new Cliente(); 
            }
            else{
                Query q = SesionBD.getInstance().getEm().createNamedQuery("Cliente.findByNombre");            
                q.setParameter("nombre", cuentaVieja);

                cliente = (Cliente) q.getSingleResult(); 
            }
            
            cliente.setNombre(cuentaNueva);
            cliente.setMail(correo);          

            SesionBD.getInstance().getEm().getTransaction().begin();

            SesionBD.getInstance().getEm().persist(cliente);

            SesionBD.getInstance().getEm().getTransaction().commit(); 

            return 1; //Satisfactorio

        }
        catch(Exception ex){ex.printStackTrace();
            SesionBD.getInstance().getEm().getTransaction().begin();
            SesionBD.getInstance().getEm().getTransaction().rollback();  
            
            return 0; //Error 
        }          
    }

    public static List getClientes() {
        List clientes = null;
        
        try{    
            Query q = SesionBD.getInstance().getEm().createNamedQuery("Cliente.findAll");
            clientes = q.getResultList();
        }
        catch(Exception ex) { System.out.println(ex);
            ex.printStackTrace();
        }

        return clientes;
    }
    
    
    public static javax.swing.JTable updateClientes(javax.swing.JTable clientes){
       
       try{ 
        org.jdesktop.beansbinding.BindingGroup bindingGroup;
        java.util.List<Objetos.Cliente> clienteList;
        javax.persistence.Query clienteQuery;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();
        javax.persistence.EntityManager AlertasSwiftPUEntityManager;
        AlertasSwiftPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("AlertasSwiftPU").createEntityManager();
        clienteQuery = java.beans.Beans.isDesignTime() ? null : AlertasSwiftPUEntityManager.createQuery("SELECT c FROM Cliente c");

        clienteList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery.getResultList();
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clienteList, clientes);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Cliente");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${mail}"));
        columnBinding.setColumnName("Correo(s)");
        columnBinding.setColumnClass(String.class); 
        
                   
        try{clientes.addRowSelectionInterval(0,0);}catch(Exception ex){}
           
        jTableBinding.bind();
       }
       catch(Exception ex){
            SesionBD.getInstance().getEm().getTransaction().rollback();           
       }
       
       return clientes;
   }

    public static void deleteCliente(String codigoCliente) {
        try{
            //Busca el id de la moneda con el codigo que se le pasa para poder eliminar
            Query q = SesionBD.getInstance().getEm().createNamedQuery("Cliente.findByNombre");
            q.setParameter("nombre", codigoCliente);
            Cliente cliente =(Cliente ) q.getSingleResult(); 

            SesionBD.getInstance().getEm().getTransaction().begin(); 
            
            SesionBD.getInstance().getEm().remove(cliente);

            SesionBD.getInstance().getEm().getTransaction().commit();
        }
        catch(NoResultException ex){}
        catch(Exception ex1){            
            SesionBD.getInstance().getEm().getTransaction().rollback();           
        }
    }
    
     //================= LICENCIA
   //=================
   
    public static Licencia getLicencia(){
        Licencia lic = null;
        
        try{         
            Query q = SesionBD.getInstance().getEm().createNamedQuery("Licencia.findAll");                      
            lic = (Licencia) q.getSingleResult();   
                                   
        }
        catch(Exception ex){ System.out.println(ex);}
        
        return lic; 
    } 
    
    public static void setLicencia(Licencia lic) {        
         try{          
            Licencia licenciaActual = getLicencia();
            
            if(licenciaActual != null){
                licenciaActual.setBic(lic.getBic());
                licenciaActual.setFechaVencimiento(lic.getFechaVencimiento());  
                licenciaActual.setHash(lic.getHash());
                licenciaActual.setSalt(lic.getSalt());
                
                SesionBD.getInstance().getEm().getTransaction().begin();
                SesionBD.getInstance().getEm().persist(licenciaActual);
                SesionBD.getInstance().getEm().getTransaction().commit();
            }
            else{
                SesionBD.getInstance().getEm().getTransaction().begin();
                SesionBD.getInstance().getEm().persist(lic);
                SesionBD.getInstance().getEm().getTransaction().commit(); 
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
//            SesionBD.getInstance().getEm().getTransaction().begin();
            SesionBD.getInstance().getEm().getTransaction().rollback();            
        }          
    }
   
}