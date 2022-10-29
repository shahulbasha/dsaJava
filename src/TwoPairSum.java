import java.util.HashSet;
import java.util.Set;

public class TwoPairSum {

    public static boolean twoPairSum(int[] array, int target){

        // brute force - quadratic time O(n^2)
        for (int i=0;i< array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if(array[i]+array[j]==target){
                    return true;
                }
            }
        }
            //sorted array - linear time O(n)
        int low =0;
        int high = array.length-1;
        while(low<high){
            int sum=array[low]+array[high];
            if(sum==target){
                return true;
            }
            else if(sum<target){
                low++;
            }
            else{
                high--;
            }
        }

            //unsorted array - linear time O(n)
        Set<Integer> numSet= new HashSet<>();
        for (int value: array) {
            if(numSet.contains(value)){
                return true;
            }
            numSet.add(target-value);
        }
        return false;
    }
}
