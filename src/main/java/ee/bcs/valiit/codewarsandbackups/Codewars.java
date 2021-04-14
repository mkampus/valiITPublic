package ee.bcs.valiit.codewarsandbackups;

class ZywOo {

    public static void main(String[] args) {

        System.out.print(sumOfDifferences(new int[]{15, 4, 8, 3, 1, 16, 11, 2, 17, 10, 14}));





    }




    public static int sumOfDifferences(int[] arr) { //1 2 10

        int sum = 0;
        if (arr.length <= 1) {
            return sum; //If the array is empty or the array has only one element the result should be 0
        }

        if (arr.length == 2) {

            sum = (arr[0] - arr[1]);
            sum = Math.abs(sum);
            return sum;

        }
        int fullSum = 0;
        int finalSum = 0;
        //ArrayUtils.reverse(arr);
        for (int i = 0; i < arr.length; i++) {
            sum = (arr[i] - arr[i + 1]);
            sum = Math.abs(sum);
            int secondSum = (arr[i + 2] - arr[i + 1]);
            fullSum = sum + secondSum;

        }
        //your code;
        return fullSum;
    }
}

//Your task is to sum the differences between consecutive pairs in the array in descending order.