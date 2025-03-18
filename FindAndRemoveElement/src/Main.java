import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,6,7,6,8,9,10};
        int item = 6;
        System.out.println(Arrays.toString(findAndRemoveItem(arr, item)));
    }

    private static int[] findAndRemoveItem(int[] arr, int item) {
        int offset = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == item){
                offset++;
            }
            else {
                arr[i - offset] = arr[i];
            }
        }

        return Arrays.copyOf(arr, arr.length - offset);
    }
}