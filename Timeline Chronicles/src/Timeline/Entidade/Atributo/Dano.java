/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade.Atributo;

/**
 *
 * @author Lennon
 */
public class Dano {
    private int danoProjetil;
    private int danoCritico;
    private boolean critico;
    private boolean multicritico;
    private boolean esquiva;

    /**
     * @return the danoProjetil
     */
    public int getDanoProjetil() {
        return danoProjetil;
    }

    /**
     * @param danoProjetil the danoProjetil to set
     */
    public void setDanoProjetil(int danoProjetil) {
        this.danoProjetil = danoProjetil;
    }

    /**
     * @return the danoCritico
     */
    public int getDanoCritico() {
        return danoCritico;
    }

    /**
     * @param danoCritico the danoCritico to set
     */
    public void setDanoCritico(int danoCritico) {
        this.danoCritico = danoCritico;
    }

    /**
     * @return the critico
     */
    public boolean isCritico() {
        return critico;
    }

    /**
     * @param critico the critico to set
     */
    public void setCritico(boolean critico) {
        this.critico = critico;
    }

    /**
     * @return the multicritico
     */
    public boolean isMulticritico() {
        return multicritico;
    }

    /**
     * @param multicritico the multicritico to set
     */
    public void setMulticritico(boolean multicritico) {
        this.multicritico = multicritico;
    }

    /**
     * @return the esquiva
     */
    public boolean isEsquiva() {
        return esquiva;
    }

    /**
     * @param esquiva the esquiva to set
     */
    public void setEsquiva(boolean esquiva) {
        this.esquiva = esquiva;
    }
}
