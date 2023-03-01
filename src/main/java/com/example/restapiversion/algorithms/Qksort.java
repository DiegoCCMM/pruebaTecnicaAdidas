package com.example.restapiversion.algorithms;

import java.util.LinkedList;
import java.util.SplittableRandom;

public class Qksort <T extends Comparable<T>> {
    public Qksort() {
    }

    public void quickSort(LinkedList<T> listOfClients, int begin, int end, SplittableRandom splittableRandom) {
        if (begin < end) {
            int partitionIndex = partition(listOfClients, begin, end, splittableRandom);

            quickSort(listOfClients, begin, partitionIndex-1, splittableRandom);
            quickSort(listOfClients, partitionIndex+1, end, splittableRandom);
        }
    }

    private int partition(LinkedList<T> listOfClients, int begin, int end, SplittableRandom splittableRandom) {
        T pivot = listOfClients.get(end);
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (listOfClients.get(j).compareTo(pivot) > 0) {
                i++;

                T swapTemp = listOfClients.get(i);
                listOfClients.set(i, listOfClients.get(j));
                listOfClients.set(j, swapTemp);
            }
        }

        T swapTemp = listOfClients.get(i + 1);
        listOfClients.set(i + 1, listOfClients.get(end));
        listOfClients.set(end, swapTemp);

        return i+1;
    }
}
