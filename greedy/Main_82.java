package com.aaa.greedy;

public class Main_82 {

    public static int solution(int n, int[] stations, int w) {
        int answer = 0, sectionLength;

        for(int i=0 ; i<=stations.length; i++) {
            if(i==0) {
                sectionLength = stations[0] - w - 1;
            } else if(i == stations.length) {
                sectionLength =  n - stations[i-1] - w;
            } else {
                sectionLength = stations[i] - stations[i-1] - 2*w- 1;
            }

            if(sectionLength >= 0) {
                answer += sectionLength/(2*w+1);
                if(sectionLength % (2*w+1) != 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // int n = 11;
        // int[] stations = {4,11};
        // int w = 1;

        int n = 16;
        int[] stations = {9};
        int w = 2;

        System.out.println(solution(n, stations, w));
    }
}
