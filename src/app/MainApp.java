package app;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1 ; i <= n ;i++){
            for(int j = 0; j < i; j++){
                System.out.println("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}