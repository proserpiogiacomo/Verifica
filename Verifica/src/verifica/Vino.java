/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verifica;

/**
 *
 * @author proserpio_giacomo
 */
public class Vino {
    private String anno;
    private String regione;
    private String codice;
    private int docDocg;
    private int igt;
    private int daTavola;
    private int totale;

    public Vino() {
        this.anno = "";
        this.regione = "";
        this.codice = "";
        this.docDocg = 0;
        this.igt = 0;
        this.daTavola = 0;
        this.totale = 0;
    }
    public Vino(String anno, String regione, String codice, int docDocg, int igt, int daTavola, int totale) {
        this.anno = anno;
        this.regione = regione;
        this.codice = codice;
        this.docDocg = docDocg;
        this.igt = igt;
        this.daTavola = daTavola;
        this.totale = totale;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getDocDocg() {
        return docDocg;
    }

    public void setDocDocg(int docDocg) {
        this.docDocg = docDocg;
    }

    public int getIgt() {
        return igt;
    }

    public void setIgt(int igt) {
        this.igt = igt;
    }

    public int getDaTavola() {
        return daTavola;
    }

    public void setDaTavola(int daTavola) {
        this.daTavola = daTavola;
    }

    public int getTotale() {
        return totale;
    }

    public void setTotale(int totale) {
        this.totale = totale;
    }
    public String toString(){
        return anno + "-"+ regione + "-" + codice + "-" + docDocg + "-" + igt + "-" + daTavola + "-" + totale;
    }
    
}
