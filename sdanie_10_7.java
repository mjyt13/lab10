import java.io.*;
import static java.lang.Math.*;

public class sdanie_10_7  {
    public static void main(String[] args) throws  IOException {
        File tr = new File("D://tete.txt");
        FileOutputStream rr = new FileOutputStream(tr);
        rr.flush();
        String S ="x изменяется от -3 до 3; if(x<0){\n\tf=sin(x)+5;\n}\nif(x>=0){\n\tf=pow(E,x)+x;\n}\nx\tf(x)\n";
        byte s[] = S.getBytes();
        rr.write(s);
        double x = -3;
        double f;
        String R, P;
        String ff = "\n";
        String hh = "\t";
        byte wq[] = ff.getBytes();
        byte wk[] = hh.getBytes();
        while (x <= 3) {
            P=Double.toString(x);
            if (x >= 0) {
                f = pow(E, x) + x;
                R = Double.toString(f);
            } else {
                f = sin(x) + 5;
                R = Double.toString(f);
            }
            byte g[] = R.getBytes();
            byte p[] = P.getBytes();
            rr.write(p);
            rr.write(wk);
            rr.write(g);
            rr.write(wq);
            x += 0.5;
        }
        rr.close();
    }
}