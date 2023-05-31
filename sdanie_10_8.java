import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Math.*;

public class sdanie_10_8 {
    public static void main(String[] args) throws IOException {
        File F = new File("D://Oblast.txt");
        FileOutputStream FF = new FileOutputStream(F);
        FF.flush();
        Scanner N5 = new Scanner(System.in);
        out.println("сколько точек будет проверено");
        int N = N5.nextInt();
        double BL[][] = new double[2][N];
        String M = "\n";
        byte m[] = M.getBytes();
        String S = " Фигура 1:\n" +
                "1 кривая - y=sqrt(4-(x+1)^2)+1 на отрезке [-3;-1]\n"+
                "2 кривая - y=1 на отрезке [-3;1]\n"+
                "3 кривая - y=2x+1 на отрезке [-2;-1]\n"+
                "4 кривая - y=(4x/5)-(7/5) на отрезке [-2;3]\n"+
                "5 кривая - y=-sqrt(4-(x+1)^2)+1 на отрезке [-1;1]\n"+
                "6 кривая - y=2x+5 на отрезке [-1;0]\n"+
                "7 кривая - y=(-x/2)+5 на отрезке [0;2]\n"+
                "8 кривая - y=-3x+10 на отрезке [2;3]\n"+
                "Фигура 2:\n"+
                "1 кривая - y=x-3 на отрезке [2;4]\n"+
                "2 кривая - y=sqrt(4-(x-4)^2)-1 на отрезке [4;6]\n"+
                "3 кривая - y=-sqrt(4-(x-4)^2)-1 на отрезке [2;4]\n"+
                "4 кривая - y=-x+1 на отрезке [4;5]\n"+
                "5 кривая - y=(x/2)-(13/2) на отрезке [5;7]\n"+
                "6 кривая - y=-2x+11 на отрезке [6;7]\n";
        byte s[] = S.getBytes();
        FF.write(s);
        FF.write(m);
        for(int j=0;j<N;j++){
            out.println("введите координаты точки");
            double x = N5.nextDouble();
            double y = N5.nextDouble();
            String T = Integer.toString(j)+" точка: ("+Double.toString(x)+";"+Double.toString(y)+")";
            byte b[] = T.getBytes();
            FF.write(b);
            FF.write(m);
            BL[0][j]=x;
            BL[1][j]=y;
        }
        FF.write(m);
        for(int j=0;j<N;j++){
            double x = BL[0][j];
            double y = BL[1][j];
            int i = 0;
            if (x >= -3 & x < -2) {
                double y1 = 1.0, y2 = sqrt(4 - pow(x + 1, 2)) + 1;
                if (y > y1 & y < y2) {
                    i++;
                }else if(y==y1 | y==y2){
                    i=+2;
                }
            } else if (x >= 2 & x < -1) {
                double y1 = 1.0, y2 = sqrt(4 - pow(x + 1, 2)) + 1, y3 = 2 * x + 1, y4 = (4 / 5) * x - (7 / 5);
                if ((y > y1 & y < y2) || (y < y3 & y > y4)) {
                    i++;
                } else if (y==y1 | y==y2 | y==y3 | y==y4) {
                    i=+2;
                }
            } else if (x >= -1 & x < 0) {
                double y1 = 1.0, y2 = -sqrt(4 - pow(x + 1, 2)) + 1, y3 = 2 * x + 5, y4 = (4 / 5) * x - (7 / 5);
                if ((y > y1 & y < y3) || (y < y2 & y > y4)) {
                    i++;
                } else if (y==y1 | y==y2 | y==y3 | y==y4) {
                    i=+2;
                }
            } else if (x >= 0 & x < 1) {
                double y1 = 1.0, y2 = -sqrt(4 - pow(x + 1, 2)) + 1, y3 = -(1 / 2) * x + 5, y4 = (4 / 5) * x - (7 / 5);
                if ((y > y1 & y < y3) || (y < y2 & y > y4)) {
                    i++;
                } else if (y==y1 | y==y2 | y==y3 | y==y4) {
                    i=+2;
                }
            } else if (x >= 1 & x < 2) {
                double y1 = -(1 / 2) * x + 5, y2 = (4 / 5) * x - (7 / 5);
                if (y > y2 & y < y1) {
                    i++;
                } else if (y==y1 | y==y2) {
                    i=+2;
                }
            } else if (x >= 2 & x < 3) {
                double y1 = -3 * x + 10, y2 = (4 / 5) * x - (7 / 5), y3 = x - 3, y4 = -sqrt(4 - pow(x - 4, 2)) - 1;
                if (y > y2 & y < y1) {
                    i++;
                } else if (y==y1 | y==y2) {
                    i+=2;
                }
                if (y < y3 & y > y4) {
                    i += 3;
                } else if (y==y3 | y==y4) {
                    i+=4;
                }
            } else if (x >= 3 & x < 4) {
                double y1 = x - 3, y2 = -sqrt(4 - pow(x - 4, 2)) - 1;
                if (y < y1 & y > y2) {
                    i += 3;
                }else if(y==y1 | y==y2){
                    i+=4;
                }
            } else if (x >= 4 & x < 5) {
                double y1 = sqrt(4 - pow(x - 4, 2)) - 1, y2 = -x + 1;
                if (y > y2 & y < y1) {
                    i += 3;
                } else if (y==y2 | y==y1) {
                    i+=4;
                }
            } else if (x >= 5 & x < 6) {
                double y1 = sqrt(4 - pow(x - 4, 2)) - 1, y2 = (1 / 2) * x - (13 / 2);
                if (y > y2 & y < y1) {
                    i += 3;
                } else if (y==y1 | y==y2) {
                    i+=4;
                }
            } else if (x >= 6 & x < 7) {
                double y1 = -2 * x + 11, y2 = (1 / 2) * x - (13 / 2);
                if (y > y2 & y < y1) {
                    i += 3;
                } else if (y==y1 | y==y2) {
                    i+=4;
                }
            }
            if (i == 0) {
                String H = Integer.toString(j)+" точка не попала ни в одну фигур";
                byte h[] = H.getBytes();
                FF.write(h);
                FF.write(m);
            } else if (i == 1) {
                String H = Integer.toString(j)+" точка попала в 1 фигуру";
                byte h[] = H.getBytes();
                FF.write(h);
                FF.write(m);
            } else if (i == 2) {
                String H = Integer.toString(j)+" точка попала на границу 1 фигуры";
                byte h[] = H.getBytes();
                FF.write(h);
                FF.write(m);
            } else if (i==3) {
                String H = Integer.toString(j)+" точка попала в 2 фигуру";
                byte h[] = H.getBytes();
                FF.write(h);
                FF.write(m);
            } else if (i==4) {
                String H = Integer.toString(j)+" точка попала на границу 2 фигуры";
                byte h[] = H.getBytes();
                FF.write(h);
                FF.write(m);
            }
        }
    }
}