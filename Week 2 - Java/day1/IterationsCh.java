import java.util.Scanner;

public class IterationsCh {
    public static void main(String[] args) {
//        questionOne(5);
//        questionTwo(5);
//        questionThree(5);
//        questionFour(5);
//        questionFive(5);
//        questionSix(5);
        questionSeven();
//        questionNine(5);
//        questionTen(5);

    }

    public static void questionOne(int n) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num++;
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }

    public static void questionTwo(int n) {
//        for (int i = 1; i <= n; i++) {
//            StringBuilder row = new StringBuilder();
//            for (int j = 0; j < i; j++) {
//                row.append(i + j).append(" ");
//            }
//            System.out.println(row);
//        }

        for (int i = 1; i <= n; i++) {
            int num = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    public static void questionThree(int n) {
//        for (int i = 1; i <= n; i++) {
//            StringBuilder row = new StringBuilder();
//            for (int j = i; j <= n; j++) {
//                row.append(j).append(" ");
//            }
//            System.out.println(row);
//        }

        for (int i = 1; i <=n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void questionFour(int n) {
//        for (int i = 1; i <= n; i++) {
//            StringBuilder row = new StringBuilder();
//            row.append(" ".repeat(i - 1));
//            for (int j = i; j <= n; j++) {
//                row.append(j).append(" ");
//            }
//            System.out.println(row);
//        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i <= j) {
                    System.out.print(j);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void questionFive(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    System.out.print(" " + j + " ");
                } else if (i > j) {
                    System.out.print(" 20 ");
                } else {
                    System.out.print(" 10 ");
                }
            }
            System.out.println();
        }
    }

    public static void questionSix(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (i == j) {
                    System.out.print(" " + j + " ");
                } else if (i > j) {
                    System.out.print(" 20 ");
                } else {
                    System.out.print(" 10 ");
                }
            }
            System.out.println();
        }
    }

    public static void questionSeven() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input jumlah baris piramid : ");
        int input = scan.nextInt();

        for (int i = input; i >= 1; i--) {

            for (int j = i; j >=1 ; j--) {
                System.out.print(j + " ");
            }

            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }


    public static void questionNine(int n) {
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                for (int j = n; j >= 1; j--) {
                    System.out.print(j + " ");
                }
            } else {
                for (int j = 1; j <= n; j++) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void questionTen(int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j <= n; j++) {
                    if(j % 2 != 0) {
                        System.out.print(" - ");
                    } else {
                        System.out.print(j);

                    }
                }
            } else {
                for (int j = 1; j <= n; j++) {
                    if(j % 2 == 0) {
                        System.out.print(" - ");
                    } else {
                        System.out.print(j);

                    }
                }
            }
            System.out.println();
        }
    }

}
