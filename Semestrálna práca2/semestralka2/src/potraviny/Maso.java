/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package potraviny;

import tovar.Polozka;

/**
 *Potomok triedy Polozka.
 * @author Rudolf Pastva
 */
public class Maso extends Polozka {


    private String krajinaPovodu;
    private double vaha;
/**
 * Parametrický konštruktor.
 * @param idTovaru
 * @param nazov
 * @param vyrobca
 * @param cenaZaKs
 * @param krPovodu
 * @param vahaKus 
 */
    public Maso(int idTovaru, String nazov, String vyrobca, double cenaZaKs, String krPovodu, double vahaKus) {
        super(idTovaru, nazov, vyrobca, cenaZaKs);

        this.krajinaPovodu = krPovodu;
        this.vaha = vahaKus;
    }

    public String getKrajinaPovodu() {
        return this.krajinaPovodu;
    }

    public double getVaha() {
        return this.vaha;
    }

    @Override
    public String toString() {
        String udaje = super.toString();
        return udaje + " ,krajina povodu " + this.krajinaPovodu + " ,vaha kusu: " + this.vaha;
    }

}
