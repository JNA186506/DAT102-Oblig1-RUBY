package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.Scanner;

public class FilmarkivMain {

    public static void main(String[] args) {
        FilmarkivADT film = new Filmarkiv();
        Meny meny = new Meny(film);
        meny.start();

    }
}
