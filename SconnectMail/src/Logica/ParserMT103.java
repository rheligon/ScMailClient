/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import Objetos.MT103;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

/**
 *
 * @author pbcgjp
 */
public class ParserMT103  {
    String file;
 
    
    public ParserMT103(String fileX){
        this.file = fileX;
                     
    }
    
    public String Check(){
        String o = open();
        if(!o.equals("1")){return o+" "+file;}
        return "1";
    }
    
    public String open(){
        
        
        String respuesta;
        try {
            String linea ="";
            File archivo = new File(file);
            FileReader reader = new FileReader(archivo);
            BufferedReader br = new BufferedReader(reader);
            respuesta = Validate(br);
            br.close();
            reader.close();
            return respuesta;
        } catch(NullPointerException filen) {
            return "No se encontro el archivo";
        } catch(Exception io){
            return "Error desconocido abriendo el archivo, el archivo no puede ser procesado ";
        } 
        
    }
    

    public String Validate(BufferedReader br){
       String linea =""; 
       String Tx = "";
       String nextTx = "";
               
       Vector Txs = new Vector();
        
        try{
        while((linea=br.readLine())!=null){
            
            if(linea.contains("$")){
                Tx +=linea.substring(0, linea.indexOf("$"));
                nextTx = linea.substring(linea.indexOf("$")+1);
                Txs.add(new MT103(Tx));
                Tx = ""+nextTx+"\n";
            }
            else{
                Tx+=linea+"\n";
            }
            
        }
        Txs.add(new MT103(Tx));  
        
        }catch(Exception e){ e.printStackTrace();
            return null;}
        return "1";
    } 
    

}
