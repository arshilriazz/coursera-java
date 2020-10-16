package coursera.course4;

public class Searches {
    public static int binarySearch(int[] sortedArray, int num) {
        int i = 0;
        int j = sortedArray.length;
        while(i <= j) {
            int mid = (i+j)/2;
            if(sortedArray[mid] == num) return mid;
            else if (sortedArray[mid] < num) {
                i = mid + 1;
            }
            else {
                j = mid - 1;
            }
        }
        return -1;
    }
}
