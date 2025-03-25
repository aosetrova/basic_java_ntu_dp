package org.example;

/**
 * Lab work 5
 * Created by Anhelina Osetrova
 */
import org.example.dao.StudentDao;
import org.example.model.Student;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDao studentDAO = new StudentDao();
        int month = -1;

        while (true) {
            System.out.print("Введіть номер місяця (1-12): ");
            try {
                month = scanner.nextInt();
                if (month < 1 || month > 12) {
                    System.out.println("Помилка: введіть число від 1 до 12.");
                } else {
                    break; // Коректне значення -> виходимо з циклу
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка: введіть число від 1 до 12.");
                scanner.next(); // Очищаємо буфер, щоб уникнути зациклення
            }
        }

        List<Student> students = studentDAO.getStudentsByMonth(month);

        if (students.isEmpty()) {
            System.out.println("Студентів, народжених у цьому місяці, не знайдено.");
        } else {
            students.forEach(System.out::println);
        }

        scanner.close();
    }
}
