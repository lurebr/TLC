/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade;

import Timeline.Entidade.Atributo.Atributo;
import Timeline.Entidade.Atributo.Posicao;
import Timeline.Entidade.Atributo.Tamanho;
import Timeline.Imagem.Animacao;

/**
 * 
 * @author Desenv01
 */
public abstract class GameObject implements Cloneable {
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
