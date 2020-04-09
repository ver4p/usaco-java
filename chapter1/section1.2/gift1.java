/*
ID: vera.po1
LANG: JAVA
TASK: gift1
*/

import java.util.*;
import java.io.*;

public class gift1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        int n = in.nextInt();
        LinkedHashMap<String, Integer> friends = new LinkedHashMap<String, Integer>(n);
        String giver, receiver;
        int amount, nr_receiver;

        // prepare a map and fill it with initial account
        for (int j=0; j<n; j++) {
            friends.put(in.next(), 0);
        }

        // share gifts
        for (int j=0; j<n; j++) {
            giver = in.next();
            amount = in.nextInt();
            nr_receiver = in.nextInt();

            if (nr_receiver != 0) {
                friends.put(giver, friends.get(giver) - amount + amount % nr_receiver);
                for (int k=0; k<nr_receiver; k++) {
                    receiver = in.next();
                    friends.put(receiver, friends.get(receiver) + amount/nr_receiver);
                }
            }
        }

        // write output
        for (String f: friends.keySet()) {
            out.println(f + " " + friends.get(f));
        }
        out.close();
    }
}