/*
ID: vera.po1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

class milk2 {
    public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(new File("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        int n = in.nextInt();
        int[] starttime = new int[n];
        int[] endtime = new int[n];
        int max_milking = 0;
        int max_pause = 0;
        int milking = 0;
        int pause = 0;

        for (int i=0; i<n; i++) {
            starttime[i] = in.nextInt();
            endtime[i] = in.nextInt();
        }

        // time represents each second in milking process
        int z = max(endtime)+1;
        int[] time = new int[z];
        for (int i=0; i<z; i++) {
            time[i]=0;
        }

        // set value for seconds to 1 of cow is being milked
        for (int j=0; j<n; j++) {
            for (int k=starttime[j]; k<endtime[j]; k++) {
                time[k] = 1;
            }
        }

        // determine longest time interval of milking and pause
        int b = min(starttime);
        if (time[b] == 0) {
            pause = 1;
        } else {
            milking = 1;
        }
        for (int j=b+1; j<z-1; j++) {
            if (time[j-1] == time[j]) {
                if (time[j] == 0) {
                    pause++;
                } else {
                    milking++;
                }
            } else {
                if (time[j-1] == 0) {
                    max_pause = pairMax(max_pause, pause);
                    milking = 1;
                } else {
                    max_milking = pairMax(max_milking, milking);
                    pause = 1;
                }
            }
        }

        max_pause = pairMax(max_pause, pause);
        max_milking = pairMax(max_milking, milking);

        out.println(max_milking + " " + max_pause);
        out.close();
  }

  // finds max value in array
  static int max(int[] a) {
      int x = Integer.MIN_VALUE;
      
      for (int y : a) {
          if (y > x) {
              x = y;
          }
      }

      return x;

  }

  // finds min value in array
  static int min(int[] a) {
      int x = Integer.MAX_VALUE;

      for (int y : a) {
          if (y < x) {
              x = y;
          }
      }

      return x;
  }

  // finds max of two ints
  static int pairMax(int x, int y) {
      if (x > y) {
          return x;
      } else {
          return y;
      }
  }
}
