import java.util.*;

public class InformationManagementExpertSystem {
    static Map<String, String> knowledgeBase = new HashMap<>();

    static {
        // Populate the knowledge base
        knowledgeBase.put("what is your name?", "My name is ExpertBot.");
        knowledgeBase.put("what is information management?",
                "Information management is the process of collecting, storing, managing, and distributing information.");
        knowledgeBase.put("what are the benefits of information management?",
                "Benefits of information management include improved decision-making, increased efficiency, and better compliance.");
        // Add more knowledge base entries as needed
    }

    static String processQuery(String query) {
        // Convert the query to lowercase
        String lowercaseQuery = query.toLowerCase();
        // Check if the lowercase query exists in the knowledge base
        if (knowledgeBase.containsKey(lowercaseQuery)) {
            return knowledgeBase.get(lowercaseQuery);
        } else {
            return "I'm sorry, I don't have information on that topic.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Information Management Expert System.");
        System.out.println("You can ask questions about information management. Type 'exit' to quit.");
        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the Expert System.");
                break;
            }
            String response = processQuery(userInput);
            System.out.println("ExpertBot: " + response);
        }
        scanner.close();
    }
}
