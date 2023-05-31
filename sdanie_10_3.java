import java.io.*;
public class sdanie_10_3 {
    public static void main(String[] args) throws IOException {
        File F = new File("D://Words.txt");
        System.out.println("Названия сайтов");
        FileInputStream FF = new FileInputStream(F);
        byte b[] = new byte[FF.available()];
        FF.read(b);
        String WR = new String(b);
        String WRS[] = WR.split(" ");
        for(int i=0;i<WRS.length;i++){
            char c = WRS[i].charAt(0);
            String T = String.valueOf(c);
            if(T.equals(".")){
                String S = WRS[i];
                System.out.println(S);
            }
        }
    }
}
