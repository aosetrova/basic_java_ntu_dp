package org.example;

import java.util.Random;
import java.util.Scanner;

/**
 * Lab work 2
 * Created by Anhelina Osetrova
 */
public class App {
    private static final int MAX_SIZE = 20;
    private static final int MIN_RANDOM = -100;
    private static final int MAX_RANDOM = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ширину матриці (не більше 20): ");
        int width = getValidSize(scanner);
        System.out.print("Введіть висоту матриці (не більше 20): ");
        int height = getValidSize(scanner);

        int[][] matrix = chooseMatrixCreation(scanner, width, height);
        displayMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);

        System.out.println("Мінімальне значення: " + min);
        System.out.println("Максимальне значення: " + max);
        System.out.println("Середнє арифметичне: " + average);
    }

    private static int getValidSize(Scanner scanner) {
        int size = -1;
        while (true) {
            try {
                size = Integer.parseInt(scanner.next());
                if (size >= 1 && size <= MAX_SIZE) {
                    break;
                } else {
                    System.out.print("Некоректне значення. Введіть число від 1 до " + MAX_SIZE + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Некоректне введення. Введіть ціле число: ");
            }
        }
        return size;
    }

    private static int[][] chooseMatrixCreation(Scanner scanner, int width, int height) {
        System.out.print("Виберіть спосіб заповнення матриці (1 - вручну, 2 - випадково): ");
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.next());
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.print("Некоректний вибір. Введіть 1 або 2: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Некоректне введення. Введіть число 1 або 2: ");
            }
        }

        return (choice == 1) ? createMatrixManually(scanner, width, height) : createMatrixRandomly(width, height);
    }

    private static int[][] createMatrixManually(Scanner scanner, int width, int height) {
        int[][] matrix = new int[height][width];
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                while (!scanner.hasNextInt()) {
                    System.out.print("Некоректне введення. Введіть ціле число: ");
                    scanner.next();
                }
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int[][] createMatrixRandomly(int width, int height) {
        int[][] matrix = new int[height][width];
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = MIN_RANDOM + random.nextInt(MAX_RANDOM - MIN_RANDOM + 1);
            }
        }
        return matrix;
    }

    private static void displayMatrix(int[][] matrix) {
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0, count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
                count++;
            }
        }
        return (double) sum / count;
    }
}
