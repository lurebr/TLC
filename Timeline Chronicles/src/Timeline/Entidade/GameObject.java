/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade;

import java.awt.geom.Dimension2D;
import Timeline.Imagem.Animacao;
import Timeline.Entidade.Atributo.Atributo;
import Timeline.Entidade.Atributo.Tamanho;
import Timeline.Entidade.Atributo.Posicao;

/**
 *
 * @author Desenv01
 */
public abstract class GameObject implements Cloneable{
    public Posicao localizacao = new Posicao();
    public Tamanho tamanho = new Tamanho();
    public Atributo atributo = new Atributo();
    public Animacao animacao;
    
    public abstract void update(double delta); 
    
       @Override  
    public Object clone() throws CloneNotSupportedException {  
        GameObject copia = (GameObject) super.clone();  
        copia.animacao = (Animacao) animacao.clone();
        copia.atributo = (Atributo) atributo.clone();
        copia.tamanho = (Tamanho) tamanho.clone();
        copia.localizacao = (Posicao) localizacao.clone();
        return copia;  
   }
}
