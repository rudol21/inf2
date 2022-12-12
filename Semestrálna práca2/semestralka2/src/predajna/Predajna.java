/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predajna;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import tovar.Tovar;

/**
 *Táto trieda spolu so skladom predajne tvoria jeden obchod, tovar predajne sa uchováva v ArrayListe zoznamTovaru.
 *@author Rudolf Pastva
 */
public class Predajna extends javax.swing.JOptionPane {

    private ArrayList<Tovar> zoznamTovaru;
    private double celkovaTrzba;

    public Predajna() {
        this.zoznamTovaru = new ArrayList<Tovar>();
        this.celkovaTrzba = 0.0;
    }

    public Tovar getTovar(int index) {
        return this.zoznamTovaru.get(index);
    }

    public int getPocetDruhovTovaru() {
        return this.zoznamTovaru.size();
    }

    public void setCelkovuTrzbu(double suma) {
        this.celkovaTrzba = this.celkovaTrzba + suma;
    }

    public double getCelkovaTrzba() {
        return this.celkovaTrzba;
    }
/**
 * Ak sa daný tovar na predajni nenachádza tak sa do nej pridá, ale ak sa už predajni nachádza tak sa zvýši len počet kusov.
 * @param tovar na prijatie
 * @param pocet kusov
 * @return boolean
 */
    public boolean prijemTovaruZoSkladu(Tovar paTovar, int pocet) {
        int pomocna = this.jeTovarUzNaPredaji(paTovar.getId());
        int pomocna2 = paTovar.getPocetKusov();
        if (pomocna == -1) {
            this.zoznamTovaru.add(new Tovar(paTovar.getPolozka(), 0));
            this.zoznamTovaru.get(this.dajIndexTovaru(paTovar.getId())).pridajKusy(pocet);
            return true;
        }
        pomocna = this.dajIndexTovaru(paTovar.getId());
        this.zoznamTovaru.get(pomocna).pridajKusy(pocet);
        return true;
    }

    public int jeTovarUzNaPredaji(int id) {
        for (int i = 0; i < this.zoznamTovaru.size(); i++) {
            if (this.zoznamTovaru.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int dajIndexTovaru(int id) throws IllegalArgumentException {
        
        for (int i = 0; i < this.zoznamTovaru.size(); i++) {
            if (this.zoznamTovaru.get(i).getId() == id) {
                return i;
            }
        }
        IllegalArgumentException arg = new IllegalArgumentException("Tovar s id " + id + " nenajdený");
        throw arg;
    }

    public String toString() {
        String udaje = "Predajna ma tovar: \n";
        for (int i = 0; i < this.zoznamTovaru.size(); i++) {
            udaje = udaje + this.zoznamTovaru.get(i).toString() + "\n";
        }
        return udaje;
    }
/**
 * Metóda vráti aktuálnu hodnotu tovarov na predajni.
 * @return suma
 */
    public double celkovaHodnotaTovaruNaPredajni() {
        double suma = 0.0;
        for (int i = 0; i < this.zoznamTovaru.size(); i++) {
            suma = suma + this.zoznamTovaru.get(i).dajCenuZaVsKusy();
        }
        return suma;
    }
/**
 * Metóda predaj tovaru zachytí výnimku ak sa tovar s pozadovaním id nenachádza na Predajni, ďalej ak je pocet kusov tovaru rovný nule tak sa nič nepredá,
 * ale ak je pocet kusov tovaru na predajni len menší ako požadovaní počet tak sa predá aspoň to čo je na predajni a kupujúci dostane informáciu o množstve.
 * @param id
 * @param pocetKusov 
 */
    public void predajTovaru(int id, int pocetKusov) {
        try {
            int index = this.dajIndexTovaru(id);
            if (pocetKusov <= this.zoznamTovaru.get(index).getPocetKusov()) {
                this.zoznamTovaru.get(index).odoberKusy(pocetKusov);
                double suma1 = (pocetKusov * this.zoznamTovaru.get(index).getPolozka().getCenaZaKus());
                this.setCelkovuTrzbu(suma1);
                JOptionPane.showMessageDialog(this, "Bolo predaných " + pocetKusov + " ks hodnota predaného tovaru je: " + suma1 + " eur " + this.zoznamTovaru.get(index).getPolozka().toString());
            } else {
                if (this.zoznamTovaru.get(index).getPocetKusov() == 0) {
                    JOptionPane.showMessageDialog(this, "Pocet kusov na na predajni 0 bolo predaných 0 " + " ks" + this.zoznamTovaru.get(index).getPolozka().toString());

                } else {
                    double suma2 = (this.zoznamTovaru.get(index).getPocetKusov() * this.zoznamTovaru.get(index).getPolozka().getCenaZaKus());
                    this.setCelkovuTrzbu(suma2);
                    JOptionPane.showMessageDialog(this, "Nedostatok kusov, predanych " + this.zoznamTovaru.get(index).getPocetKusov() + " ks hodnota predaného tovaru je: " + suma2 + " eur " + this.zoznamTovaru.get(index).getPolozka().toString());
                    this.zoznamTovaru.get(index).odoberKusy(this.zoznamTovaru.get(index).getPocetKusov());
                }
            }
        } catch (IllegalArgumentException arg) {
            JOptionPane.showMessageDialog(this, arg);

        }
    }
/**
 * Vráti true ak sa na predajni nenachádza žiadny kus tovaru.
 * @return 
 */
    public boolean mozemZrusitPrevadzku() {
        for (int i = 0; i < this.zoznamTovaru.size(); i++) {
            if (this.zoznamTovaru.get(i).getPocetKusov() != 0) {
                return false;
            }
        }
        return true;
    }

}
