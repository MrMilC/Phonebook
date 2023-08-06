package org.example;

import java.io.*;

public class Phonebook {
    public static void main(String[] args) throws IOException {

        String inputFile = "datafile4homeassigment1.txt";
        File file = new File(inputFile);

        String outputFile = "phonebook.txt";

        if (file.exists())
        {
            try
            {
                BufferedReader in = new BufferedReader(new FileReader(inputFile));
                PrintWriter out = new PrintWriter(outputFile);

                String line;
                while ((line = in.readLine()) != null) {
                    String[] parts = line.split(",");
                    out.println(parts[0] + "," + parts[parts.length - 1]);

                    // For testing purposes:
                    // System.out.println(parts[0] + "," + parts[parts.length - 1]);
                }
                in.close();
                out.close();

                System.out.println(
                        "File \"" + inputFile + "\" has been found and read.\n" +
                        "File \"" + outputFile + "\" has been created.");
            }
            catch (IOException e)
            {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }

        else
        {
            throw new FileNotFoundException(
                            "\nPredefined readable file named \"" + inputFile + "\" could not be found.\n" +
                            "Please make sure that\n" +
                            "A) the file is placed in the project directory,\n" +
                            "B) the file is named correctly,\n" +
                            "C) or that the file extension is txt.");
        }
    }
}