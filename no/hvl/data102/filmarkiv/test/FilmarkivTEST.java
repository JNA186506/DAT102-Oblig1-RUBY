package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilmarkivTEST {

    private Filmarkiv a = new Filmarkiv();
    private Film action = new Film(100, "Clint Eastwood", "3:10 to Yuma", 1992, "Universal", "ACTION");
    private Film scifi = new Film(101, "Stanley Kubrick", "2001 a space odyssey", 2001, "Universal", "SCIFI");


    @BeforeEach
    void forAlle() {
        a.leggTilFilm(action);
        a.leggTilFilm(scifi);
    }

    @Test
    void testLeggTilFilm() {
        assertTrue(a.leggTilFilm(action), "Filmen burde legges til");
        assertTrue(a.leggTilFilm(scifi),"Filmen burde legges til");
        assertEquals(4, a.antall());
    }

    @Test
    void testSlettFilm() {

        assertTrue(a.leggTilFilm(action), "Filmen burde legges til");
        assertTrue(a.leggTilFilm(scifi),"Filmen burde legges til");
        assertEquals(4, a.antall());

        assertTrue(a.slettFilm(100),"Filmen burde slettes");
        assertEquals(3, a.antall());
    }

    @Test
    void testFinnFilm() {
        a.leggTilFilm(action);
        a.leggTilFilm(scifi);

        Film funnetFilm = a.finnFilm(100);
        assertEquals(funnetFilm, action);

        funnetFilm = a.finnFilm(101);
        assertEquals(funnetFilm, scifi);

    }

    @Test
    void testSoekFilm() {
        Film[] soektFilm = a.soekTittel("yuma");

        assertEquals(1, soektFilm.length);
        assertEquals(soektFilm[0], action);

    }

    @Test
    void testSoekProd() {
        Film[] soektProd = a.soekProdusent("kUb");

        assertEquals(1, soektProd.length);
        assertEquals(soektProd[0], scifi);
    }

    @Test
    void testAntallSjanger() {
       int antallScifi = a.antall(Film.Sjanger.SCIFI);
       int antallAction = a.antall(Film.Sjanger.ACTION);

       assertEquals(1, antallScifi);
       assertEquals(1, antallAction);
    }

    @Test
    void testAntall() {
        assertEquals(2, a.antall());
    }
}
