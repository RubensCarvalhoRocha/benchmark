/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruturas;

/**
 *
 * @author arthu
 */
public class FrequenciaPalavra {
    public String palavra;
    public int frequencia;
    
    

    public FrequenciaPalavra(String palavra) {
        this.palavra = palavra;
        this.frequencia = 1;
    }

    public String getPalavra() {
        return palavra;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void incrementarFrequencia() {
        this.frequencia++;
    }
    
}
