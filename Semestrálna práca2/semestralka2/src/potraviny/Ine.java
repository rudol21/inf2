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
public class Ine extends Polozka {
/**
 * Parametrický konstruktor.
 * @param idTovaru
 * @param nazov
 * @param vyrobca
 * @param cenaZaKs 
 */
    public Ine(int idTovaru, String nazov, String vyrobca, double cenaZaKs) {
        super(idTovaru, nazov, vyrobca, cenaZaKs);

    }
/**
 * @return string
 */
    @Override
    public String toString() {
        return super.toString();
    }

}
