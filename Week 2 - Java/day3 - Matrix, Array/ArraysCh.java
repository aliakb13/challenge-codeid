public class ArraysCh {
    public static void main(String[] args) {
//        int[] addOneArr = {8,9};
//        displayArr(addOnePlus(addOneArr));

//        String[] isPalindromeArr = {"true","false","false"};
//        System.out.println(isPalindromeString(isPalindromeArr));
        displayArr(orderEvenBeforeOdd(new int[]{1,2,3,4,5,6,7,8,9, 11, 12}));

//       ----------MATRIX---------------
//        displayMatrix(matrixDiagOne(5,5));
//        displayMatrix(matrixDiagTwo(5,5));
//        displayMatrix(matrixThree(7));
//        displayMatrix(matrixFour(8));


//        displayArr(sortArr(new int[]{10, 1,8, 5, 12, 9, 2, 3}));

    }

    public static void displayArr(int[] arr) {
        for (int j : arr) {
            System.out.printf("%4d", j);
        }
    }

    public static void displayMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static int[] orderEvenBeforeOdd(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            // Move left until an odd number is found
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            // Move right until an even number is found
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }

            // Swap the odd number on the left with the even number on the right
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        // Now sort the even numbers (from 0 to left-1) using Bubble Sort
        for (int i = 0; i < left - 1; i++) {
            for (int j = 0; j < left - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap if the element is greater than the next one
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = left; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap if the element is greater than the next one
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;


    }

    public static int[] addOnePlus(int[] arr) {
        // looping dari index terakhir
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] < 9) { // jika true, hanya dijalankan sekali
                arr[i]++; // menambahkan element - i dengan 1 jika true
                return arr; // keluar dari function jika ditemukan minimal 1 element
            }
            arr[i] = 0; // jika if di atas false, maka ini akan dijalankan terus sampai element habis
        }

        // baris ini hanya akan dijalankan jika semua element bernilai 9 -> {9,9,9}
        int[] result = new int[arr.length + 1]; // membuat sebuah array baru berdasarkan array lama + 1
        result[0] = 1; // memastikan index pertama bernilai 1
        return result;
    }

    public static boolean isPalindromeString(String[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]){
                return false;
            }
        }
        return true;
    }

    public static int[][] matrixDiagOne(int r, int c) {
        int[][] res = new int[r][c];
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[row].length; col++) {
                if (row == col) {   // Mengisi increment col dalam diagonal. Diagonal adalah jika row == column. Liat visualisasi kotak biar lebih jelas
                    res[row][col] = col + 1;
                } else if (col > row) {   // mengisi angka 10 ketika column > row. Liat kotak lagi biar jelas
                    res[row][col] = 10;
                } else {    //sebenernya nilai 20 diisi jika row > col
                    res[row][col] = 20;
                }
            }
        }
        return res;
    }

    public static int[][] matrixDiagTwo(int r, int c) {
        int[][] res = new int[r][c];

        // memakai looping biasa, bukan looping terbalik
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[row].length; col++) {
                if (row == col) {   // formula nya sama, tapi mengisi dari nilai
                    res[row][col] = r - col;
                } else if (col > row) {
                    res[row][col] = 20;
                } else {
                    res[row][col] = 10;
                }
            }
        }

        return res;
    }

    public static int[][] matrixThree(int n) {
        int[][] res = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(row == 0 || row == n - 1) {
                    res[row][col] = col + row;
                } else if (col == 0 || col == n - 1) {  // jika res[0][0], maka akan rewrite tapi untungnya sama
                    res[row][col] = col + row;
                }
            }
        }
        return res;
    }

    public static int[][] matrixFour(int n) {

//        int[][] res = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = 0; j < n; j++) {
//                if (j == n - 1) {
//                    res[i][j] = sum;
//                } else {
//                    res[i][j] = i + j;
//                    sum+=res[i][j];
//                }
//            }
//        }
//        return res;

        int[][] matrix = new int[n][n];
        //int sum = 0;
        for (int row = 0; row < matrix.length-1; row++) {

            for (int col = 0; col < matrix[row].length-1; col++) {
                matrix[row][col] = row + col;
                matrix[row][n-1] += matrix[row][col];;
                matrix[n-1][col] += matrix[row][col];;
            }
        }
        for (int i = 0; i < n-1; i++) {
            matrix[n-1][n-1] += matrix[n-1][i];;

        }
        return matrix;

    }
}

