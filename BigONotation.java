package com.company;

public class BigONotation {

    public void generateRandomArray(){
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random()*100);
        }
        itemsInArray = arraySize - 1;
    }

    public void printArray(){
        for (int i = 0; i < arraySize; i++) {
            System.out.println(theArray[i]);
        }
    }

    public BigONotation(int arraySize) {
        this.arraySize = arraySize;
        theArray = new int[arraySize];
    }

    private int[] theArray;
    private int arraySize;
    int itemsInArray = 0;
    long startTime;
    long endTime;

    //O(1) example
    //this code will execute always at same speed no matter how many data in the array is.

    public void addItemToArray(int newItem){
        theArray[itemsInArray++] = newItem;
    }

    //O(n)
    //this complexity means that the speed of this algorithm will be exactly the size of the data or array
    //for instance this algorithm took 1 milliseconds to find a value in a 10,000 size array
    //while it took 13 milliseconds to find it in a 100,000 size array
    //with 1 million array: 121 milliseconds
    // with 100 million array: 27,167 milliseconds
    public void linearSearch(int value){
        boolean valueInArray = false;
        String indexsWithValue = "";

        startTime = System.currentTimeMillis();
        for(int i=0; i<arraySize;i++){
            if(theArray[i]==value){
                valueInArray=true;
                indexsWithValue+=i+" ";
            }
        }
        endTime=System.currentTimeMillis();
        System.out.println("Value found "+valueInArray);
        System.out.println("linear search took: "+ (endTime-startTime));
    }

    //O(N^2)
    //the time to complete will be the square of the amount of data.
    //for instance this algorithm took 356 milliseconds to sort the array in a 10,000 size
    //while it took 43,611 milliseconds to sort the array in a 100,000 size array
    //the waiting with a million and 100 million took more than half an hour and had to be stopped because of laziness.
    public void bubblesort(){
        startTime=System.currentTimeMillis();
        int pivot;
        for (int i = arraySize-1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if(theArray[j]>theArray[j+1]){
                    pivot=theArray[j];
                    theArray[j]=theArray[j+1];
                    theArray[j+1]=pivot;
                }
            }
        }
        endTime=System.currentTimeMillis();
        System.out.println("bubblesort took: "+ (endTime-startTime));
    }

    //O(Log N) is quite fast.
    //the data decreases on each iteration, yup, in a logarithmic way. which makes it fast, really fast.
    // with 10,000 data the algorithm performed in 0 milliseconds and went through 13 times.
    // with 100,000 data the algorithm took 0 milliseconds and went through 16 times.
    // with 1 million data: 0 milliseconds, 19 times
    // with 100 million data: 1 millisecond, 26 times
    public void binarySearch(int value){
        //iterative implementation
        bubblesort();
        startTime=System.currentTimeMillis();
        int lowIndex=0;
        int highIndex = arraySize-1;
        int timesThrough = 0;
        int middleIndex;
        while(lowIndex <= highIndex){

            middleIndex= (highIndex+ lowIndex)/2;
            if(theArray[middleIndex] < value)
                lowIndex = middleIndex + 1;

            else if(theArray[middleIndex] > value)
                highIndex = middleIndex-1;

            else{
                System.out.println("Found match in index "+middleIndex);
                lowIndex = highIndex+1;
            }

            timesThrough++;
        }
        endTime=System.currentTimeMillis();
        System.out.println("binary search took: "+ (endTime-startTime));
        System.out.println("Times through "+timesThrough);
    }

    //O(n Log n)
    //this is the same as:
    //n Log n = Log n! = Logn + Log (n-1) + ... + Log(1)
    public void quickSort(int low, int high) {

    }
}
