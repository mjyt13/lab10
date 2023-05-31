import java.io.*;
import static java.lang.Math.*;
import java.util.*;
public class sdanie_10_10 {
    static Scanner Y = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String S="ln(1+x)";
        File FF = new File("D://McLoren.txt");
        FileOutputStream ff = new FileOutputStream(FF);
        ff.flush();
        double i = 0.01;
        double j = 0, t=0, T=0;
        double s = 0;
        double n=1, m=-1;
        int R=0, N=1;
        System.out.println("введите x от -1 до 1");
        double x = Y.nextDouble();
        double y = x;
        while(x>=1||x<=-1){
            System.out.println("x должен быть от -1 до 1, введите ещё раз");
            x=Y.nextDouble();
            y = x;
            System.out.println(x);
        }
        j = log(1+y);
        String J = Double.toString(j);
        String WR="Функция f(x) = "+S+" для x = "+x+" равняется "+J+" \n" +
                " Результаты определения значений функции f(x) = "+S+" с помощью ряда Маклорена \n";
        byte a[] = WR.getBytes();
        ff.write(a);
        while(i>=0.0001){
            while (abs(j-s)>=i){
                if(N%2==0){
                    x=(m*pow(y,n))/n;
                }else{
                    x=(pow(y,n))/n;
                }
                s+=x;
                n++;
                R++;
                N++;
                t=abs(j-s);
            }
            T=floor(t*10000)/100;
            String s0 = Double.toString(s);
            String Tt = Double.toString(T);
            String r = Integer.toString(R);
            String I = Double.toString(i);
            s=0;
            R=0;
            x=y;
            n=1;
            i=i*(0.1);
            N=1;
            String H = "Погрешность итерационной процедуры "+I+" \n" +
                    "Значение функции по Маклорену \tПогрешность, % \tЧисло итераций\n"+
                    "\t"+s0+" \t \t \t"+Tt+"\t \t \t"+r+" \n";
            byte b[] = H.getBytes();
            ff.write(b);
        }
        ff.close();
    }
}