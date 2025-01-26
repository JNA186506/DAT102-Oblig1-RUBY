package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film.Sjanger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filmarkiv implements FilmarkivADT {

    private LinearNode<Film> arkiv;
    private int antall;

    public Filmarkiv() {
        this.arkiv = null;
        this.antall = 0;
    }

    public Film[] getArkiv() {
        //TODO
        return null;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> p = arkiv;

        while (p != null) {
            if (p.data.getFilmnr() == nr) {
                return p.data;
            }
            p = p.neste;
        }
        return null;
    }

    public boolean erTom() {
        return arkiv == null;
    }

    @Override
    public boolean leggTilFilm(Film nyFilm) {
        LinearNode<Film> n = new LinearNode<>(nyFilm);
        n.neste = arkiv;
        arkiv = n;
        antall++;
        return true;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if (erTom()) {
            return false;
        }
        LinearNode<Film> currNode = arkiv, prevNode = null;
        Film slett = finnFilm(filmnr);

        if (currNode.data.equals(slett)) {
            arkiv = currNode.neste;
            return true;
        }

        while (currNode != null) {
            if (currNode.data.equals(slett)) {
                prevNode.neste = currNode.neste;
                return true;
            }
            prevNode = currNode;
            currNode = currNode.neste;
        }

        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        List<Film> treffListe = new ArrayList<>();

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
    public int antall(Sjanger sjanger) {
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
