package org.task;

import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.util.*;
import java.util.stream.Collectors;

public class Four {
    public static void main(String[] args) {
        Four start = new Four();
        start.run();
    }

    public void run() {
        Four main = new Four();
        var list_n_k = List.of(5, 4);//main.getArrayNumber();
        Integer n = list_n_k.get(0);
        Integer k = list_n_k.get(1);

        var numbers = List.of(1,2,1,3,5);//main.getArrayNumber();
        var comb = new CombinationsWithoutRepetitions().get(n, k);
        var arrays = main.getArraysByIndexes(numbers, comb);

        Integer maxSum = 0;
        for (var arr: arrays) {
            Integer sum = 0;
            for (var i: arr) {
                sum += 9-i;
                maxSum = sum > maxSum? sum : maxSum;
            }
        }

        System.out.println("maxSum = " + maxSum);
    }


    public List<Integer> getArrayNumber() {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        List<String> str = List.of( st.split("\\s+") );
        List<Integer> array = str.stream()
                .map(i -> Integer.parseInt(i))
                .collect(Collectors.toList());
        return array;
    }

    class CombinationsWithoutRepetitions {
        private int n;
        private int k;
        private int[] a;
        private List<List<Integer>> result;

        public CombinationsWithoutRepetitions() {
            this.result = new ArrayList<>();
        }

        private void generate(int pos, int maxUsed) {
            if (pos == k) {
                result.add(Four.intArrayToList(a));
            } else {
                for(int i = maxUsed+1; i <= n; i++) {
                    a[pos] = i;
                    generate(pos+1, i);
                }
            }
        }

        public List<List<Integer>> get(int n, int k) {
            this.n = n;
            this.k = k;
            this.a = new int[k];
            generate(0,0);
            return result;
        }
    }


    public static List<Integer> intArrayToList(int[] intArray) {
        List<Integer> result = new ArrayList<>();
        for (var i: intArray) {
            result.add(i);
        }
        return result;
    }

    public List<List<Integer>> getArraysByIndexes(List<Integer> array,
                                         List<List<Integer>> arraysInd) {
        List<List<Integer>> result = new ArrayList<>();
        for (var list: arraysInd) {
            List<Integer> curArray = new ArrayList<>();
            for (var i: list) {
                curArray.add(array.get(i-1));
            }
            result.add(curArray);
        }
        return result;
    }

}
