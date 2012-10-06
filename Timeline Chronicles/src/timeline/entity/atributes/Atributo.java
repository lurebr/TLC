/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity.atributes;

/**
 *
 * @author Lennon
 */
public class Atributo {
    private int danoMinimo;
    private int danoMaximo;
    private int vida;

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
}
