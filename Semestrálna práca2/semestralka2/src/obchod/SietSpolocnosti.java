/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obchod;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import predajna.VelkoSklad;

/**
 *Trieda SietSpolocnosti zahŕňa ArrayList prevadziek podniku.
 * @author Rudolf Pastva
 */
public class SietSpolocnosti extends javax.swing.JOptionPane {

    private ArrayList<Prevadzky> majetok;

    public SietSpolocnosti() {
        this.majetok = new ArrayList<Prevadzky>();
    }

    public boolean pridajPrevadzku(Prevadzky prevadzka) {
        return this.majetok.add(prevadzka);
    }

    public int getPocetPrevadzok() {
        return this.majetok.size();
    }

    public Prevadzky zrusPrevadzku(int index) {
        if (this.majetok.get(index).mozemZrusitPrevadzku()) {
            return this.majetok.remove(index);
        }
        return null;
    }

    public String stringPrevadzky() {
        String udaje = "";
        for (int i = 0; i < this.majetok.size(); i++) {
            Prevadzky prevadzka = this.poskytniPrevadzku(i);

            if (prevadzka instanceof Obchod) {
                udaje = udaje + (i + 1) + " Obchod - " + ((Obchod)prevadzka).getSidloObchodu() + "\n";
            }
            if (prevadzka instanceof VelkoSklad) {
                udaje = udaje + (i + 1) + " Velkosklad - " + ((VelkoSklad)prevadzka).getSidloVelkoSkladu() + "\n";
            }

        }
        return udaje;
    }
/**
 * Poskytne prevádzku na zaklade indexu z ArrayListu, ak pozadovaná prevádzka neexistuje tak vyskočí okno s upozonením.
 * @param index
 * @return prevadzka
 */
    public Prevadzky poskytniPrevadzku(int index) {
        if (index < 0 || index >= this.majetok.size()) {
            JOptionPane.showMessageDialog(this, "Chybne poradove cislo prevadzky, musiš si vybrat od 1 po " + this.majetok.size());
            return null;
        }
        return this.majetok.get(index);
    }

    public double getHodnotuTovarovSpolocnosti() {
        double hodnota = 0.0;
        for (int i = 0; i < this.majetok.size(); i++) {
            hodnota = hodnota + this.majetok.get(i).getPenaznyMajetok();
        }
        return hodnota;
    }

    public String toString() {
        String dataPrevadzok = "";
        for (int i = 0; i < this.majetok.size(); i++) {
            dataPrevadzok = dataPrevadzok + "Prevadzka " + (i + 1) + "\n" + this.majetok.get(i).toString();
        }
        return dataPrevadzok;
    }

    public void pridajTovariNaVelkosklad(String sidlo, String nazovObjednavaciehoListu) throws IOException {
        for (int i = 0; i < this.majetok.size(); i++) {
            Prevadzky prevadzka = this.poskytniPrevadzku(i);

            if (prevadzka instanceof VelkoSklad) {
                if (((VelkoSklad)prevadzka).getSidloVelkoSkladu().equals(sidlo)) {
                    ((VelkoSklad)prevadzka).prijemTovaruOdDodavatelov(nazovObjednavaciehoListu);
                    i = this.majetok.size();
                }
            }
        }

    }

}
