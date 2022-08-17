package org.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Five {

    public static void main(String[] args) {
        var listArgs = getArrayNumber();
        long l = listArgs.get(0);
        long r = listArgs.get(1);

        var list = getAllNumber();
        int leftArrayDivider = gettingIndexNumberInRange(l, list);
        int rightArrayDivider = gettingIndexNumberInRange(r, list);

        int count = rightArrayDivider - leftArrayDivider;
        System.out.println("count = " + count);
    }

    public static List<Long> getArrayNumber() {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        List<String> str = List.of( st.split("\\s+") );
        List<Long> array = str.stream()
                .map(i -> Long.parseLong(i))
                .collect(Collectors.toList());
        return array;
    }
    public static List<Long> getAllNumber() {
        List<Long> arrayDivider = new ArrayList<>();
        for (int i = 1; i <= 18; i++) {
            StringBuilder divider = new StringBuilder();
            for (int j = 0; j < i; j++, divider.append("1"));
            arrayDivider.add( Long.parseLong(divider.toString()) );
        }

        List<Long> resultList = new ArrayList<>();
        for (var divider: arrayDivider) {
            for (int i = 1; i <= 9; ++i) {
                resultList.add(divider * i);
            }
        }
        return resultList;
    }

    public static int gettingIndexNumberInRange(Long number, List<Long> range) {
        int border = 1;
        for (var i: range) {
            if (number < i) {
                break;
            } else {
                ++border;
            }
        }
        return border;
    }

}
