import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CalculateStudentAveragesSimple {

    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        try {
            calculateAndWriteAverages(inputFileName, outputFileName);
            System.out.println("Averages calculated and written to " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void calculateAndWriteAverages(String inputFileName, String outputFileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 2) {
                    continue;
                }

                String name = parts[0].trim();
                double sum = 0;
                int count = 0;
                for (int i = 1; i < parts.length; i++) {
                    try {
                        int mark = Integer.parseInt(parts[i].trim());
                        sum += mark;
                        count++;
                    } catch (NumberFormatException e) {
                       
                    }
                }

                if (count > 0) {
                    double average = sum / count;
                    bw.write(name + ": " + String.format("%.2f", average));
                    bw.newLine();
                }
            }
        }
    }
}