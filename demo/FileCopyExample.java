import java.io.*;

public class FileCopyExample {
    public static void main(String[] args) throws IOException { 
	
        File input=new File("inputfile.txt");
        File output=new File("outputfile.txt");
        FileReader fr=null;
	FileWriter fw=null;
try {
            fr= new FileReader(input);
	      fw=new FileWriter(output);		
            int character;

            while ((character = fr.read()) != -1) {
                fw.write(character);
            }
System.out.println("Copied successfully");
	} 
catch (Exception e) {
            
        }
	finally{
	fr.close();
	fw.close();
		} 
	
	}
}