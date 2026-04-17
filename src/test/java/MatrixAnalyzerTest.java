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
}
