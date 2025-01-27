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
        LinearNode<Film> currNode = arkiv;
        Film[] arkiv = new Film[antall];

        int i = 0;
        while (currNode != null) {
            arkiv[i] = currNode.data;
            i++;
            currNode = currNode.neste;
        }

        return arkiv;
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
        if (nyFilm == null) {
            throw new IllegalArgumentException("Ny film kan ikke være null");
        }
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

        if  (slett == null) {
            return false;
        }

        while (currNode != null) {
            if (currNode.data.equals(slett)) {
                prevNode.neste = currNode.neste;
                antall--;
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

        LinearNode<Film> currNode = arkiv;
        while (currNode != null) {
            if (currNode.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                treffListe.add(currNode.data);
            }
            currNode = currNode.neste;
        }
        return treffListe.toArray(new Film[treffListe.size()]);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        List<Film> treffListe = new ArrayList<>();

        LinearNode<Film> currNode = arkiv;
        while (currNode != null) {
            if (currNode.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
                treffListe.add(currNode.data);
            }
            currNode = currNode.neste;
        }
        return treffListe.toArray(new Film[treffListe.size()]);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int antallSjanger = 0;

        LinearNode<Film> currNode = arkiv;
        while (currNode != null) {
            if (currNode.data.getSjanger().equals(sjanger)) {
                antallSjanger++;
            }
            currNode = currNode.neste;
        }
        return antallSjanger;
    }

    @Override
    public int antall() {
        return antall;
    }
}
