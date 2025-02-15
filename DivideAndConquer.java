public class DivideAndConquer {

    static void Merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid; 

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Merge the temp arrays back into the original array
        int iIndex = 0, jIndex = 0; int kIndex = left;
        while (iIndex < n1 && jIndex < n2) {
            if (leftArray[iIndex] <= rightArray[jIndex]) {
                array[kIndex] = leftArray[iIndex];
                iIndex++;
            } else {
                array[kIndex] = rightArray[jIndex];
                jIndex++;
            }
            kIndex++;
        }
        // the missing logic to copy the remaining elements of leftArray and rightArray
        while (iIndex < n1) {
            array[kIndex] = leftArray[iIndex];
            iIndex++;
            kIndex++;
        }
        // Copy the remaining elements of rightArray
        while (jIndex < n2) {
            array[kIndex] = rightArray[jIndex];
            jIndex++;
            kIndex++;
        }
    }

    static void MergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Divide step
            MergeSort(array, left, mid);
            MergeSort(array, mid + 1, right);

            Merge(array, left, mid, right);
        }
    }
    public static void main(String[] args) {
        int[] array = {150, 112, 132, 162, 65, 72};
        int arrayLength = array.length;

        System.out.println("Inputted Number Array");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print("[" + array[i] + "]");
            if (i < arrayLength - 1) {
                System.out.print("->");
            }
        }
        System.out.println();

        MergeSort(array, 0, arrayLength - 1);

        System.out.println("\nSorted Array");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print("[" + array[i] + "]");
            if (i < arrayLength - 1) {
                System.out.print("->");
            }
        }
    }
}