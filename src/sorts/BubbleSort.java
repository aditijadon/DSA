package sorts;

public class BubbleSort {

    private static int[] sort(int arr[]){
        boolean isSwapped;
        for(int i=0; i<arr.length-1; i++){
            isSwapped = false;
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped) break;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {5,33,4,2,42,65};
        sort(arr);
    }
}
