/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package potraviny;

import tovar.Polozka;

/**
 *
 * @author Rudolf Pastva
 */
public class Sladke extends Polozka {

    private String prichut;

    public Sladke(int idTovaru, String nazov, String vyrobca, double cenaZaKs, String prichut) {
        super(idTovaru, nazov, vyrobca, cenaZaKs);

        this.prichut = prichut;

    }
    public String getPrichut() {
        return this.prichut;
    }

    @Override
    public String toString() {
        String udaje = super.toString();
        return udaje + ", prichut: " + this.prichut;
    }
   

}
