import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;
public class sdanie_10_4 {
    public static void main(String[] args) throws IOException {
        File F = new File("D://SearchedWords.txt");
        FileInputStream FF = new FileInputStream(F);
        File G = new File("D://FoundWords.txt");
        FileOutputStream FG = new FileOutputStream(G);
        FG.flush();
        byte b[] = new byte[FF.available()];
        FF.read(b);
        String WR = new String(b);
        String WRS[] = WR.split(" ");
        Pattern x = Pattern.compile("^[a-zA-Z0-9]+@(.+)$");
        ArrayList<String> Rz = new ArrayList<>();
        Rz.add("_"); Rz.add(","); Rz.add("."); Rz.add(":"); Rz.add(";");Rz.add("\t"); Rz.add("\n");Rz.add("!");Rz.add("?");
        int s=-1, e=-1;
        String help="";
        String str ="\n";
        byte st[] = str.getBytes();
        for(int i=0;i<WRS.length;i++){
            Matcher y=x.matcher(WRS[i]);
            if(y.find()){
                byte d[] = WRS[i].getBytes();
                FG.write(d);
                FG.write(st);
            }
        }
        for(int i=0;i<WR.length();i++){
            char c = WR.charAt(i);
            String T = String.valueOf(c);
            for(int j=0;j< Rz.size();j++){
                if(T.equals(Rz.get(j))){
                    if(s==-1){
                        s=i;
                    }else{
                        e=i;
                        help= WR.substring(s+1,e);
                        byte B[] = help.getBytes();
                        FG.write(B);
                        FG.write(st);
                        s=-1;
                    }
                }
            }
        }
    }
}