public class Transpose {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Transpose transpose = new Transpose();
        transpose.transpose(matrix);

    }

    private void transpose(int[][] matrix) {

        int l = matrix.length;
        int b = matrix[0].length;

        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < b; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] ints : matrix) {
            for (int j : ints) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

}
