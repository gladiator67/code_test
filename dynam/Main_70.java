package com.aaa.dynam;

public class Main_70 {

    private static int solution(int n) {
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;

        for(int i=2 ; i<=n ; i++) {
            f[i] = (f[i-1] + f[i-2])%1234567;
        }

        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}
