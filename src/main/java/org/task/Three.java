package org.task;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Three {

    public static void main(String[] args) {
        var n_t = getArrayNumber();
        var listFloors = getArrayNumber();
        var indexMandatoryGoods = nextInt();
        Integer t = n_t.get(1);

        isCheckData(n_t, listFloors, indexMandatoryGoods);

        Integer minCountFlightStairs = findMinCountFlightStairs(t, listFloors, indexMandatoryGoods);
        System.out.println(minCountFlightStairs);
    }

    private static void isCheckData(List<Integer> n_t, List<Integer> listFloors, int indexMandatoryGoods) {
        Integer n = n_t.get(0);
        Integer t = n_t.get(1);

        if (n < 2 || t < 2 || n > 100 || t > 100) {
            throw new RuntimeException("Error in n or t");
        }

        for (var i: listFloors) {
            if(i > 100) {
                throw new RuntimeException("Error in Floors");
            }
        }
    }

    private static Integer findMinCountFlightStairs(Integer time,
                                                    List<Integer> listFloors, Integer indexMandatoryGoods) {
        Integer gloabalMin = 0;

        var minFloor = listFloors.get(0);
        var urgentFloor = listFloors.get( indexMandatoryGoods-1 );
        var maxFloor = listFloors.get( listFloors.size()-1 );

        if (urgentFloor - 1 <= time) {
            gloabalMin = maxFloor - 1;
        } else {
            var currFloor = urgentFloor;

            var min1 = getMin1(currFloor, minFloor, maxFloor);
            var min2 = getMin2(currFloor, minFloor, maxFloor);

            gloabalMin = Math.min(min1, min2);
        }

        return gloabalMin;
    }

    private static Integer getMin1(Integer currFloor, Integer minFloor, Integer maxFloor) {
        var down = 0;
        var up = maxFloor - currFloor;

        if (currFloor > minFloor) {
            down = maxFloor - minFloor;
        }
        return up + down;
    }

    private static Integer getMin2(Integer currFloor, Integer minFloor, Integer maxFloor) {
        var up = 0;
        var down = currFloor - minFloor;

        if (currFloor < maxFloor) {
            up = maxFloor - minFloor;
        }

        return up + down;
    }

    public static List<Integer> getArrayNumber() {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        List<String> str = List.of( st.split("\\s+") );
        var array = str.stream()
                .map(i -> Integer.parseInt(i))
                .collect(Collectors.toList());
        return array;
    }

    public static int nextInt() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            return sc.nextInt();
        }
        return 0;
    }
}
