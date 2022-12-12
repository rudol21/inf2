/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obchod;

import predajna.Predajna;
import predajna.SkladPredajne;

/**
 *Trieda Obchod je tvorená predajnou a skladom predajne, tovar sa do predajne môže dopĺnať len z jej skladu ktorého dodávatelom je velko sklad, taktiež
 * pri definícii vznikne GUI okno ObchodForm.
 * @author Rudolf Pastva
 */
public class Obchod implements Prevadzky {

    private ObchodForm obchodForm;
    private String sidloObchodu;
    private Predajna predajna;
    private SkladPredajne skladPredajne;

    public Obchod(String sidlo, Predajna predajna, SkladPredajne skladPredajne) {
        this.obchodForm = new ObchodForm(this);
        this.sidloObchodu = sidlo;
        this.predajna = predajna;
        this.skladPredajne = skladPredajne;
    }

    public Predajna getPredajna() {
        return this.predajna;
    }

    public void getVisible() {
        this.obchodForm.setVisible(true);
    }

    public String getSidloObchodu() {
        return this.sidloObchodu;
    }

    public SkladPredajne getSkladPredajne() {
        return this.skladPredajne;
    }

    public boolean objednajTovarZVelkoskladu(int id, int pocetKusov) {
        this.skladPredajne.pridajKusyTovaruNaSkladPredajneZVelkoskladu(id, pocetKusov);
        return true;
    }

    public boolean vylozTovarZoSkladuDoPredajne(int id, int pocetKusov) {

        this.skladPredajne.vylozTovarDoPredajne(id, pocetKusov);

        return true;
    }
/**
 * Vyložia sa všetky kusy jedného tovaru ktorí je identifikovaný na základe id.
 * @param id
 * @return boolean
 */
    public boolean vylozVsetokTovarZoSkladuDoPredajne(int id) {
        int pocetVsetkychKusov = this.skladPredajne.getTovar(this.skladPredajne.dajIndexTovaru(id)).getPocetKusov();
        this.skladPredajne.vylozTovarDoPredajne(id, pocetVsetkychKusov);
        return true;
    }
/**
 * Táto metóda volá metódu predajTovaru v triede Predajna.
 * @param id
 * @param pocetKusov 
 */
    public void predaj(int id, int pocetKusov) {
        this.predajna.predajTovaru(id, pocetKusov);
    }

    public double getPenaznyMajetok() {
        double suma = 0.0;
        suma = this.predajna.celkovaHodnotaTovaruNaPredajni() + this.skladPredajne.celkovaHodnotaTovarovNaSklade();
        return suma;
    }
/**
 * Metóda toString v triede obchod najprv zosumarizuje všetok tovar v obchode vypše ho a následne vypíše len tovar ktorí je na predajni a ktorí na sklade predajne.
 * @return udaje
 */
    public String toString() {
        String udaje = "Obchod ma tovar \n";

        int pomocna1 = this.skladPredajne.getPocetDruhovTovaru();
        int pomocna2 = this.predajna.getPocetDruhovTovaru();
        for (int i = 0; i < pomocna1; i++) {
            int id = this.skladPredajne.getTovar(i).getId();
            for (int j = 0; j < pomocna2; j++) {
                if (this.predajna.getTovar(j).getId() == id) {
                    int pocetKusovSkladuAPredajne = this.skladPredajne.getTovar(i).getPocetKusov() + this.predajna.getTovar(j).getPocetKusov();
                    udaje = udaje + this.skladPredajne.getTovar(i).getPolozka().toString() + " pocet kusov: " + pocetKusovSkladuAPredajne + "\n";
                    j = pomocna2;
                }
                if (j == (pomocna2 - 1)) {
                    udaje = udaje + this.skladPredajne.toString();
                }

            }

        }
        udaje = udaje + "Z toho " + this.predajna.toString() + "a " + this.skladPredajne.toString();
        return udaje;
    }

    public boolean mozemZrusitPrevadzku() {
        this.predajna.mozemZrusitPrevadzku();
        this.skladPredajne.mozemZrusitPrevadzku();
        if (this.skladPredajne.mozemZrusitPrevadzku() && this.predajna.mozemZrusitPrevadzku()) {
            return true;
        }
        return false;
    }

}
