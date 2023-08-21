package database;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        // Write data to a JSON file
        Json json = new Json();
        List<String> readData = json.readFromJsonFile("data.json");
        if (readData.contains(input))
            System.out.println(input);
        else {
            readData.add(input);
            json.writeToJsonFile(readData, "data.json");
        }
    }
}
