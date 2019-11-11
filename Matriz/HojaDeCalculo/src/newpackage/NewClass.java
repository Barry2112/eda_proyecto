/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Renzo6998
 */
public class NewClass {
    
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        for (int i = 0; i < matrix[0].length; i++) {
//            for (int j = 0; j < matrix[1].length; j++) {
//                System.err.print(matrix[i][j]+"  ");
//            }
//            System.err.print("\n");
//        }
//        for (int i = 0; i < matrix[0].length; i++) {
//            for (int j = 0; j < matrix[1].length; j++) {
//                System.err.print(matrix[j][i]+"  ");
//            }
//            System.err.print("\n");
//        }
        inversa(matrix);
    }
    
    public static void inversa(int[][] m) {
        inversaAuxI(m, 0, 0);
    }
    
    public static void inversaAuxI(int[][] m, int i, int j) {
        if(i>=m[0].length){
            return;
        }
        inversaAuxJ(m, i, j);
        inversaAuxI(m, ++i, j);
    }
    
    public static void inversaAuxJ(int[][] m, int i, int j){
        if(j>=m[1].length){
            System.out.print("\n");
            return;
        }
        System.out.print(m[j][i]+"  ");
        inversaAuxJ(m, i, ++j);
    }
}
