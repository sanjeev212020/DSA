import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the Matrix Operations that you want :");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Transpose");
        System.out.println("5. Inversion");

        System.out.print("Enter your choice of operation  (1|2|3|4|5): ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > 5) {
            System.out.println(" Your choice is Invalid .");
            return;
        }

        System.out.print("Enter the number of rows: ");
        int rowsA = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int colsA = scanner.nextInt();

        double[][] matrixA = inputMatrix(rowsA, colsA);

        if (choice != 4) {
            System.out.print("Enter the number of rows for the second matrix: ");
            int rowsB = scanner.nextInt();
            System.out.print("Enter the number of columns for the second matrix: ");
            int colsB = scanner.nextInt();

            double[][] matrixB = inputMatrix(rowsB, colsB);

            if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
                System.out.println("Matrix dimensions do not match for the chosen operation.");
                return;
            }

            double[][] resultMatrix;

            switch (choice) {
                case 1:
                    resultMatrix = matrixAddition(matrixA, matrixB);
                    break;
                case 2:
                    resultMatrix = matrixSubtraction(matrixA, matrixB);
                    break;
                case 3:
                    resultMatrix = matrixMultiplication(matrixA, matrixB);
                    break;
                default:
                    resultMatrix = null;
                    break;
            }

            if (resultMatrix != null) {
                System.out.println("Result:");
                printMatrix(resultMatrix);
            }
        } else {
            double[][] resultMatrix;

            switch (choice) {
                case 4:
                    resultMatrix = matrixTranspose(matrixA);
                    break;
                case 5:
                    resultMatrix = matrixInverse(matrixA);
                    break;
                default:
                    resultMatrix = null;
                    break;
            }

            if (resultMatrix != null) {
                System.out.println("Result:");
                printMatrix(resultMatrix);
            }
        }
    }

    public static double[][] inputMatrix(int rows, int cols) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the matrix:");
        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        return matrix;
    }

    public static double[][] matrixAddition(double[][] matrixA, double[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return result;
    }

    public static double[][] matrixSubtraction(double[][] matrixA, double[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }

        return result;
    }

    public static double[][] matrixMultiplication(double[][] matrixA, double[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;
        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    public static double[][] matrixTranspose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static double[][] matrixInverse(double[][] matrix) {

        return null;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
