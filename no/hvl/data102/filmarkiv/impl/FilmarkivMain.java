package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.Scanner;

public class FilmarkivMain {

    public static void main(String[] args) {
        FilmarkivADT filma = new Filmarkiv(100);
        Meny meny = new Meny(filma);
        meny.start();

    }
}
