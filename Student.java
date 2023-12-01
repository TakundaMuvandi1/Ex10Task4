import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Student {

        public static void main(String[] args) {
            String allStudents = "studentsEN.txt";
            String studentWith5 = "studentsEWith5.txt";


            try (BufferedReader reader = new BufferedReader(new FileReader(allStudents));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(studentWith5))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    // Replace spaces with hyphens in the line
                    line = line.replace(" ", "-");

                    String[] words = line.split("\\s+");
                    String surname = words[0].trim();
                    String name = words[1].trim();
                    String score = words[2].trim();

                    if (score.equals("5")) {
                        writer.write(surname + " " + name + " " + score + "\n");
                    }
                }

                System.out.println("Processing completed. Output written to " + studentWith5);

            } catch (IOException e) {
                System.out.println("IO error: " + e.getMessage());
            }
        }
}