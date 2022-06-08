package org.wzq.bioplat;

public class Finder {
    public int findMissing(int[][] numbers, int n) {
        for (int i = 0; i < numbers.length; ++i) {
            int[] bits = numbers[i];
            for (int j = 0; j < bits.length; ++j) {
                if (((i >> j) & 1) != bits[j]) {
                    return i;
                }
            }
        }
        return n;
    }
    public void test() {

    }

    public static void main(String[] args) {
        System.out.println(new Finder().findMissing(new int[][]{{0},{1}}, 2));
    }
}