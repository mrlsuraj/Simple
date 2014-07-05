
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Suraj
 */
public class TPcipher{

    public static void main(String[] args) {
        System.out.println("Enter your String: ");
        Scanner s = new Scanner(System.in);
        String input_text = s.nextLine();
        input_text = input_text.replace(" ", "");
        input_text = input_text.toUpperCase();
        int len = input_text.length();
        double sqt = Math.sqrt(len);
        int limit = (int) Math.ceil(sqt);

        int limsq = (int) Math.pow(limit, 2);
        int f = 0;
        if (limit <= (limsq - len)) {
            f = 1;
        }
        while (limsq > len) {
            input_text += "*";
            len++;
        }
        System.out.println(input_text);
        char[] x = input_text.toCharArray();
        char[][] farray = new char[limit][limit];

        int i = 0;
        System.out.println("Enter your choice");
        char choice = s.next().charAt(0);
        switch (choice) {
            //Lets Encode
            case 'e':
                for (int j = 0; j < limit; j++) {
                    for (int k = 0; k < limit - f; i++, k++) {
                        farray[k][j] = x[i];
                    }
                }
                /*
                 for (int j = 0; j < limit; j++) {
                 for (int k = 0; k < limit; i++, k++) {
                 System.out.print(farray[j][k]);}
                 System.out.println("");
                 }
                 
                 /*  for (int j = 0; j < limit; j++) {
                 // if (farray[j][0] != '*') {
                 for (int k = 0; k < limit; i++, k++)
                 System.out.print(farray[j][k]);
                 // } else {
                 //     for (int k = 0; k < limit; k++) {
                 //        farray[j][k] = '\0';
                 // }
                 //}
                 System.out.println("");
                   
                 }
                 */
                for (int j = 0; j < limit - f; j++) {
                    for (int k = 0; k < limit; k++) {
                        System.out.print(farray[j][k]);
                    }

                }
                break;//End of encode
            //Lets Decode
            case 'd':
                i = 0;
                for (int j = 0; j < limit; j++) {
                    for (int k = 0; k < limit; i++, k++) {
                        farray[j][k] = x[i];
                    }
                }
                /* for (int j = 0; j < limit; j++) {
                 //if (farray[j][0] != '*') {
                 for (int k = 0; k < limit; i++, k++)
                 System.out.print(farray[j][k]);
                 // }
                 System.out.println("");
                 }*/
                for (int j = 0; j < limit; j++) { //How you read it

                    for (int k = 0; k < limit; k++) {
                        if (farray[k][j] != '*') {
                            System.out.print(farray[k][j]);
                        } else {
                            System.out.print("");
                        }
                    }
                }
                break;//End of decode
            default:
                System.out.println("Enter properly :P");
        }//End of Switch statement
        System.out.println();
    }
}
