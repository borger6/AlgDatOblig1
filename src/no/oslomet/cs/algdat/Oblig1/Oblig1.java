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
        //throw new NotImplementedException();

        int l = 0;
        int r = a.length-1;
        int oddetall = 0;

        for (int i = l; i<=r; i++){
            if(a[i] % 2 != 0){
                oddetall++;
            }
        }

        if (l > r){
            return;
        }
        while (r > l){
            while (a[l] % 2 != 0 && l<r){
                l++;
            }
            while (a[r] % 2 == 0 && l<r){
                r--;
            }
            if (l<r){
                bytte(a, l, r);
                l++;
                r--;
            }
        }

        if (oddetall == 0) {
            kvikksortering(a, 0, a.length-1);
        }
        else if (oddetall == a.length-1){
            kvikksortering(a, 0, a.length-1);
        }
        else {
            kvikksortering(a, 0, oddetall-1);
            kvikksortering(a, oddetall, a.length-1);
        }

        return;

    }
    public static void kvikksortering(int[] a, int l, int r){
        if ( l>=r ){
            return; //hvis tabellen har én verdi eller mindre sorteres den ikke
        }
        int k = sParter0(a, l, r, (l + r )/2); //bruker midtverdi
        kvikksortering(a, l, k-1);//sorterer intervallet til venstre for k inkl k
        kvikksortering(a, k+1, r); //sorterer høyre for k
    }
    public static void kvikksortering1(int[]a){
        kvikksortering(a, 0, a.length-1);
    }

    private static int sParter0(int[] a, int l, int r, int i) {
        bytte(a, i, r);
        int pos = parter0(a, l, r-1, a[r]);
        bytte(a, pos, r);
        return pos;
    }
    private static int parter0(int[] a, int l, int r, int midt){
        while (true){
            while (l <= r && a[l] < midt) l++;
            while (l <= r && a[r] > midt) r--;

            if (l < r){
                bytte(a, l++, r--);
            }
            else return l;
        }
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
        //throw new NotImplementedException();
        int[] indeks = new int[a.length];
        int[] aSortert = new int[a.length];
        for(int i = 0; i < a.length; i++){
            aSortert[i] = a[i];
            indeks[i] = i;
        }
        for (int i = 0; i < aSortert.length; i++){
            int minMaks = min(aSortert, i, aSortert.length);
            bytte(aSortert, i, minMaks);
            bytte(indeks,i, minMaks);
        }
        return indeks;
    }
    public static int min(int[] a, int fra, int til){
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = fra;
        for (int i = fra+1; i < til; i++){
            if (a[i] < a[m]){
                m = i;
            }
        }
        return m;
    }




    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        //throw new NotImplementedException();
        int n = a.length;
        if (a.length < 3) {
            throw new NoSuchElementException("Tabellen er for kort");
        }

        int[] b = new int[3];
        for(int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }
        int[] bSortert = indekssortering(b);

        int min = bSortert[0];
        int min2 = bSortert[1];
        int min3 = bSortert[2];

        int minverdi = a[min];
        int min2verdi = a[min2];
        int min3verdi = a[min3];

        for (int i = 3; i < n; i++){
            if (a[i] < min3verdi){
                if (a[i] < min2verdi){
                    if (a[i] < minverdi){
                        min3 = min2;
                        min3verdi = min2verdi;

                        min2 = min;
                        min2verdi = minverdi;

                        min = i;
                        minverdi = a[min];

                    }
                    else{
                        min3 = min2;
                        min2 = i;

                        min3verdi = min2verdi;
                        min2verdi = a[min2];

                    }
                }
                else{
                    min3 = i;
                    min3verdi = a[min3];

                }
            }
        }

        return new int[] {min, min2, min3};

    }



    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
        //char[] alfabet = "abcdefghijklmnopqrstuvwxyzæøt".toCharArray();

    }

    public static boolean inneholdt(String a, String b) {
        //throw new NotImplementedException();
        final int MAX_CHAR = 256;

        // Create an array of size 256 i.e. ASCII_SIZE
        int count[] = new int[MAX_CHAR];

        int len = a.length();
        // Initialize count array index
        for (int i = 0; i < len; i++)
            count[a.charAt(i)]++;

        int lengdeB = b.length();
        for (int i = 0; i < lengdeB; i++){
            count[b.charAt(i)]--;
        }
        for (int i = 0; i < MAX_CHAR; i++){
            if (count[i] > 0){
                return false;
            }
        }
        return true;
    }

}  // Oblig1
