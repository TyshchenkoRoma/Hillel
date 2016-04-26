/**
 * Created by roman on 22.04.16.
 */
public class Model {
    int array[] = {1, 4, 6, 6, 5};
    int max = array[0];
    int index = 0;

    public static int getMax(int[] array, int max) {
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static int getMaxIndex(int[] array, int max, int index) {
        for (int i = 0; i < array.length; i++) {
            if (max == array[i]) {
                index = i;
            }
        }
        return index;
    }
}
