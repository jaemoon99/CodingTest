import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String seminar = scanner.nextLine();

            switch (seminar) {
                case "Algorithm":
                    System.out.println("204");
                    break;
                case "DataAnalysis":
                    System.out.println("207");
                    break;
                case "ArtificialIntelligence":
                    System.out.println("302");
                    break;
                case "CyberSecurity":
                    System.out.println("B101");
                    break;
                case "Network":
                    System.out.println("303");
                    break;
                case "Startup":
                    System.out.println("501");
                    break;
                case "TestStrategy":
                    System.out.println("105");
                    break;
            }
        }

        scanner.close();
    }
}