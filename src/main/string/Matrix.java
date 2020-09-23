package main.string;

public class Matrix {
    int[][] matrixarr;

    public Matrix(int[][] matrixarr) {
        this.matrixarr = matrixarr;
    }

    /*
     Given an image represented by an NxN matrix, where each pixel in the image is 4
     bytes, write a method to rotate the image by 90 degrees. (an you do this in place?
     */
    public int[][] rotateMatrix() {
        for (int i =0; i< matrixarr.length/2; ++i) {
            int last = matrixarr.length -1 - i;
            for (int j =i; j<last; ++j) {
                int offset = j - i;
                int top = matrixarr[i][j];
                int temp = top;
                matrixarr[i][j] = matrixarr[last-offset][i];
                matrixarr[last-offset][i] = matrixarr[last][last - offset];
                matrixarr[last][last-offset] = matrixarr[j][last];
                matrixarr[j][last] = top;
            }
        }
        return matrixarr;
    }

    /*
    Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
    column are set to O.
     */
    public int[][] zeroMatrix(int m, int n) {
        for (int i = 0; i<m; i++) {
            for (int j =0; j<n; j++) {
                if(matrixarr[i][j] == 0) {
                    for(int x=0; x <m ;x++) {
                        matrixarr[x][j] = 0;
                    }
                    for (int y=0; y<m; y++) {
                        matrixarr[i][y] = 0;
                    }
                }
            }
        }
        return matrixarr;
    }
}
