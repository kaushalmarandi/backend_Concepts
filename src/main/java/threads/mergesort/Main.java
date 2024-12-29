package threads.mergesort;

import org.springframework.data.relational.core.sql.In;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> arrayToSort = List.of(8, 2, 4, 1, 9, 6, 0, 7);

        Sorter sorter = new Sorter(arrayToSort);
        List<Integer> sortedArray = sorter.call();

        System.out.println("sortedArray = "+ sortedArray);
    }
}
