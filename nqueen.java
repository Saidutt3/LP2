public class nqueen {

    static int count = 0;

    public static boolean issafe(char chess[][], int row, int col) {

        // coloum up
        for (int i = row, j = col; i >= 0; i--) {
            if (chess[i][j] == 'Q') {

                return false;
            }

        }
        // left digonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {

                return false;
            }
        }

        // right digonal

        for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++)
            if (chess[i][j] == 'Q') {
                return false;
            }
        return true;
    }

    public static void insertq(char chess[][], int row) {

        if (row == chess.length) {
            printchess(chess);
            return;
        }
        for (int j = 0; j < chess.length; j++) {

            if (issafe(chess, row, j)) {
                chess[row][j] = 'Q';
                insertq(chess, row + 1);
                chess[row][j] = 'X';
            }

        }
    }

    public static void printchess(char chess[][]) {

        System.out.println(
                "--------------------------------------------chess bord ----------------------------------------");

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print(chess[i][j] + "  ");
            }
            System.out.println();

        }

        count++;
    }

    public static void createchess(char chess[][]) {

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                chess[i][j] = 'X';
            }
        }
        insertq(chess, 0);
    }

    public static void main(String args[]) {

        int n = 4;
        char chess[][] = new char[n][n];
        createchess(chess);
        System.out.println(count);
    }
}
