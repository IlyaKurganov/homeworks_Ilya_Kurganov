package homework08;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        String inputFilePath = "src\\homework08\\input.txt";
        String outputFilePath = "src\\homework08\\output.txt";
        Map<String, Person> persons = new HashMap<>();
        Map<String, Product> products = new HashMap<>();

        try {
            PrintStream fileStream = new PrintStream(new File(outputFilePath));
            System.setOut(fileStream);

            readInputFile(inputFilePath, persons, products);
            writeOutputFile(outputFilePath, persons);

            fileStream.close();
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    private static void readInputFile(String filePath, Map<String, Person> persons, Map<String, Product> products) throws IOException {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            String personLine = scanner.nextLine();
            String productLine = scanner.nextLine();

            parsePersons(personLine, persons);
            parseProducts(productLine, products);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("END")) break;
                processPurchaseLine(line, persons, products);
            }
        }
    }

    private static void parsePersons(String line, Map<String, Person> persons) {
        String[] entries = line.split(";");
        for (String entry : entries) {
            String[] parts = entry.trim().split(" = ");
            String name = parts[0].trim();
            int cash = Integer.parseInt(parts[1].trim());
            persons.put(name, new Person(name, cash));
        }
    }

    private static void parseProducts(String line, Map<String, Product> products) {
        String[] entries = line.split(";");
        for (String entry : entries) {
            String[] parts = entry.trim().split(" = ");
            String title = parts[0].trim();
            int cost = Integer.parseInt(parts[1].trim());
            products.put(title, new Product(title, cost));
        }
    }

    private static void processPurchaseLine(String line, Map<String, Person> persons, Map<String, Product> products) {
        String bestPersonMatch = null;
        String bestProductMatch = null;

        for (int i = 1; i < line.length(); i++) {
            String possibleName = line.substring(0, i).trim();
            String possibleProduct = line.substring(i).trim();
            if (persons.containsKey(possibleName) && products.containsKey(possibleProduct)) {
                bestPersonMatch = possibleName;
                bestProductMatch = possibleProduct;
                break;
            }
        }

        if (bestPersonMatch != null && bestProductMatch != null) {
            persons.get(bestPersonMatch).buyProduct(products.get(bestProductMatch));
        } else {
            System.out.println("Ошибка: продукт или персона не найдены. Проверьте данные. Введенная строка: " + line);
        }
    }

    private static void writeOutputFile(String filePath, Map<String, Person> persons) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File(filePath), true))) {
            writer.println();
            for (Map.Entry<String, Person> entry : persons.entrySet()) {
                writer.print(entry.getKey() + " - ");
                List<Product> products = entry.getValue().getBagWithProducts();
                if (products.isEmpty()) {
                    writer.println("Ничего не куплено");
                } else {
                    String productList = products.stream()
                            .map(Product::getTitle)
                            .collect(Collectors.joining(", "));
                    writer.println(productList);
                }
            }
        }
    }
}



