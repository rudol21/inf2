/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predajna;

import java.util.ArrayList;
import tovar.Tovar;
import obchod.Prevadzky;
import java.util.Scanner;
import java.io.IOException;
import obchod.VelkoSkladForm;
import potraviny.Ine;
import potraviny.Maso;
import potraviny.Pecivo;
import potraviny.Sladke;
import potraviny.ZelOvoc;

/**
 * Trieda VelkoSklad implementuje interface Prevadzky.Obsahuje atribúty
 * velkoSkladForm, sidloVelkoSkladu, zoznamTovaru, ArrayList zoznamTovaru je
 * typu Tovar, VelkoSklad môže dopĺnať dovar len od dodávatelov, a dalej
 * distribuuje dovar do jednotlivých prevádzok spoločnosti.
 *
 * @author Rudolf Pastva
 * @version 1.0
 */

public class VelkoSklad implements Prevadzky {

    private VelkoSkladForm velkoSkladForm;
    private String sidloVelkoSkladu;
    private ArrayList<Tovar> zoznamTovaru;

    /**
     * Parametrický konstruktor
     *
     * @param sidlo velkoSkladu
     */
    public VelkoSklad(String sidlo) {
        this.velkoSkladForm = new VelkoSkladForm(this);
        this.sidloVelkoSkladu = sidlo;
        this.zoznamTovaru = new ArrayList<Tovar>();
    }

    /**
     * Metóda vráti miesto kde sa nachádza VelkoSklad
     *
     * @return sídlo VelkoSkladu
     */
    public String getSidloVelkoSkladu() {
        return this.sidloVelkoSkladu;
    }

    /**
     * Na základe indexu sa v ArrayListe vyhladá Tovar ak sa nenájde vráti null.
     *
     * @param index
     * @return Tovar
     */
    public Tovar getTovar(int index) {
        if (index < 0 || index >= this.zoznamTovaru.size()) {
            return null;
        }
        return this.zoznamTovaru.get(index);
        /*
    try {
    Tovar tovar = this.zoznamTovaru.get(index);
    return tovar;
     }
    catch(IllegalArgumentException arg) {
    JOptionPane.showMessageDialog(this,  "Tovar s id " + id + " bol pridany na sklad predajne, pocet kusov " + pocet);
    }
         */
    }

    /**
     * Metóda ktorá nastaví viditelnosť GUI okna velkoSkladForm na true.
     */
    public void getVisible() {
        this.velkoSkladForm.setVisible(true);
    }

    /**
     * metóda ktorá na základe id tovaru vráti pocet kusov daného tovaru.
     *
     * @param id
     * @return pocet kusov tovaru
     */
    public int getPocKusovTovaru(int id) {
        int index = this.dajIndexTovaru(id);

        if (index == -1) {
            return -1;
        }
        return this.zoznamTovaru.get(index).getPocetKusov();
    }

    /**
     * Metóda ktorá zabezpečuje prídávanie kusov tovaru na velkosklad ked sa
     * tovar už na sklade nachádza.
     *
     * @param id
     * @param pocet
     * @return boolean
     */
    public boolean pridajKusyTovaruNaVelkoSklad(int id, int pocet) {
        int index = this.dajIndexTovaru(id);
        this.zoznamTovaru.get(index).pridajKusy(pocet);
        return true;
    }

    /**
     * Metóda pomocou ktorej odoberám kusy tovaru z velkoskladu, tovar je
     * vyhladaný na základe id.
     *
     * @param id
     * @param pocet
     * @return boolean
     */
    public boolean odoberKusyTovaruZVelkoSkladu(int id, int pocet) {
        int index = this.dajIndexTovaru(id);
        this.zoznamTovaru.get(index).odoberKusy(pocet);
        return true;
    }

    /**
     * Metóda ktorá vracia index hladaného tovaru v ArayListe na zaklade id
     * tovaru.
     *
     * @param id tovaru
     * @return index tovaru v ArrayListe
     * @throws IllegalArgumentException
     */
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
     * Metóda pridá celý tovar do ArrayListu ak sa v nom tovar ešte nenachádza,
     * ale ak sa tam už nachádza tak sa len pridajú kusy pomocou metódy
     * pridajKusyTovaruNaVelkoSklad.
     *
     * @param paTovar
     * @return boolean
     */
    public boolean pridajTovarNaVelkoSklad(Tovar paTovar) {

        for (int i = 0; i < this.zoznamTovaru.size(); i++) {
            if (this.zoznamTovaru.get(i).getId() == paTovar.getId()) {
                this.pridajKusyTovaruNaVelkoSklad(paTovar.getId(), paTovar.getPocetKusov());
                System.out.println("Tovar s id " + paTovar.getId() + " sa na sklade predajne uz nachadza,zvyseny pocet ks");
                return true;
            }
        }
        this.zoznamTovaru.add(paTovar);
        return true;
    }

