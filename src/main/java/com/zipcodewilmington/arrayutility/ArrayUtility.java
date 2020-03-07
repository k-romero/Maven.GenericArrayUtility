package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    E[] inputArr;
    ArrayList<E> arrToWorkWith = new ArrayList();

    public ArrayUtility(E[] inputArray) {
        this.inputArr = inputArray;
    }

    public Integer getNumberOfOccurrences(E valueToEvaluate){
        Integer result = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if(inputArr[i] == valueToEvaluate){
                result++;
            }
        }
        return result;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {
        Integer result = 0;
        for (int i = 0; i < arrayToMerge.length; i++) {
            if(arrayToMerge[i] == valueToEvaluate){
                result++;
            }
        }
        for (int i = 0; i < inputArr.length; i++) {
            if(inputArr[i] == valueToEvaluate){
                result++;
            }
        }
        return result;
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        putInputArrIntoArrToWorkWith(arrayToMerge);
        HashMap<E,Integer> counterMap = new HashMap<>();
        for (E key : arrToWorkWith) {
            if(counterMap.containsKey(key)){
                counterMap.replace(key,counterMap.get(key),counterMap.get(key)+1);
            } else {
                counterMap.put(key,1);
            }
        }
        E result = null;
        int maxCount = 0;
        for (Map.Entry<E,Integer> val : counterMap.entrySet()) {
            if(maxCount < val.getValue()){
                result = val.getKey();
                maxCount = val.getValue();
            }
        }

        return result;
    }

    public E[] removeValue(E valueToRemove) {
        int counter = 0;
        E[] result = Arrays.copyOf(inputArr, inputArr.length-getNumberOfOccurrences(valueToRemove));
        for (int i = 0; i < inputArr.length; i++) {
            if(inputArr[i] != valueToRemove){
                result[counter] = inputArr[i];
                counter++;
            }
        }
        return result;
    }



    private void putInputArrIntoArrToWorkWith(E[] arrayToMerge){
        arrToWorkWith.addAll(Arrays.asList(inputArr));
        arrToWorkWith.addAll(Arrays.asList(arrayToMerge));

    }
}
