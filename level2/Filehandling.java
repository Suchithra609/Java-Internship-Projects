package level2;
import java.io.*;
public class Filehandling {
	    public static void main(String[] args) {
	        String inputFile = "input.txt";
	        String outputFile = "output.txt";
	        int lineCount = 0;
	        int wordCount = 0;
	        int charCount = 0;
	        try {
	            FileReader fileReader = new FileReader(inputFile);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	                lineCount++;
	                charCount += line.length();
	                String words[] = line.trim().split("\\s+");
	                if (!line.trim().isEmpty()) {
	                    wordCount += words.length;
	                }
	            }
	            bufferedReader.close();
	            FileWriter fileWriter = new FileWriter(outputFile);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	            bufferedWriter.write("File Processing Result");
	            bufferedWriter.newLine();
	            bufferedWriter.write("---------------------");
	            bufferedWriter.newLine();
	            bufferedWriter.write("Total Lines: " + lineCount);
	            bufferedWriter.newLine();
	            bufferedWriter.write("Total Words: " + wordCount);
	            bufferedWriter.newLine();
	            bufferedWriter.write("Total Characters: " + charCount);
	            bufferedWriter.close();
	            System.out.println("File processed successfully.");
	            System.out.println("Output written to " + outputFile);
	        } 
	        catch (FileNotFoundException e) {
	            System.out.println("Error: Input file not found.");
	        } 
	        catch (IOException e) {
	            System.out.println("Error while reading or writing file: " + e.getMessage());
	        }
	    }
	}