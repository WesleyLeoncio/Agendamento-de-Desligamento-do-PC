package modelo.model;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Desligar {

    private int horas = 0, minutos = 0, segundos = 0, tempo;
    private String tempoArquivo;
    private String comando = "cmd /c shutdown -f -s -t ";

    public Desligar() {
    }

    public Desligar(String horas, String minutos, String segundos) {
        this.horas = Integer.parseInt(horas);
        this.minutos = Integer.parseInt(minutos);
        this.segundos = Integer.parseInt(segundos);
        this.tempoArquivo = horas+":"+minutos+":"+segundos;
    }

    public void Desligar() {
        this.tempo = calcularHoras() + calcularMinutos() + this.segundos;
        this.comando += tempo;
        try {
            Runtime.getRuntime().exec(comando);
            Arquivo arquivo = new Arquivo(tempoArquivo);
            JOptionPane.showMessageDialog(null,"Tempo para Desligamento: "+tempoArquivo);
        arquivo.escreverArquivo();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }

    }

    public void cancelar() {
        String cancelar = "cmd /c shutdown -a";
        try {
            Runtime.getRuntime().exec(cancelar);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }

    }
    
    public int calcularHoras(){
        this.horas *= 60;
        this.horas *= 60;
        return this.horas;
    }
     public int calcularMinutos(){
        this.minutos *= 60;
        return this.minutos;
    }
   
}
