/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import org.openswing.swing.client.OptionPane;


/**
 *
 * @author pbcgcp
 */
public class SesionBD {

    private static SesionBD INSTANCE = null;

    //Creador sincronizado para protegerse de posibles problemas  multi-hilo
    //Para evitar instantiacion multiple
    private synchronized static void createInstance(){
        if (INSTANCE == null) {
            INSTANCE = new SesionBD();
        }
    }

    public static SesionBD getInstance(){
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public SesionBD(){
        //Creación del EntityManager
         try{

             File file = new File("configuracion.scf");
             FileReader reader = new FileReader(file);
             BufferedReader in = new BufferedReader(reader);
             String string;
             Vector param = new Vector();

             DesEncrypter encrypter = new DesEncrypter("ashb-da17-39hq-bwe86-yg3d-y139-6");

                while ((string = in.readLine()) != null) {
                   param.add(encrypter.decrypt(string));
                }
             in.close();


            Map prueba = new HashMap();
          
//          System.out.println(param.get(0));
//          System.out.println(param.get(1));
//          System.out.println(param.get(2));
//          System.out.println(param.get(3));
//
//          prueba.put("toplink.jdbc.user",param.get(0));
//          prueba.put("toplink.jdbc.password",param.get(1));
//          prueba.put("toplink.jdbc.url",param.get(2));
//          prueba.put("toplink.jdbc.driver",param.get(3));

         prueba.put("toplink.jdbc.user","sa");//param.get(0));
         prueba.put("toplink.jdbc.password","asdf1234..");//param.get(1));
         prueba.put("toplink.jdbc.url","jdbc:sqlserver://localhost:1433;databaseName=SconnectMail");//param.get(2));
         prueba.put("toplink.jdbc.driver","com.microsoft.sqlserver.jdbc.SQLServerDriver");//param.get(3));



           emf = Persistence.createEntityManagerFactory("AlertasSwiftPU",prueba);
           em = emf.createEntityManager();

        }
        catch (IOException ex) {
           OptionPane.showMessageDialog(null,"El archivo de configuración configuracion.scf no ha sido encontrado.","Error",JOptionPane.ERROR_MESSAGE);
           System.exit(0);
        }
        catch(Exception e1){
           e1.printStackTrace();
           OptionPane.showMessageDialog(null,"No hay conexión con la Base de Datos.","Error",JOptionPane.ERROR_MESSAGE);
           System.exit(0);
        }
    }

    public static void CerrarSesion() {
        emf.close();
    }

    public EntityManager getEm() {
        return em;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public static void borrar() {
        em.clear();
    }



}
