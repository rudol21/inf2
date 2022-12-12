/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tovar;

/**
 *Zjednocujúca trieda pre triedy z balíčka potraviny, je to ich predok.
 * @author Rudolf Pastva
 */
public abstract class Polozka {

    private int id;
    private String nazov;
    private String vyrobca;
    private double cenaZaKus;

    public Polozka(int idTovaru, String nazov, String vyrobca, double cenaZaKs) {
        this.id = idTovaru;
        this.nazov = nazov;
        this.vyrobca = vyrobca;
        this.cenaZaKus = cenaZaKs;

    }

    public int getId() {
        return this.id;
    }

    public String getNazov() {
        return this.nazov;
    }

    public String getVyrobca() {
        return this.vyrobca;
    }

    public double getCenaZaKus() {
        return this.cenaZaKus;
    }

    public String toString() {
        return "Polozka: " + this.id + " " + this.nazov + ", vyrobca: " + this.vyrobca + " ,cena za kus je: " + this.cenaZaKus + " eur";
    }

}
