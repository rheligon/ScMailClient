/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;



/**
 *
 * @author PBCGJP
 */

public class Client{

    String Opcion;
    String Cuenta;
    String NameAddress;

    public Client(String Opcion, String Cuenta,String NameAddress) {
        this.Opcion = Opcion;
        this.Cuenta = Cuenta;
        this.NameAddress = NameAddress;
    }

    public Client() {
    }
    
    public Client (String data){
        
        this.Opcion = data.substring(0,1);
        
        if(data.contains(":/")){
            this.Cuenta = data.substring(data.indexOf(":/")+2,data.indexOf("\n"));
            this.NameAddress = data.substring(data.indexOf("\n")+1);
            
        }else {
            this.Cuenta = " ";
            this.NameAddress = data.substring(data.indexOf(":")+1);
        }        
        
    }

    
}
