package org.task;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Integer numPart = nextInt();

        Integer intPart = numPart / 2;
        Integer remainderDivision = numPart % (2 * intPart);

        System.out.println(intPart + remainderDivision);
    }

    public static int nextInt() {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        if (sc.hasNext()) {
            number = sc.nextInt();
        }
        return number;
    }
}
