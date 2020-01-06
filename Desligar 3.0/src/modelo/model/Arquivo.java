
package modelo.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


//import modelo.time.Time;

public class Arquivo {
   
    private String tempo;
    SimpleDateFormat H = new SimpleDateFormat("hh:mm");
    SimpleDateFormat D = new SimpleDateFormat("dd/MM/yyyy");
             
      
    public Arquivo(String tempo){
        this.tempo = tempo;
    }
    
    public void escreverArquivo() {
        File arquivo = new File("Agendamentos.txt");
        String texto = "Data: "+D.format(new Date())+" Horario de Agendamento: "+H.format(new Date())+" Tempo para Desligamento: "+tempo ;
        FileWriter fw;
        try {
            fw = new  FileWriter(arquivo,true);
            BufferedWriter bw = new  BufferedWriter(fw); 
            bw.write(texto+"\n");
            bw.close();

        } catch (IOException ex) {
           
        }
       
    }      
    
}
