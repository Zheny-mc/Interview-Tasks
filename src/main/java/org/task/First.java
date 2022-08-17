package org.task;

import java.util.Scanner;

public class First {

    public static void main(String[] args) {

        int A = nextInt();
        int B = nextInt();
        int C = nextInt();
        int D = nextInt();

        int result = 0;
        if (D > B) {
            result = A + C * (D - B);
        } else if (D <= B) {
            result = A;
        }

        System.out.println(result);
    }

    public static int nextInt() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            return sc.nextInt();
        }
        return 0;
    }


}
