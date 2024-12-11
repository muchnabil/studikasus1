import java.util.Scanner;

public class casestudy1 {
    public static void showMenu() {
        System.out.println("=== RECORDING STUDENT ACHIEVEMENTS ===");
        System.out.println("Menu 1: Add Achievement Data");
        System.out.println("Menu 2: Show All Achievements");
        System.out.println("Menu 3: Analyze achievements by Type");
        System.out.println("Menu 4: Exit");
        System.out.println();
        System.out.print("Input the menu numbers (1-4): ");
    }

    public static void addAchievement(Scanner sc, String[][] achievements, int count) {
        if (count >= achievements.length) {
            System.out.println("Achievement list is full!");
            return;
        }
        sc.nextLine();
        System.out.print("Enter a student name: ");
        achievements[count][0] = sc.nextLine();
        System.out.print("Enter a student's ID number: ");
        achievements[count][1] = String.valueOf(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter Achievement Type: ");
        achievements[count][2] = sc.nextLine();
        System.out.print("Enter Level Achievement (Local/National/International): ");
        achievements[count][3] = sc.nextLine();

        int year = 0;
        while (true) {
            System.out.print("Enter Year Achievement (2010-2024): ");
            year = sc.nextInt();
            if (year >= 2010 && year <= 2024) {
                achievements[count][4] = String.valueOf(year);
                break;
            } else {
                System.out.println("Year is not valid. Please try again!.");
            }
        }
        
        System.out.println("Achievement added successfully!");
        System.out.println();
    }

    public static void displayAllAchievements(String[][] achievements, int count) {
        System.out.println("=== ALL STUDENT'S ACHIEVEMENTS ===");
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                System.out.print("Name: " + achievements[i][0]);
                System.out.print(" | Student ID Number: " + achievements[i][1]);
                System.out.print(" | Achievement Type: " + achievements[i][2]);
                System.out.print(" | Level: " + achievements[i][3]);
                System.out.print(" | Year: " + achievements[i][4]);
                System.out.println();
            }
        } else {
            System.out.println("No achievements available.");
        }
        System.out.println();
    }

    public static void analyzeAchievementByType(Scanner sc, String[][] achievements, int count) {
        sc.nextLine();
        System.out.print("Enter Achievement Type to analyze): ");
        String typeToAnalyze = sc.nextLine();
        System.out.println();
        System.out.println("=== ANALYSIS OF ACHIEVEMENTS OF TYPE: " + typeToAnalyze + " ===");

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (achievements[i][2].equalsIgnoreCase(typeToAnalyze)) {
                System.out.print("Name: " + achievements[i][0]);
                System.out.print(" | NIM: " + achievements[i][1]);
                System.out.print(" | Level: " + achievements[i][3]);
                System.out.print(" | Year: " + achievements[i][4]);
                System.out.println();
                found = true;
            }
            System.out.println();
        }

        if (!found) {
            System.out.println("No achievements found for this type.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] achievements = new String[21][5];
        int count = 0;
        while (true) {
            showMenu();
            int menu = sc.nextInt();

            if (menu == 1) {
                addAchievement(sc, achievements, count);
                count++;
            } else if (menu == 2) {
                displayAllAchievements(achievements, count);
            } else if (menu == 3) {
                analyzeAchievementByType(sc, achievements, count);
            } else if (menu == 4) {
                System.out.println("Program finished. Thank you!");
                break;
            } else {
                System.out.println("Invalid menu number! Please try again.");
            }
        }
    }
}

