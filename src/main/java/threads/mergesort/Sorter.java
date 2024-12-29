package threads.mergesort;

import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> arrayToSort;

    public Sorter(List<Integer> arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    @Override
    public List<Integer> call() throws ExecutionException, InterruptedException {
        if(arrayToSort.size()<=1){
            return arrayToSort;
        }
        ArrayList<Integer> leftArrayToSort = new ArrayList<>();
        ArrayList<Integer> rightArrayToSort = new ArrayList<>();

        int mid = arrayToSort.size()/2;
        for(int i=0; i<mid; i++){
            leftArrayToSort.add(arrayToSort.get(i));
        }
        for(int i=mid; i<arrayToSort.size(); i++){
            rightArrayToSort.add(arrayToSort.get(i));
        }

        ExecutorService ex= Executors.newCachedThreadPool();

        Sorter leftSorted = new Sorter(leftArrayToSort);
        Future<List<Integer>> sortedLeftArrayFuture = ex.submit(leftSorted);
        Sorter rightSorted = new Sorter(rightArrayToSort);
        Future<List<Integer>> sortedRightArrayFuture = ex.submit(rightSorted);

        List<Integer> sortedLeftArray = sortedLeftArrayFuture.get();
        List<Integer> sortedRightArray = sortedRightArrayFuture.get();



        ArrayList<Integer> sortedArray = new ArrayList<>();

        int i=0, j=0;
        while(i<sortedLeftArray.size() && j<sortedRightArray.size()){
            if(sortedLeftArray.get(i)<=sortedRightArray.get(j)){
                sortedArray.add(sortedLeftArray.get(i));
                i++;
            }else{
                sortedArray.add(sortedRightArray.get(j));
                j++;
            }
        }

        while(i<sortedLeftArray.size()){
            sortedArray.add(sortedLeftArray.get(i));
            i++;
        }
        while(j<sortedRightArray.size()){
            sortedArray.add(sortedRightArray.get(j));{
               j++;
            }
        }
        return sortedArray;
    }
}
