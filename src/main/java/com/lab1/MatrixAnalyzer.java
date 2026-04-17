package com.lab1;

import java.util.Arrays;

/**
 * MatrixAnalyzer: A more complex program for Lab 1.
 * Features:
 * 1. Nested loops (for matrix traversal).
 * 2. Multiple conditional branches (for analysis logic).
 */
public class MatrixAnalyzer {

    /**
     * Finds the maximum value in each row of the matrix.
     * Demonstrates nested loops and conditional branching.
     */
    public static int[] findMaxInRows(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int[] maxValues = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) { // Outer loop
            int currentMax = Integer.MIN_VALUE;
            
            // Check if row is null or empty
            if (matrix[i] == null || matrix[i].length == 0) {
                maxValues[i] = 0; 
                continue;
            }

            for (int j = 0; j < matrix[i].length; j++) { // Inner loop
                if (matrix[i][j] > currentMax) { // Conditional branch
                    currentMax = matrix[i][j];
                }
            }
            maxValues[i] = currentMax;
        }
        return maxValues;
    }

    /**
     * Checks if a square matrix is symmetric.
     */
    public static boolean isSymmetric(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return true;
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check if it's square
        if (rows != cols) {
            return false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != matrix[j][i]) { // Branching
                    return false;
                }
            }
        }
        return true;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Matrix Analyzer Program ===");

        int[][] symmetricMatrix = {
            {1, 2, 3},
            {2, 4, 5},
            {3, 5, 6}
        };

        int[][] randomMatrix = {
            {10, 5, 8, 20},
            {1, 45, 12, 3},
            {9, 6, 33, 7}
        };

        System.out.println("\nAnalyzing Symmetric Matrix:");
        displayMatrix(symmetricMatrix);
        System.out.println("Is symmetric? " + isSymmetric(symmetricMatrix));
        
        System.out.println("\nAnalyzing Random Rectangular Matrix:");
        displayMatrix(randomMatrix);
        System.out.println("Is symmetric? " + isSymmetric(randomMatrix));
        
        int[] maxInRows = findMaxInRows(randomMatrix);
        System.out.println("Max in each row: " + Arrays.toString(maxInRows));
        
        System.out.println("\n-------------------------------");
    }
}
