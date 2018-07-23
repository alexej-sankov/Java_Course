package com.telran;

public class MainClass {
    public static void main(String[] args) {
        int[] temperatures = {2,-3,3,1,10,8,2,5,13,-5,3,-18};
        String result = solution(temperatures);
        System.out.println(result);
    }

    public static String solution(int[] temperatures) {
        String[] seasons = {"WINTER", "SPRING", "SUMMER","AUTUMN"};
        int currentBiggestTempAmplitude = 0;
        String seasonWithBiggestTempAmplitude = seasons[0];
        int measurementsPerSeason = temperatures.length/seasons.length;
        int currentTempIndex = 0;
        for (int i = 1; i < seasons.length+1; i++) {
            int minIndex = 0;
            int maxIndex = 0;
            int amplitude = 0;
            for (int y = currentTempIndex; currentTempIndex<measurementsPerSeason*i; currentTempIndex++, y++) {
                if(temperatures[minIndex]> temperatures[y]) {
                    minIndex = y;
                }
                if(temperatures[maxIndex]<temperatures[y]) {
                    maxIndex = y;
                }
            }
            amplitude = temperatures[maxIndex]-temperatures[minIndex];
            if(amplitude>currentBiggestTempAmplitude) {
                currentBiggestTempAmplitude = amplitude;
                seasonWithBiggestTempAmplitude = seasons[i-1];
            }
        }
        return seasonWithBiggestTempAmplitude+" "+currentBiggestTempAmplitude;
    }

}
