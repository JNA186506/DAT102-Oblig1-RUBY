package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tekstgrensesnitt {


    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm(){
        Scanner s = new Scanner(System.in);

        System.out.println("Skriv inn filmnummer");
        int filmNr = Integer.parseInt(s.nextLine());

        System.out.println("Skriv inn produsent");
        String produsent = s.nextLine();

        System.out.println("Skriv inn tittel");
        String tittel = s.nextLine();

        System.out.println("Skriv inn lanseringsår");
        int lanseringsAar = Integer.parseInt(s.nextLine());

        System.out.println("Skriv inn filmselskap");
        String filmselskap = s.nextLine();

        System.out.println("Velg sjanger: ");
        String sjanger = s.nextLine();

        return new Film(filmNr, produsent, tittel, lanseringsAar, filmselskap, sjanger);
    }
    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        StringBuilder s = new StringBuilder();

        s.append("[Film nummer: " + film.getFilmnr())
                .append(" Produsent: " + film.getProdusent())
                .append(" Tittel: " + film.getTittel())
                .append(" Lansering: " + film.getLansering())
                .append(" Filmselskap: " + film.getFilmselskap())
                .append(" Sjanger: " + film.getSjanger() + "]");

        System.out.println(s);
    }
    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] film = arkiv.soekTittel(delstreng);
        for (int i = 0; i < film.length; i++) {
            skrivUtFilm(film[i]);
        }

    }
    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] film = arkiv.soekProdusent(delstreng);
        for (int i = 0; i < film.length; i++) {
            skrivUtFilm(film[i]);
        }
    }
    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
// og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        Film[] ark = arkiv.getArkiv();

        if (ark == null || arkiv.antall() == 0) {
            System.out.println("Arkivet er tomt");
        }

        int totaltAntall = arkiv.antall();

        Map<Film.Sjanger, Integer> sjangerTelling = new HashMap<>();

        for (Film f : ark) {
            if (f != null) {
                Film.Sjanger sjanger = f.getSjanger();
                sjangerTelling.put(sjanger, sjangerTelling.getOrDefault(sjanger, 0) + 1);
            }
        }
    }
// osv ... andre metoder
}