    /**
     * Táto metóda vymaže tovar z velkoskladu ak je počet kusov tovaru rovný
     * nule.
     *
     * @param paTovar
     * @return vymazaný tovar
     */
    public Tovar zrusTovarZVelkoSkladu(Tovar paTovar) {
        int index = this.dajIndexTovaru(paTovar.getId());
        if (index == -1) {
            return null;
        }
        if (this.zoznamTovaru.get(index).getPocetKusov() == 0) {
            Tovar pomocna = this.zoznamTovaru.get(index);
            this.zoznamTovaru.remove(index);
            return pomocna;
        }
        return null;
    }

    /**
     * Metóda oboberie všetky kusy tovaru.
     *
     * @param paTovar
     * @return boolean
     */
    public boolean odoberVsetkyKusyTovaru(Tovar paTovar) {
        int index = this.dajIndexTovaru(paTovar.getId());
        if (index == -1) {
            return false;
        }
        int pomocna = this.zoznamTovaru.get(index).getPocetKusov();
        this.zoznamTovaru.get(index).odoberKusy(pomocna);
        return true;
    }

    /**
     * Metóda toString vráti retazec z údajmi o všetkých tovaroch.
     *
     * @return údaje všetkých tovarov
     */
    public String toString() {
        String udaje = "Velkosklad ma tovar \n";
        for (int i = 0; i < this.zoznamTovaru.size(); i++) {
            udaje = udaje + this.zoznamTovaru.get(i).toString() + "\n";
        }
        return udaje;
    }

    /**
     * Spočíta hodnotu tovarov na velko sklade.
     *
     * @return hodnota v eurach
     */
    public double getPenaznyMajetok() {
        double suma = 0.0;
        for (int i = 0; i < this.zoznamTovaru.size(); i++) {
            suma = suma + this.zoznamTovaru.get(i).dajCenuZaVsKusy();
        }

        return suma;

    }

    /**
     * Metóda ktorá vráti false ak nemôžem zrušiť prevádzku, a true ak ju môžem
     * zrušiť, zrušiť sa dá len prevádzka ktorá nemá ani jeden kus tovaru.
     *
     * @return boolean
     */
    
    public boolean mozemZrusitPrevadzku() {
        for (int i = 0; i < this.zoznamTovaru.size(); i++) {
            if (this.zoznamTovaru.get(i).getPocetKusov() != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metóda ktorá zabezpečuje príjem tovarov od dodávatelov, údaje číta z
     * textového súboru, pričom v súbore je uvedené o aký sortiment tovaru sa
     * jedná, obsahuje struktúru switch case.
     *
     * @param názov dodacieho listu
     * @throws IOException
     */
    public void prijemTovaruOdDodavatelov(String nazovSuboru) throws IOException {

        java.io.File subor = new java.io.File(nazovSuboru + ".txt");
        Scanner citac = new Scanner(subor);

        String pomocna = "";
        String druhTovaru;
        String string1;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        int id = -1;
        int mnozstvo = -1;
        double cena = 0.0;
        double vaha = 0.0;
        Tovar tovar;

        while (citac.hasNext()) {
            string1 = citac.next();

            if (string1.equals("/")) {
                pomocna = citac.next();

            } else {
                id = Integer.parseInt(string1);

                string2 = citac.next();
                string3 = citac.next();
                string4 = citac.next();
                string5 = citac.next();

                switch (pomocna) {
                    case "Pecivo":
                        string6 = citac.next();

                        cena = Double.parseDouble(string4);
                        mnozstvo = Integer.parseInt(string6);
                        Pecivo pecivo;
                        pecivo = new Pecivo(id, string2, string3, cena, string5);

                        tovar = new Tovar(pecivo, mnozstvo);
                        this.pridajTovarNaVelkoSklad(tovar);
                        break;
                    case "Maso":

                        string6 = citac.next();
                        string7 = citac.next();
                        cena = Double.parseDouble(string4);
                        vaha = Double.parseDouble(string6);
                        mnozstvo = Integer.parseInt(string7);
                        Maso maso;
                        maso = new Maso(id, string2, string3, cena, string5, vaha);

                        tovar = new Tovar(maso, mnozstvo);
                        this.pridajTovarNaVelkoSklad(tovar);

                        break;
                    case "Ine":

                        cena = Double.parseDouble(string4);
                        mnozstvo = Integer.parseInt(string5);
                        Ine ine;
                        ine = new Ine(id, string2, string3, cena);

                        tovar = new Tovar(ine, mnozstvo);
                        this.pridajTovarNaVelkoSklad(tovar);

                        break;
                    case "Sladke":

                        string6 = citac.next();

                        cena = Double.parseDouble(string4);
                        mnozstvo = Integer.parseInt(string6);
                        Sladke sladke;
                        sladke = new Sladke(id, string2, string3, cena, string5);

                        tovar = new Tovar(sladke, mnozstvo);
                        this.pridajTovarNaVelkoSklad(tovar);

                        break;
                    case "ZelOvoc":

                        string6 = citac.next();

                        cena = Double.parseDouble(string4);
                        mnozstvo = Integer.parseInt(string6);
                        ZelOvoc zelOvoc;
                        zelOvoc = new ZelOvoc(id, string2, string3, cena, string5);

                        tovar = new Tovar(zelOvoc, mnozstvo);
                        this.pridajTovarNaVelkoSklad(tovar);

                        break;
                }

            }

        }
        citac.close();
    }
}
