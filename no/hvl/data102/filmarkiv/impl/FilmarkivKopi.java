package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilmarkivKopi {

    public class Filmarkiv implements FilmarkivADT {

        private Film[] arkiv;
        private int antall;
        private Film.Sjanger[] sjangTab;

        public Filmarkiv(int maksantall) {
            sjangTab = Film.Sjanger.values();
            arkiv = new Film[maksantall];
            antall = 0;
        }

        public Film[] getArkiv() {
            return arkiv;
        }

        @Override
        public Film finnFilm(int nr) {
            for (int i = 0; i < antall; i++) {
                if (nr == arkiv[i].getFilmnr()) {
                    return arkiv[i];
                }
            }
            return null;
        }

        @Override
        public boolean leggTilFilm(Film nyFilm) {
            if (antall == arkiv.length) {
                arkiv = Arrays.copyOf(arkiv, arkiv.length*2);
            }
            arkiv[antall] = nyFilm;
            antall++;
            return true;
        }

        @Override
        public boolean slettFilm(int filmnr) {
            for (int i = 0; i < arkiv.length; i++) {
                if (filmnr == arkiv[i].getFilmnr()) {
                    arkiv[i] = arkiv[antall-1];
                    arkiv[antall-1] = null;
                    antall--;
                    return true;
                }
            }
            return false;
        }

        @Override
        public Film[] soekTittel(String delstreng) {
            List<Film> treffListe = new ArrayList<>();
            for (int i = 0; i < antall; i++) {
                if (arkiv[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                    treffListe.add(arkiv[i]);
                }
            }
            return treffListe.toArray(new Film[treffListe.size()]);
        }

        @Override
        public Film[] soekProdusent(String delstreng) {
            List<Film> treffListe = new ArrayList<>();
            for (int i = 0; i < antall; i++) {
                if (arkiv[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
                    treffListe.add(arkiv[i]);
                }
            }
            return treffListe.toArray(new Film[treffListe.size()]);
        }

        @Override
        public int antall(Film.Sjanger sjanger) {
            int antallSjanger = 0;
            for (int i = 0; i < antall; i++) {
                if (false) {
                    antallSjanger++;
                }
            }
            return antallSjanger;
        }

        @Override
        public int antall() {
            return antall;
        }
    }

}
