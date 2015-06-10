package Logica;

import java.io.*;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


/**
 *
 * @author pbcgjp
 */
public class Demonio {
        
    public static void start(String dir, String dirlog, String direrror, String dirproc){
        
        File input = new File(dir);
        Vector log = new Vector();        
        /*pacs 008 input swift*/
        String [] listaArchivos = input.list(new Filtro());
        for(int i=0; i<listaArchivos.length; i++){

                ParserMT103 a = new ParserMT103(dir+"\\"+listaArchivos[i]);
                String lo = a.Check();                
                log.add("Archivo procesado correctamente "+dir+"\\"+listaArchivos[i]);              
        }     
        
        try{
            if(!log.isEmpty()){
                File resumen = new File(dirlog+"\\SCM_"+date()+".txt");
                FileWriter wr = new FileWriter(resumen);
                BufferedWriter es = new BufferedWriter(wr);

                for(Iterator it = log.iterator();it.hasNext();){
                    es.write((String)it.next()+"\n");
                }
                es.close();
                wr.close();
            }
        }catch(Exception e){}               
        
    }
    
    
    public static String date(){
        Calendar cal = Calendar.getInstance();
        return ""+cal.get(Calendar.YEAR)+"_"+cal.get(Calendar.DAY_OF_YEAR)+"_"+cal.get(Calendar.HOUR_OF_DAY)
                +cal.get(Calendar.MINUTE)+"_"+cal.get(Calendar.SECOND)+"_"+cal.get(Calendar.MILLISECOND);
    } 
    
    public static boolean CheckProc(String filename, String dir){
        try{
             File input = new File(dir);
             String [] listaArchivos = input.list(new FiltroCheck(filename));
             if(listaArchivos.length==0){
                return false;
             }
             else{return true;}
        }catch(Exception e){
            return false;
        }   
    }
    
}
class Filtro implements FilenameFilter{

    Filtro(){}
    public boolean accept(File dir, String name){    
        return true;
    }
}
 
 class FiltroCheck implements FilenameFilter{
    String nombre;
    FiltroCheck (String extension){
        this.nombre=extension;
    }
    public boolean accept(File dir, String name){    
        return name.contains(nombre);
    }
}