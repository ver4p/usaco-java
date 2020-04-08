/*
ID: vera.po1
LANG: JAVA
TASK: ride
*/

import java.util.Scanner;
import java.io.*;

public class ride {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String comet = in.next();
        String group = in.next();
        String mission;
        int nr_comet = 1;
        int nr_group = 1;
        int c;

        // computing numbers for comet and group
        for (int j=0; j<comet.length(); j++) {
            c = comet.charAt(j);
            nr_comet *= (c-64);
        }

        for (int j=0; j<group.length(); j++) {
            c = group.charAt(j);
            nr_group *= (c-64);
        }

        // checking if numbers mod 47 are equal
        if (nr_comet % 47 == nr_group % 47) {
            mission = "GO";
        } else {
            mission = "STAY";
        }

        out.println(mission);
        out.close();
    }
}