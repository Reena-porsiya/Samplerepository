
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class CopyFile {
    public static void main(String[] args) throws IOException {
        FileInputStream r = new FileInputStream("D:\\work\\javasamples\\demo\\Malar.txt");
        FileOutputStream w = new FileOutputStream("D:\\work\\javasamples\\demo\\Reena.txt");

        int i;
        while ((i = r.read()) != -1) {
            w.write((char) i);
        }
        System.out.println("Data Copied Successfully..!");
    }
}