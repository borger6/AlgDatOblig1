/*
Medlemmer:

Olav Markus Bjørndal, s331354;
Marcus Borger, s321371;
 */


package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.net.SocketOption;
import java.util.ArrayList;
import java.util.NoSuchElementException;


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


    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int i;
        int j = 0;
        int teller = 0;

        for(i = 0; i<a.length;i++){
            if(a[i] >= j){
                if(a[i] != j){
                    teller++;
                }
                j = a[i];
            }
            else{
                throw new  IllegalStateException(" Arrayet er ikke sortert");
            }
        }
        return teller;
    }




    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int i = 1;
        int j = i-1;
        int teller = 1;

        if(a.length == 0){
            return 0;
        }

        for(i=1; i<a.length;i++){
            for (j = i-1; j >= 0; j--){
                if (a[i] == a[j]) {
                    break;
                }
                if(j==0){
                    teller++;
                }
            }
        }
        return teller;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        int n = a.length;

        if(a.length != 0){
            char temp = a[n-1];

            for (int i = n - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = temp;
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        int l = a.length;
        if(l<2){
            return;
        }
        if((k%=l) < 0){
            k+=l;
        }
        int s = gcd(l,k);

        for(int i = 0; i<s; i++){
            char verdi = a[i];
            for(int j = i-k, b = i; j != i; j -= k){
                if(j<0){
                    j+=l;
                }
                a[b] = a[j];
                b = j;
            }
            a[i+k] = verdi;
        }
    }

    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
       char[] a = s.toCharArray(); // gjør om stringene t til et array
       char[] b = t.toCharArray();
       char[] c = new char[a.length + b.length]; // lager et array med plass til alle tegnene i s og t

       int i = 0; // initierer verdiene til variabler for while-løkkene
       int j = 0; // initierer verdiene til variabler for while-løkkene
       int k = 0; // initierer verdiene til variabler for while-løkkene

       while(i<a.length && j<b.length){ // løkke som kjører så lenge begge arrayene har verdier å sette inn i c
           c[k++] = a[i++];             // tar en verdi fra a og setter inn i c
           c[k++] = b[j++];             // tar en verdi fra b og setter inn i c
       }
       while(i<a.length){   // løkke som fortsetter å fylle inn hvis b er tom for elementer
           c[k++] = a[i++];
       }
       while(j<b.length){   // løkke som fortsetter å fylle inn hvis a er tom for elementer
           c[k++] = b[j++];
       }
       String svar = new String(c); // gjør om c til en string
       return svar;
    }


    /// 7b)
   public static String flett(String... s) {
        int h = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        int m = 0;
        int maks_lengde=0;
        int n = s.length;
        int temp= 0;

        for(m=0; m < n; m++) {
            for (h = 0; h < s[k].length(); h++) {
                if (s[k].charAt(h) != ' ') {
                    temp++;

                }

            }
            if(maks_lengde ==0) {
                maks_lengde = temp;
            }
            else if(temp>maks_lengde){
                maks_lengde = temp;
            }
            temp = 0;
            k++;
        }

        String svar = "";
        for(j = 0; j<maks_lengde; j++) {
            for (i = 0; i < s.length; i++) {
                if (s[i].length() > j) {
                    svar += s[i].charAt(j);
                }
            }
        }

       return svar;
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
