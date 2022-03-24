package practiceJava;

import java.util.Scanner;

public class Day01 {


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        System.out.println("bir kelime giriniz");

        String word = scan.next();

        if (word.equalsIgnoreCase(reverse(word))) {

            System.out.println("kelime polindromedur");

        } else {
            System.out.println("kelime polindrome degildir");
        }


    }


    public static  String reverse(String str) {

        StringBuffer ters = new StringBuffer(str);

        String tersKelime = ters.reverse().toString();

        return tersKelime;

    }


    public void yazdir() {
        System.out.println("selam");
    }



}
