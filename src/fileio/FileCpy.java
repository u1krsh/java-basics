package fileio;
import java.io.*;
public class FileCpy {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream("sample.txt");
        FileOutputStream fos = new FileOutputStream("sample2.txt");
        int i;
        while((i = fis.read())!= -1){
            fos.write(i);
        }
        fis.close();
        fos.close();
        FileInputStream fis1  = new FileInputStream("sample2.txt");
        String j;
//        while ((j= String.valueOf(fis1.read()))!=-1){
//            System.out.println(j);
//        }
//        fis1.close();
    }
}
