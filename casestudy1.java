import java.util.Scanner;

public class casestudy1 {
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
                System.out.println("Exiting~");
                break;
            } else {
                System.out.println("Invalid menu number! Please try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("=== PENCATATAN PRESTASI MAHASISWA ===");
        System.out.println("Menu 1: Tambah data prestasi");
        System.out.println("Menu 2: Tampilkan semua prestasi");
        System.out.println("Menu 3: Analisis prestasi berdasarkan jenis");
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
        System.out.print("Enter Year Achievement (2010-2024): ");
        achievements[count][4] = String.valueOf(sc.nextInt());

        System.out.println("Achievement added successfully!");
        System.out.println();
    }

    public static void displayAllAchievements(String[][] achievements, int count) {
        System.out.println("=== ALL STUDENT'S ACHIEVEMENTS ===");
        if (count == 0) {
            System.out.println("No achievements available.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.print("Name: " + achievements[i][0]);
                System.out.print(" | Student ID Number: " + achievements[i][1]);
                System.out.print(" | Achievement Type: " + achievements[i][2]);
                System.out.print(" | Level: " + achievements[i][3]);
                System.out.print(" | Year: " + achievements[i][4]);
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void analyzeAchievementByType(Scanner sc, String[][] achievements, int count) {
        sc.nextLine();
        System.out.print("Enter Achievement Type to analyze (e.g., 'Academic', 'Sports', etc.): ");
        String typeToAnalyze = sc.nextLine();
        System.out.println("=== ANALYSIS OF ACHIEVEMENTS OF TYPE: " + typeToAnalyze + " ===");
        System.out.println();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (achievements[i][2].equalsIgnoreCase(typeToAnalyze)) {
                System.out.println("Name: " + achievements[i][0]);
                System.out.println("NIM: " + achievements[i][1]);
                System.out.println("Achievement Type: " + achievements[i][2]);
                System.out.println("Level: " + achievements[i][3]);
                System.out.println("Year: " + achievements[i][4]);
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No achievements found for this type.");
        }
    }
}

