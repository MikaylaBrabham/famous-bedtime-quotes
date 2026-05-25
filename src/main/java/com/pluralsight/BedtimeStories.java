package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BedtimeStories {

    //add main
    public static void main(String[] args) {

        //add my own scanner
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> quotes = new ArrayList<>();

        // READ FILE
        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("quotes.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                quotes.add(line);
            }
            reader.close();
        }

        //add try catch exception
        catch (Exception e) {

            System.out.println("Error reading quotes file.");
            return;
        }

        // MENU LOOP
        boolean running = true;

// add while loop
        while (running) {

            try {

                System.out.println("\nSelect quote 1-10");
                System.out.println("0 - Random Quote");
                System.out.println("X - Exit");

                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("X")) {

                    running = false;
                } else if (input.equals("0")) {

                    Random random = new Random();

                    int randomIndex =
                            random.nextInt(quotes.size());

                    System.out.println(
                            quotes.get(randomIndex));
                } else {

                    int choice =
                            Integer.parseInt(input);

                    System.out.println(
                            quotes.get(choice - 1));
                }

            } catch (Exception e) {

                System.out.println(
                        "Invalid choice.");
            }
        }

        System.out.println("Goodbye!");
    }
}

