import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class sdanie_10_5 {
    public static void main(String[] args) throws IOException {
        File F = new File("D://massive.txt");
        File G = new File("D://massive2.txt");
        FileInputStream FF = new FileInputStream(F);
        FileReader FR = new FileReader(F);
        FileOutputStream GF = new FileOutputStream(G);
        GF.flush();
        int c, i = 0;
        char ch[] = new char[FF.available()];
        byte b[] = new byte[FF.available()];
        try(FR){
            while((c=FR.read(ch))>=0){
                ch = Arrays.copyOf(ch, c);
            }
        }
        String S = new String(ch);
        int k=0, iS=0, iE=0;
        for(int u=0;u<S.length();u++){
            char ec[] = {S.charAt(u)};
            String Sc = new String(ec);
            List<String> Pr = new ArrayList<>();
            String Pr1 = ",";
            String Pr2 = ";";
            String Pr3 = ":";
            String Pr4 = "/";
            String Pr5 = ">";
            String Pr6 = "<";
            String Pr7 = "'";
            String Pr8 = "`";
            String Pr9 = "@";
            String Pr10 = "#";
            String Pr11 = "$";
            String Pr12 = "*";
            String Pr13 = "&";
            Pr.add(Pr1); Pr.add(Pr2);Pr.add(Pr3);Pr.add(Pr4);Pr.add(Pr5);Pr.add(Pr6);Pr.add(Pr7);
            Pr.add(Pr8);Pr.add(Pr9); Pr.add(Pr10); Pr.add(Pr11); Pr.add(Pr12); Pr.add(Pr13);
            for(int y=0;y<Pr.size();y++){
                if(Sc.equals(Pr.get(y))){
                    k++;
                    Pr.remove(y);
                }
            }
            if((Sc.equals(".")||Sc.equals("?")||Sc.equals("!"))){
                if(k>=4){
                    iE=u;
                    String COPY = "";
                    COPY = S.substring(iS,iE+1);
                    byte r[] = COPY.getBytes();
                    GF.write(r);
                }
                iS=u+1;
                k=0;
            }
        }
    }
}
