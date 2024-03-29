/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade.Atributo;

/**
 *
 * @author Lennon
 */
public class Atributo implements Cloneable{
    private int danoMinimo;
    private int danoMaximo;
    private int vida;
    private int vidaMax;
    private int critico;
    private int evasion;
    private int speed;
    private int atkspeed;
    private Armadura armadura = new Armadura();

    public Atributo()  {}
    public Atributo(int danoMinimo,int danoMaximo,int vida, int vidaMax, int critico, int evasion, int speed, int atkspeed) {
        this.danoMaximo = danoMinimo;
        this.danoMaximo = danoMaximo;
        this.vida = vida;
        this.vidaMax = vidaMax;
        this.critico = critico;
        this.evasion = evasion;
        this.speed = speed;
        this.atkspeed = atkspeed;
    }
    public Atributo(Atributo atributo) {
        this.danoMaximo = atributo.danoMaximo;
        this.danoMinimo = atributo.danoMinimo;
        this.vida = atributo.vida;
        this.vidaMax = atributo.vidaMax;
        this.critico = atributo.critico;
        this.evasion = atributo.evasion;
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

    /**
     * @return the armadura
     */
    public Armadura getArmadura() {
        return armadura;
    }

    /**
     * @param armadura the armadura to set
     */
    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    /**
     * @return the critico
     */
    public int getCritico() {
        return critico;
    }

    /**
     * @param critico the critico to set
     */
    public void setCritico(int critico) {
        this.critico = critico;
    }

    /**
     * @return the evasion
     */
    public int getEvasion() {
        return evasion;
    }

    /**
     * @param evasion the evasion to set
     */
    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @return the atkspeed
     */
    public int getAtkspeed() {
        return atkspeed;
    }

    /**
     * @param atkspeed the atkspeed to set
     */
    public void setAtkspeed(int atkspeed) {
        this.atkspeed = atkspeed;
    }
    
  public Object clone() throws CloneNotSupportedException {
      Atributo clone = (Atributo) super.clone();
      Armadura armadura = (Armadura) this.armadura.clone();
      clone.armadura = armadura;
      return clone;
  }
}
