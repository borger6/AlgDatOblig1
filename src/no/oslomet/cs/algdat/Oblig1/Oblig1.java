/*
Medlemmer:

Olav Markus Bjørndal, s331354;
Marcus Borger, s321371;
 */


package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.NoSuchElementException;
import java.util.Random;


public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        //throw new NotImplementedException();
        if (a.length <= 0){
            throw new NoSuchElementException("Det er ikke noe array her");
        }

        for (int i = 0; i < a.length-1; i++){
            if (a[i] > a[i+1]){
                bytte(a,i,i+1);
            }
        }
        return a[a.length-1];
    }
    public static void bytte(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int ombyttinger(int[] a) {
        //throw new NotImplementedException();
        int teller=0;
        for (int i = 0; i < a.length-1; i++){
            if (a[i] > a[i+1]){
                bytte(a,i,i+1);
                teller++;
            }
        }
        return teller;
    }

    public static int[] randPerm(int n){
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = i+1;
        }
        Random r = new Random();
        for (int k = n-1; k > 0; k--){
            int i = r.nextInt(k+1);
            bytte(a,k,i);
        }
        return a;
    }
    public static int antallMaks(int[] a){
        int antall = 0;
        int maksverdi = a[0];

        for (int i = 1; i < a.length; i++){
            if (a[i] > maksverdi){
                antall++;
                maksverdi = a[i];
            }
        }
        return antall;
    }
    /*
    Ved å bruke metoden for harmoniske tall kan man finne gjennomsnittet av antall bytter
    Jeg er ikke sikker på hvordan jeg sammenligner denne maks-metoden med tidligere,
    men jeg tror dette er den beste fordi den nærmer seg det faktiske snittet.
     */


    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new NotImplementedException();

    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new NotImplementedException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new NotImplementedException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

}  // Oblig1
