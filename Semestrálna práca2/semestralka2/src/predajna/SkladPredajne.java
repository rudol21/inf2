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
 *Sklad predajne spolu  predajnou tvorí jeden obchod, sklad predajne objednáva a príjima tovar len z velkoSkladu, taktiež obsahuje ArrayList tovarov.
 * @author Rudolf Pastva
 */
public class SkladPredajne extends javax.swing.JOptionPane {

    private ArrayList<Tovar> zoznamTovaru;
    private VelkoSklad velkoSklad;
    private Predajna predajna;


    public SkladPredajne(VelkoSklad velkoSkl, Predajna predajna) {
        
        this.zoznamTovaru = new ArrayList<>();
        this.velkoSklad = velkoSkl;
        this.predajna = predajna;
    }

    public Tovar getTovar(int index) {
        return this.zoznamTovaru.get(index);
    }

    public String ponukaVelkoSkladu() {
        return this.velkoSklad.toString();
    }

    public int getPocetDruhovTovaru() {
        return this.zoznamTovaru.size();
    }
/**
 * Ak sa požadovaný tovar s daním id nenachádza na velkoSlade ta dôjde k zachyteniu vínimky, ak je počet kusov na velkoSklade nedostatočny tak vráti false,
 * ak sa pridavaný tovar na sklade predajne nenachádza tak sa pridá a ak tam už je tak sa len zvýši počet kusov.
 * @param id
 * @param pocet
 * @return boolean
 */
    public boolean pridajKusyTovaruNaSkladPredajneZVelkoskladu(int id, int pocet) {
        try {
            int pomocna = this.velkoSklad.dajIndexTovaru(id);
        } catch (IllegalArgumentException arg) {
            JOptionPane.showMessageDialog(this, "Nieje mozne doplnit kusi z velkoskladu: " + arg);
            return false;
        }

        if (this.velkoSklad.getPocKusovTovaru(id) < pocet) {
            JOptionPane.showMessageDialog(this, "Nedostatocny pocet kusov na sklade ");
            return false;
        }

        try {
            int index = this.dajIndexTovaru(id);
            this.zoznamTovaru.get(index).pridajKusy(pocet);
            this.velkoSklad.odoberKusyTovaruZVelkoSkladu(id, pocet);
            JOptionPane.showMessageDialog(this, "Pridaných " + pocet + " kusov tovaru s id " + id);
            return true;
        } catch (IllegalArgumentException arg) {
            this.pridajTovarNaSklad(this.velkoSklad.getTovar(this.velkoSklad.dajIndexTovaru(id)), pocet);
            JOptionPane.showMessageDialog(this, "Tovar s id " + id + " bol pridany na sklad predajne, pocet kusov " + pocet);
            return true;
        }

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
/**
 * Táto metóda pridáva tovar na sklad ak sa tam ešte nenachádza, najprv sa vytvorí nový tovar o počte kusov nula a následne sa pomocou metody pridajKusy() v triede Tovar
 * zvýši pocet kusov, a taktiež sa zavolá metóda odoberKusyTovaruZVelkoSkladu() v triede VelkoSklad ktorá odoberie kusy tovaru ktoré boli pridané do skladuPredajne.
 * @param paTovar
 * @param pocetKusov
 * @return boolean
 */
    public boolean pridajTovarNaSklad(Tovar paTovar, int pocetKusov) {
        if (pocetKusov < 1) {
            JOptionPane.showMessageDialog(this, "Pocet pridavaných kusov musí byť aspoň 1 ");
            return false;
        }
        this.zoznamTovaru.add(new Tovar(paTovar.getPolozka(), 0));
        int pomocna = this.dajIndexTovaru(paTovar.getId());
        this.zoznamTovaru.get(pomocna).pridajKusy(pocetKusov);
        System.out.println(this.zoznamTovaru.get(pomocna).getPocetKusov());
        this.velkoSklad.odoberKusyTovaruZVelkoSkladu(paTovar.getId(), pocetKusov);
        return true;
    }
/**
 * Ak sa tovar s id nenájde tak dôjde k zachyteniu vínimky.
 * @param id
 * @param pocet
 * @return boolean
 */
    public boolean vylozTovarDoPredajne(int id, int pocet) {
        int pomocna;
        try {
            pomocna = this.dajIndexTovaru(id);
        } catch (IllegalArgumentException arg) {
            JOptionPane.showMessageDialog(this, arg);
            return false;
        }

        if (this.zoznamTovaru.get(pomocna).getPocetKusov() < pocet) {
            JOptionPane.showMessageDialog(this, "Nedostatocny pocet kusov na sklade predajne ");
            return false;
        }
        this.predajna.prijemTovaruZoSkladu(this.zoznamTovaru.get(pomocna), pocet);
        this.zoznamTovaru.get(pomocna).odoberKusy(pocet);
        JOptionPane.showMessageDialog(this, "Tovar vylozeny");
        return true;

        
    }

    @Override
    public String toString() {
        String udaje = "Sklad predajne ma tovar: \n";
        for (int i = 0; i < this.zoznamTovaru.size(); i++) {
            udaje = udaje + this.zoznamTovaru.get(i).toString() + "\n";
        }
        return udaje;
    }

    public double celkovaHodnotaTovarovNaSklade() {
        double suma = 0.0;
        for (int i = 0; i < this.zoznamTovaru.size(); i++) {
            suma = suma + this.zoznamTovaru.get(i).dajCenuZaVsKusy();
        }

        return suma;

    }

    public boolean mozemZrusitPrevadzku() {
        for (int i = 0; i < this.zoznamTovaru.size(); i++) {
            if (this.zoznamTovaru.get(i).getPocetKusov() != 0) {
                return false;
            }
        }
        return true;
    }

}
