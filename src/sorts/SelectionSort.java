package sorts;

public class SelectionSort {
    private static int[] sort(int[] arr){
        int min;

        for(int i=0; i < arr.length-1; i++){  // keep one number selected
            min = i;
            for(int j=i+1; j < arr.length; j++){  // find smallest in the rest of the array
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];  // swap the smallest with i
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {5,33,4,2,42,65};
        sort(arr);
    }
}
