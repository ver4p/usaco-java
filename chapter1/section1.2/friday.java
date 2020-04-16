/*
ID: vera.po1
LANG: JAVA
TASK: friday
*/

import java.util.*;
import java.io.*;

public class friday{

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("friday.in"));
        int n = in.nextInt();
        int weekday_cnt = 0; //Jan. 13th, 1900 is a Saturday
        int[] weekdays = new int[7];
        int[] months = {3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3}; //Sat., Sun., Mon, etc.
        int[] months_ly = {3, 1, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3};
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        // computing 13th for leapyears and non leapyears
        for (int j=0; j<n; j++) {
            if (is_leapyear(1900+j)) {
                for (int month : months_ly) {
                    weekdays[weekday_cnt] += 1;
                    weekday_cnt = (weekday_cnt+month) % 7;
                }
            } else {
                for (int month : months) {
                    weekdays[weekday_cnt] += 1;
                    weekday_cnt = (weekday_cnt+month) % 7;
                }
            }
        }

        // printing output
        for (int j=0; j<7; j++) {
            out.print(weekdays[j]);
            if (j != 6) {
                out.print(" ");
            }
        }
        out.println();
        out.close();
    }

    // is_leapyear checks if y is a leap year
    public static boolean is_leapyear(int y) {
        if (y%400==0) {
            return true;
        } else if (y%100==0) {
            return false;
        } else if (y%4==0) {
            return true;
        } else {
            return false;
        }
    }
}
