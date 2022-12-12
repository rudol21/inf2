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
public class Pecivo extends Polozka {

    private String druhMuky;

    public Pecivo(int idTovaru, String nazov, String vyrobca, double cenaZaKs, String muka) {
        super(idTovaru, nazov, vyrobca, cenaZaKs);

        this.druhMuky = muka;

    }

    public String getDruhMuky() {
        return this.druhMuky;
    }

    @Override
    public String toString() {
        String udaje = super.toString();
        return udaje + ", druh muky: " + this.druhMuky;
    }

}
