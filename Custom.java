class Custom {
    public static void main(String[] args) {
        int sumArray;

        String[][] strAr = new String[][]{{"1", "2", "3", "4", "57"},
                {"2", "5", "6", "7", "534"},
                {"3", "8", "9", "10", "45"},
                {"4", "11", "12", "13", "45"}};
        try {
            try {
                sumArray = changeArray(strAr);
                System.out.println(sumArray);

            } catch (MyArraySizeException exc) {
                System.out.println(exc);
            }
        }
        catch (MyArrayDataException exc){
            System.out.println(exc);
        }


    }
    static int changeArray(String[][] myarray) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if(myarray.length !=4 ){
            throw new MyArraySizeException();
        }
        for (int i = 0; i < myarray.length; i++) {
            if (myarray[i].length !=4) throw new MyArraySizeException();
            for (int j = 0; j < myarray.length; j++) {
                try {
                    sum += Integer.parseInt(myarray[i][j]);
                }
                catch (NumberFormatException exc){
                   throw new MyArrayDataException(i,j);
                }

            }
        }
       return sum;
    }

}
class MyArraySizeException extends Exception{
    public String toString(){
        return "Array is big";
    }

}
class MyArrayDataException extends Exception{
    int j;
    int i;

    MyArrayDataException(int i, int j){
        this.j = j;
        this.i = i;
    }
    public String toString(){
        return "the number can not be string can not to convert to int";
    }
}

