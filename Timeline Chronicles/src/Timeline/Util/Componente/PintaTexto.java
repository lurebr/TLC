/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Util.Componente;

import Timeline.Entidade.Atributo.Posicao;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.lang.Integer;

/**
 *
 * @author Glauber
 */
public class PintaTexto {
    private ArrayList<Integer[]> listaTexto = new ArrayList<Integer[]>();
    
    public void setTexto(int valor, Posicao localizacao){
        System.out.println("Add");
        Integer[] coisas = new Integer[4];
        coisas[0] = 0;
        coisas[1] = valor;
        coisas[2] = localizacao.getX();
        coisas[3] = localizacao.getY();
        listaTexto.add(coisas);
        
    }
    
    public void drawTexto(Graphics2D g){
       
        System.out.println("lista : "+listaTexto.size());
        Font f = new Font("Arial", 1, 20);
        g.setFont(f);
        
        for(int i=0; i<listaTexto.size() ; i++){
            if(listaTexto.get(i)[0]<90){
                if(listaTexto.get(i)[1] ==0){
                    
                    g.drawString("Evade!!", listaTexto.get(i)[2], listaTexto.get(i)[3]);
                    listaTexto.get(i)[0]++;
                }else{
                    g.drawString(listaTexto.get(i)[1].toString(), listaTexto.get(i)[2], listaTexto.get(i)[3]);
                    listaTexto.get(i)[0]++;
                }
            }else{
                listaTexto.remove(i);
            }
        }
        
    }
    
}
