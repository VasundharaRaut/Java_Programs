import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Student Grade Calculator ===");

        System.out.print("Enter the number of subjects: ");
        int subjects = sc.nextInt();

        int[] marks = new int[subjects];
        int totalMarks = 0;

        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks entered. Please enter between 0 and 100.");
                i--; // repeat this subject
                continue;
            }
            totalMarks += marks[i];
        }

        double percentage = (double) totalMarks / subjects;
        char grade;

        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\n=== Result ===");
        System.out.println("Total Marks: " + totalMarks + " / " + (subjects * 100));
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
