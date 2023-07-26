package arrays;

import java.util.Arrays;

public class Mode {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 3};

        int currNum = -1;
        int currNumOcc = -1;
        int maxOcc = 0;

        findMode(arr, currNum, currNumOcc, maxOcc);
    }

    private static void findMode(int[] arr, int currNum, int currNumOcc, int maxOcc) {

        int[] resArr = new int[1];
        int resPtr = 0;
        for (int i : arr) {

            if (i != currNum) {

                if (currNumOcc == maxOcc) {
                    System.out.println("1");
                    resArr = addToResArr(resArr, resPtr, currNum);
                    resPtr += 1;
                } else if (currNumOcc > maxOcc) {

                    maxOcc = currNumOcc;
                    resArr = emptyAndAddToResArr(resArr, currNum);

                    System.out.println("2");
                        for(int j:resArr){
                            System.out.print(j+" ");
                        }
                    System.out.println("2 end");
                }
                currNum = i;
                currNumOcc = 1;
                System.out.println("currNum:"+currNum+" currNumOcc:"+currNumOcc);
            }
            else if (i == currNum) {
                currNumOcc += 1;
                System.out.println("currNum:"+currNum+" currNumOcc:"+currNumOcc);
            }
        }

        for (int i : resArr) {
            System.out.print(i + " ");
        }

    }

    private static int[] emptyAndAddToResArr(int[] resArr, int currNum) {
        return new int[currNum];
    }

    private static int[] addToResArr(int[] resArr, int resPtr, int currNum) {
        if (resPtr == resArr.length) {
            Arrays.copyOf(resArr, resArr.length * 2);
        }
        System.out.println("currNum:"+currNum);
        resArr[resPtr] = currNum;
        return resArr;
    }


}
