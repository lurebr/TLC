/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade.Atributo;

/**
 *
 * @author Lennon
 */
public class Atributo {
    private int danoMinimo;
    private int danoMaximo;
    private int vida;
    private int vidaMax;

    public Atributo() {}
    public Atributo(Atributo atributo) {
        this.danoMaximo = atributo.danoMaximo;
        this.danoMinimo = atributo.danoMinimo;
        this.vida = atributo.vida;
        this.vidaMax = atributo.vidaMax;
    }

    /**
     * @return the danoMinimo
     */
    public int getDanoMinimo() {
        return danoMinimo;
    }

    /**
     * @param danoMinimo the danoMinimo to set
     */
    public void setDanoMinimo(int danoMinimo) {
        this.danoMinimo = danoMinimo;
    }

    /**
     * @return the danoMaximo
     */
    public int getDanoMaximo() {
        return danoMaximo;
    }

    /**
     * @param danoMaximo the danoMaximo to set
     */
    public void setDanoMaximo(int danoMaximo) {
        this.danoMaximo = danoMaximo;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the vidaMax
     */
    public int getVidaMax() {
        return vidaMax;
    }

    /**
     * @param vidaMax the vidaMax to set
     */
    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }
}
