package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FilmarkivTEST {

    @Test
    void testLeggTilFilm() {
        Film action = new Film(100, "Clint Eastwood", "3:10 to Yuma", 1992, "Universal", "ACTION");
        Film SCIFI = new Film(101, "Stanley Kubrick", "2001 a space odyssey", 2001, "Universal", "SCIFI");

        Filmarkiv a = new Filmarkiv();

        assertTrue(a.leggTilFilm(action), "Filmen burde legges til");
        assertTrue(a.leggTilFilm(SCIFI),"Filmen burde legges til");
        assertEquals(2, a.antall());

    }

    @Test
    void testSlettFilm() {
        Film action = new Film(100, "Clint Eastwood", "3:10 to Yuma", 1992, "Universal", "ACTION");
        Film SCIFI = new Film(101, "Stanley Kubrick", "2001 a space odyssey", 2001, "Universal", "SCIFI");
        Filmarkiv a = new Filmarkiv();

        assertTrue(a.leggTilFilm(action),"Filmen burde legges til");
        assertTrue(a.leggTilFilm(SCIFI),"Filmen burde legges til");
        assertEquals(2, a.antall());

        assertTrue(a.slettFilm(100),"Filmen burde slettes");
        assertEquals(1, a.antall());
    }

    @Test
    void testFinnFilm() {
        Film action = new Film(100, "Clint Eastwood", "3:10 to Yuma", 1992, "Universal", "ACTION");
        Film SCIFI = new Film(101, "Stanley Kubrick", "2001 a space odyssey", 2001, "Universal", "SCIFI");
        Filmarkiv a = new Filmarkiv();

        a.leggTilFilm(action);
        a.leggTilFilm(SCIFI);

        Film funnetFilm = a.finnFilm(100);
        assertEquals(funnetFilm, action);

        funnetFilm = a.finnFilm(101);
        assertEquals(funnetFilm, SCIFI);

    }

    @Test
    void testSoekFilm() {
        Film action = new Film(100, "Clint Eastwood", "3:10 to Yuma", 1992, "Universal", "ACTION");
        Film scifi = new Film(101, "Stanley Kubrick", "2001 a space odyssey", 2001, "Universal", "SCIFI");
        Filmarkiv a = new Filmarkiv();

        a.leggTilFilm(action);
        a.leggTilFilm(scifi);



    }

    @Test
    void testSoekProd() {
        Film action = new Film(100, "Clint Eastwood", "3:10 to Yuma", 1992, "Universal", "ACTION");
        Film scifi = new Film(101, "Stanley Kubrick", "2001 a space odyssey", 2001, "Universal", "SCIFI");
        Filmarkiv a = new Filmarkiv();

        a.leggTilFilm(action);
        a.leggTilFilm(scifi);

        Film[] soektProd = a.soekProdusent("kUb");

        assertEquals(1, soektProd.length);
        assertEquals(soektProd[0], scifi);
    }
}
