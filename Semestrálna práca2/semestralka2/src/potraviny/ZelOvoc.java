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
public class ZelOvoc extends Polozka {

    private String krajinaPovodu;


    public ZelOvoc(int idTovaru, String nazov, String vyrobca, double cenaZaKs, String krPovodu) {
        super(idTovaru, nazov, vyrobca, cenaZaKs);
        this.krajinaPovodu = krPovodu;
        
    }

    public String getKrajinaPovodu() {
        return this.krajinaPovodu;
    }

    @Override
    public String toString() {
        String udaje = super.toString();
        return udaje + " ,krajina povodu " + this.krajinaPovodu;
    }

}
