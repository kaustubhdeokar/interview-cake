public class Sorting {

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        int[] arr = {5, 6, 8, 2, 3, 4, 7, 1};
        sorting.cyclicSort(arr);
    }

    public void selectionSort(int[] arr) {

        //select min from 0 to n -> put at 0th place.
        //select min from 1 to n -> put at 1st place.
        //...

    }

    public void insertionSort(int[] arr) {
        //create a sorted space (start from 1 gradually to n).
        for (int i = 1; i < arr.length; i++) {
            int elem = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > elem) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = elem;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public void merge(int[] arr, int l, int mid, int r) {

        int lPtr = l;
        int rPtr = mid + 1;
        int[] newArr = new int[r - l + 1];
        int newArrPtr = 0;

        while (lPtr <= mid && rPtr <= r) {

            if (arr[lPtr] < arr[rPtr]) {
                newArr[newArrPtr] = arr[lPtr];
                lPtr += 1;
            } else {
                newArr[newArrPtr] = arr[rPtr];
                rPtr += 1;
            }
            newArrPtr += 1;
        }

        while (lPtr <= mid) {
            newArr[newArrPtr] = arr[lPtr];
            newArrPtr += 1;
            lPtr += 1;
        }
        while (rPtr <= r) {
            newArr[newArrPtr] = arr[rPtr];
            rPtr += 1;
            newArrPtr += 1;
        }

        newArrPtr = 0;

        for (int i = l; i <= r; i++) {
            arr[i] = newArr[newArrPtr];
            newArrPtr += 1;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {

        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    private int partition(int[] arr, int l, int r) {
        int i = l;
        int j = r - 1;
        int pivot = arr[r];
        while (i < j) {

            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i >= j) break;

            swap(arr, i, j);
        }

        swap(arr, i, r);

        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.println();

        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void cyclicSort(int[] arr) {

        //1 to n.
        int i = 0;
        while (i < arr.length) {
            // 2 3 1.
            // 3 2 1.
            // 1 2 3
            //swap(arr, i, arr[i]-1)
            //2 arr[2]-1
            while (arr[i] != (arr[arr[i] - 1])) {
                swap(arr, i, arr[i] - 1);

                for (int j : arr) {
                    System.out.print(j + " ");
                }
                System.out.println();

            }
            i += 1;
        }

    }

}
