package fileio;
import java.io.*;
public class FileRd {
    public static void main(String[] args) throws IOException{
        BufferedReader rdr = new BufferedReader(new FileReader("sample.txt"));
        String i;
        while((i = rdr.readLine())!= null){
            System.out.println(i);
        }
        rdr.close();
    }
}
