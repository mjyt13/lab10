import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class sdanie_10_2 {
    static Scanner I0 = new Scanner(System.in);

    public static void main(String[] args) throws IOException, FileNotFoundException {
        File file = new File("D://rera.txt");
        FileOutputStream fil = new FileOutputStream(file);
        fil.flush();
        String P;
        String O = "\n";
        byte c[] = O.getBytes();
        for (double i = 1; i < 10; i++) {
            for (double j = 1; j < 10; j++) {
                double z = floor((i / j) * 10000);
                String S = Integer.toString((int) floor(z / 10000));
                String B;
                if ((int) (z % 10000) == 0) {
                    B = "0000";
                } else {
                    B = Integer.toString((int) (z % 10000));
                }
                P = S + "," + B + " ";
                byte b[] = P.getBytes();
                fil.write(b);
            }
            fil.write(c);
        }
        fil.close();
    }
}
