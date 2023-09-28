import java.io.*;

public class CalculateAverage {
    public static void main(String[] args) {
        String inputFilePath = "D:\\work\\javasamples\\demo\\input.txt";
        String outputFilePath = "D:\\work\\javasamples\\demo\\output.txt";

        try {
            File inputFile = new File(inputFilePath);
            File outputFile = new File(outputFilePath);

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            int totalMarks = 0;
            int studentCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                int marks = Integer.parseInt(line);
                totalMarks += marks;
                studentCount++;
            }

            double average = (double) totalMarks / studentCount;

            writer.write("Total number of students: " + studentCount);
            writer.newLine();
            writer.write("Total marks: " + totalMarks);
            writer.newLine();
            writer.write("Average marks: " + average);

            writer.close();
            reader.close();

            System.out.println("Output file created successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error creating output file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid marks format: " + e.getMessage());
        }
    }
}