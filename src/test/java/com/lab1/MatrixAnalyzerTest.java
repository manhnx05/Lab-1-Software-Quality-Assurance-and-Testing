package com.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MatrixAnalyzer targeting Statement Coverage (Issue #1).
 */
public class MatrixAnalyzerTest {

    @Test
    public void testFindMaxInRows_StatementCoverage() {
        // Coverage for null matrix
        assertArrayEquals(new int[0], MatrixAnalyzer.findMaxInRows(null));

        // Coverage for empty matrix
        assertArrayEquals(new int[0], MatrixAnalyzer.findMaxInRows(new int[0][]));

        // Coverage for valid matrix with normal, null, and empty rows
        int[][] matrix = {
            {1, 5, 3},
            null,
            {}
        };
        int[] result = MatrixAnalyzer.findMaxInRows(matrix);
        assertEquals(5, result[0]);
        assertEquals(0, result[1]); // Branch for null row
        assertEquals(0, result[2]); // Branch for empty row
    }

    @Test
    public void testIsSymmetric_StatementCoverage() {
        // Coverage for null matrix
        assertTrue(MatrixAnalyzer.isSymmetric(null));

        // Coverage for non-square matrix
        int[][] nonSquare = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        assertFalse(MatrixAnalyzer.isSymmetric(nonSquare));

        // Coverage for symmetric matrix
        int[][] symmetric = {
            {1, 2},
            {2, 1}
        };
        assertTrue(MatrixAnalyzer.isSymmetric(symmetric));

        // Coverage for non-symmetric square matrix
        int[][] nonSymmetric = {
            {1, 2},
            {3, 4}
        };
        assertFalse(MatrixAnalyzer.isSymmetric(nonSymmetric));
    }

    @Test
    public void testDisplayAndMain_StatementCoverage() {
        // Just calling to ensure statement coverage of these utility/main methods
        MatrixAnalyzer.displayMatrix(new int[][]{{1, 2}, {3, 4}});
        MatrixAnalyzer.main(new String[0]);
    }

    /* --- Path Coverage Extension (Issue #2) --- */

    @Test
    public void testFindMaxInRows_PathCoverage() {
        // Path: Matrix with all negative numbers
        int[][] negativeMatrix = {
            {-10, -5, -20},
            {-1, -2}
        };
        int[] result = MatrixAnalyzer.findMaxInRows(negativeMatrix);
        assertEquals(-5, result[0]);
        assertEquals(-1, result[1]);

        // Path: Varying row lengths (Ragged matrix)
        int[][] ragged = {
            {1},
            {1, 2, 3},
            {4, 2}
        };
        int[] raggedResult = MatrixAnalyzer.findMaxInRows(ragged);
        assertArrayEquals(new int[]{1, 3, 4}, raggedResult);
    }

    @Test
    public void testIsSymmetric_PathCoverage() {
        // Path: 1x1 Matrix (trivially symmetric)
        int[][] single = {{1}};
        assertTrue(MatrixAnalyzer.isSymmetric(single));

        // Path: Large symmetric matrix
        int[][] largeSymmetric = {
            {1, 2, 3, 4},
            {2, 1, 5, 6},
            {3, 5, 1, 7},
            {4, 6, 7, 1}
        };
        assertTrue(MatrixAnalyzer.isSymmetric(largeSymmetric));

        // Path: Not symmetric at the very last comparison
        int[][] almostSymmetric = {
            {1, 2, 3},
            {2, 4, 5},
            {3, 6, 6} // (2,1) is 5, (1,2) is 6? No, wait. 
                      // matrix[2][1] is 6, matrix[1][2] is 5.
        };
        assertFalse(MatrixAnalyzer.isSymmetric(almostSymmetric));
    }
}
