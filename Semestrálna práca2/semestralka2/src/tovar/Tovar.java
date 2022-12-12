/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tovar;

/**
 *Hlavnou úlohou tejto triedy je uchovávať informácie o počte kusov polozky.
 * @author Rudolf Pastva
 */
public class Tovar {

    private int pocetKusov;
    private Polozka polozka;

    public Tovar(Polozka polozka, int pocetKs) {
        this.polozka = polozka;
        this.pocetKusov = pocetKs;
    }

    public int getPocetKusov() {
        return this.pocetKusov;
    }

    public void setPocetKusov(int novyPocetKusov) {
        this.pocetKusov = novyPocetKusov;
    }

    public Polozka getPolozka() {
        return this.polozka;
    }

    public int getId() {
        return this.polozka.getId();
    }

    public String toString() {
        return this.polozka.toString() + ", pocet kusov: " + this.pocetKusov;
    }

    public boolean odoberKusy(int pocetOdobranych) {
        if (this.pocetKusov >= pocetOdobranych) {
            this.pocetKusov = this.pocetKusov - pocetOdobranych;
            return true;
        } else {

            return false;
        }
    }

    public boolean pridajKusy(int pocetPridanychKusov) {
        this.pocetKusov = this.pocetKusov + pocetPridanychKusov;
        return true;
    }

    public double dajCenuZaVsKusy() {
        double cena = 0.0;
        cena = this.pocetKusov * this.polozka.getCenaZaKus();
        return cena;
    }

}
