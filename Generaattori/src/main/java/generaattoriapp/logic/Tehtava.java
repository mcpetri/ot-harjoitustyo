/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generaattoriapp.logic;

import java.util.Random;

/**
 *
 * @author petri
 */
public class Tehtava {
    private static final int MERKKIENLKM = 4;
    int tekijaVaihtelu = 10;
    Laskin laskin = new Laskin();
    Random rand = new Random();
    int vaikeus = 1;
    String lauseke;
    double vastaus;
    public double luoTehtava(final String merkki) {
        vastaus = 0;
        int luku1 = rand.nextInt(tekijaVaihtelu) + 1;
        int luku2 = rand.nextInt(tekijaVaihtelu) + 1;
        int luku3 = rand.nextInt(tekijaVaihtelu) + 1;
        int luku4 = rand.nextInt(tekijaVaihtelu) + 1;
        int luku5 = rand.nextInt(tekijaVaihtelu) + 1;
        int[] luvut = new int[5];
        luvut[0] = luku2; 
        luvut[1] = luku1; //Helpompi tehdä 5 lukua suoraan kuin
        luvut[2] = luku3; //luoda dynaamisesti enemmän lukuja
        luvut[3] = luku4;
        luvut[4] = luku5;
        String tempLauseke = "";
        for (int i = 0; i <= vaikeus; i++) {
            tempLauseke += String.valueOf(luvut[i]);
            if (i == vaikeus) {
                break;
            }
            if (merkki.equals("+")) {
                tempLauseke += "+";
            }
            if (merkki.equals("-")) {
                tempLauseke += "-";
            }
            if (merkki.equals("*")) {
                tempLauseke += "*";
            }
            if (merkki.equals(":")) {
                tempLauseke += "/";
            }
            if (merkki.equals("random")) {
                int randomizer = rand.nextInt(MERKKIENLKM) + 1;
                if (randomizer == 1) {
                    tempLauseke += "+";
                }
                if (randomizer == 2) {
                    tempLauseke += "-";
                }
                if (randomizer == 3) {
                    tempLauseke += "*";
                }
                if (randomizer == 4) {
                    tempLauseke += "/";
                }
            }
        }
        lauseke = "Ratkaise x, kun \nx = " + tempLauseke;
        vastaus = laskin.laske(tempLauseke);
        return vastaus;
    }
    public double getVastaus() {
        return vastaus;
    }
    public String getLauseke() {
        return lauseke;
    }
    public boolean tarkistus(String tarkistettava) {
        double parse = Double.parseDouble(tarkistettava);
        double tulos = Math.round(vastaus * 100.0) / 100.0;
        return parse == tulos;
    }
    public void setVaikeus(int uusiVaikeus) {
        this.vaikeus = uusiVaikeus;
    }
    public void setVaihtelu(int uusiVaihtelu) {
        this.tekijaVaihtelu = uusiVaihtelu;
    }
}
