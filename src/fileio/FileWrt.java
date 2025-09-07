package fileio;
import java.io.*;
public class FileWrt {
    public static void main(String[] args) throws IOException {
        FileWriter wrt = new FileWriter("sample.txt");
        wrt.write("Hello, World");
        wrt.close();
        System.out.println("File Written");
    }
}
