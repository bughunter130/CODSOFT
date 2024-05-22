import java.util.Scanner;

public class PercentageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int totalSubjects = sc.nextInt();

        System.out.println("Enter the maximum marks for each subject:");
        int maxMarks = sc.nextInt();

        int totalMarks = 0;
        for (int i = 1; i <= totalSubjects; i++) {
            System.out.println("Enter marks obtained in subject " + i + ":");
            totalMarks += sc.nextInt();
        }

        double averagePercentage = (double) totalMarks / (totalSubjects * maxMarks) * 100;

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");

        // Customize grade assignment based on your criteria
        if (averagePercentage >= 90) {
            System.out.println("Grade: A+");
        } else if (averagePercentage >= 80) {
            System.out.println("Grade: A");
        } else if (averagePercentage >= 70) {
            System.out.println("Grade: B");
        } else if (averagePercentage >= 60) {
            System.out.println("Grade: C");
        } else if (averagePercentage >= 60) {
            System.out.println("Grade:D");
        }
        else {
            System.out.println("Grade: F");
        }
    }
}
