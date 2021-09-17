package HW3;

class InfoArray {

        static <T> void showArray(T[] array) {
            System.out.print("{");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println("}");
        }
    }


 class Task1{
    public static void main(String[] args){
        Integer[] testArr = {8, 16, 32, 64, 128, 256, 512};
        System.out.print("source array: ");
        InfoArray.showArray(testArr);
        Task1.swap(testArr,3,5);
        System.out.print("after swap: ");
        InfoArray.showArray(testArr);
        }

      static <T> void swap(T[] testArr, int i, int j) {
        T temp = testArr[i];
        testArr[i] = testArr[j];
        testArr[j] = temp;
    }
}






