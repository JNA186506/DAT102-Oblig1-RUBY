package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

import static org.junit.jupiter.api.Assertions.*;

import no.hvl.data102.filmarkiv.impl.Tekstgrensesnitt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TekstgrensesnittTEST {

    private Film a = new Film(100, "Clint Eastwood", "3:10 to Yuma", 1992, "Universal", "ACTION");
    private Film b = new Film(101, "Stanley Kubrick", "2001 a space odyssey", 2001, "Universal", "SCIFI");
    private Tekstgrensesnitt t = new Tekstgrensesnitt();
    private Filmarkiv fA = new Filmarkiv(2);


    @BeforeEach
    void leggTilFilm() {
        assertTrue(fA.leggTilFilm(a));
        assertTrue(fA.leggTilFilm(b));
    }
    @Test
    void skrivUtFilmTest() {
        assertEquals(2, fA.antall());

        t.skrivUtFilm(a);
    }

    @Test
    void skrivUtFilmDelstrengITittelTest() {
        t.skrivUtFilmDelstrengITittel(fA, "sPa");
    }

    @Test
    void skrivUtFilmProdusent() {
        t.skrivUtFilmProdusent(fA, "kuB");
    }





}
