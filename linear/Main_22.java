package com.aaa.linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main_22 {

    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        Map<String, Integer> playMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> genresMap = new HashMap<>();

        for(int i=0 ; i< genres.length ; i++) {
            String genre = genres[i];
            int play = plays[i];

            // playMap과 genresMap을 초기화
            if(!genresMap.containsKey(genre)){
                playMap.put(genre, 0);
                genresMap.put(genre,new HashMap<>());
            } 

            // playMap과 genresMap에 값을 삽입하여 Map객체 생성
            playMap.put(genre, playMap.get(genre) + play);
            genresMap.get(genre).put(i, play);
        }

        // playMap을 Sorting
        List<String> keySet = new ArrayList<>(playMap.keySet());
        Collections.sort(keySet, (s1, s2) -> playMap.get(s2) - playMap.get(s1));

        // genresMap을 Sorting
        for(String key : keySet) {
            Map<Integer, Integer> map = genresMap.get(key);
            List<Integer> genre_keySet = new ArrayList<>(map.keySet());

            Collections.sort(genre_keySet, (s1, s2) -> map.get(s2) - map.get(s1));
            
            answer.add(genre_keySet.get(0));
            if(genre_keySet.size() > 1)
                answer.add(genre_keySet.get(1));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.stream(solution(genres, plays))
        		.boxed().collect(Collectors.toList()));
    }
}
