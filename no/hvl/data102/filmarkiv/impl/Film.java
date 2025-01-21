package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {

    private int filmnr;
    private String produsent;
    private String tittel;
    private int lansering;
    private String filmselskap;
    private Sjanger sjanger;

    public enum Sjanger {
        ACTION, DRAMA, HISTORY, SCIFI;
        public static Sjanger finnSjanger(String navn) {
            for (Sjanger s : Sjanger.values()) {
                if (s.toString().equals(navn.toUpperCase())) {
                    return s;
                }
            }
            return null;
        }
    }

    public Film(int filmnr, String produsent, String tittel, int lansering, String filmselskap, String sjanger) {
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.lansering = lansering;
        this.filmselskap = filmselskap;
        this.sjanger = Sjanger.finnSjanger(sjanger);
    }

    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public String getProdusent() {
        return produsent;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getLansering() {
        return lansering;
    }

    public void setLansering(int lansering) {
        this.lansering = lansering;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmnr == film.filmnr && lansering == film.lansering && Objects.equals(produsent, film.produsent) && Objects.equals(tittel, film.tittel) && Objects.equals(filmselskap, film.filmselskap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmnr, produsent, tittel, lansering, filmselskap);
    }
}
