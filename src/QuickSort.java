import java.util.Scanner;

/**
 * Created by Kafukaaa on 2017/7/13.
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer[] num = new Integer[n];

        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        quickSort(num, 0, n - 1);
    }

    static void quickSort(Integer[] num, Integer l, Integer r) {
        if (l < r) {
            int i = l, j = r, x = num[l];
            while (i < j) {
                while (i < j && num[j] >= x) {
                    j--;
                }
                if (i < j) {
                    num[i] = num[j];
                    i++;
                }

                while (i < j && num[i] <= x) {
                    i++;
                }
                if (i < j) {
                    num[j] = num[i];
                    j--;
                }
            }
            num[i] = x;
            quickSort(num, l, i - 1);
            quickSort(num, i + 1, r);
        } else {
            for (int i = 0; i < num.length; i++) {
                System.out.println(num[i]);
            }
        }
    }
}

