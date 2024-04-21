/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.eduarda.estrutura1bimtrabalho;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduarda
 */
public class Estrutura1BimTrabalho {

    public static void main(String[] args) {
     
        //Insere o tamanho do array
        String vlVetor = JOptionPane.showInputDialog("Insira a quantidade de valores: ");
        
        int valorVetor = Integer.parseInt(vlVetor);
        int[] valoresVetor = new int[valorVetor];
       
       //Insere valor no array 
       for(int i = 0; i < valoresVetor.length; i++){
            String numeros = JOptionPane.showInputDialog("Insira o valor "+ (i+1) + ": ");
            valoresVetor[i] = Integer.parseInt(numeros);
       }
  
        int opcao = -1;
       do{
        opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de ordenação:  \n" +
                                                                                "1 - Ordenação por Inserção \n" +
                                                                                 "2 - Ordenação por Seleção \n" +
                                                                                 "3 - Ordenação Bolha \n" + 
                                                                                  "0 - Sair"));
        
        
        if(opcao == 1){
            JOptionPane.showMessageDialog(null, valorOriginal(valoresVetor) + "\n" + ordInsercao(valoresVetor));    
        } else if (opcao == 2){
            JOptionPane.showMessageDialog(null, valorOriginal(valoresVetor) + "\n" + ordSelecao(valoresVetor));  
        } else if (opcao == 3) {
            JOptionPane.showMessageDialog(null, valorOriginal(valoresVetor) + "\n" + ordBolha(valoresVetor));  
        } else {
            opcao = 0;
        }
        
       } while (opcao != 0);
       
       
    }
    
    // -------------------------- FUNÇÕES --------------------------------------- //
    //Valores inseridos
    public static String valorOriginal (int []valoresVetor){
         String resultado = "Valores inseridos: ";
       for(int i = 0; i < valoresVetor.length; i++){
           resultado = resultado + valoresVetor[i] + " - ";
       }  
       
       return resultado;
    }
    
    
    //Ordenação Inserção
    public static String ordInsercao (int []valoresVetor) {
        long inicio = System.currentTimeMillis();
        int chave, j;
        String ordenado = "Valores Ordenados: ";
        
        for(int i = 1; i < valoresVetor.length; i++){
            chave = valoresVetor[i];
            
            for(j = i - 1;  (j >= 0 && valoresVetor[j] > chave) ; j-- ){
                
                valoresVetor[j+1] = valoresVetor[j];
                
            }
            valoresVetor[j+1] = chave;

        }
       
         long fim = System.currentTimeMillis(); // Tempo de fim da execução
        long tempoDecorrido = fim - inicio;
        double tempoSegundos = tempoDecorrido / 1000.0;
        
        for(int i = 0; i < valoresVetor.length; i++){
            ordenado +=  valoresVetor[i] + " - ";
        }
     
        ordenado +=  "\n  Tempo de execução " + tempoSegundos +  " segundos";
       
    return ordenado;
}
    //Ordenação Seleção
    
    public static String ordSelecao(int []valoresVetor){
        long inicio = System.currentTimeMillis();
        String ordenado =  "Valores ordenados: ";
        
        for(int i = 0; i < valoresVetor.length - 1; i++){
            int menor = i;
            for(int j = i + 1; j < valoresVetor.length; j++){
                if(valoresVetor[j] < valoresVetor[menor]){
                    menor = j;
                }
            }
            
            if(menor != i){
                int aux = valoresVetor[i];
                valoresVetor[i] = valoresVetor[menor];
                valoresVetor[menor] = aux;
            }   
        }
        
        for(int i = 0; i < valoresVetor.length; i++){
            ordenado += valoresVetor[i] + " - ";
        }
        
        long fim = System.currentTimeMillis(); // Tempo de fim da execução
        long tempoDecorrido = fim - inicio;
        double tempoSegundos = tempoDecorrido / 1000.0;
        
        ordenado +=  "\n  Tempo de execução " + tempoSegundos +  " segundos"; 
        
        return ordenado;
    }
    
    //Ordenação Seleção
    public static String ordBolha(int []valoresVetor){
        long inicio = System.currentTimeMillis();
        String ordenado = "Valores ordenado: " ;
        
        boolean troca = true;
        
        while(troca){
            troca = false;
            for(int i = 0; i < valoresVetor.length - 1; i++){
                if(valoresVetor[i] > valoresVetor[i + 1]){
                    int aux = valoresVetor[i];
                    valoresVetor[i] = valoresVetor[i + 1];
                    valoresVetor[i + 1] = aux;
                    troca = true;
                }
            }
            
        }
        
        for(int i  = 0; i < valoresVetor.length; i++){
            ordenado += valoresVetor[i] + " - " ;
        }
        
        long fim = System.currentTimeMillis(); // Tempo de fim da execução
        long tempoDecorrido = fim - inicio;
        double tempoSegundos = tempoDecorrido / 1000.0;

        ordenado +=  "\n  Tempo de execução " + tempoSegundos +  " segundos"; 
        
        return ordenado;
    }
    
    
    
    
}