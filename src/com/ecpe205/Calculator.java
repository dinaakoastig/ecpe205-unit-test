package com.ecpe205;

public class Calculator {
    public double sum( double a, double b ) {
        return a + b;
    }
    public boolean isEven (int value) {
        return value % 2 == 0;
    }
    public boolean isOdd (int value) {
        return value % 2 == 1;
    }

    //create a method that computes base x power of y
    //use parameterizedTest methodsource - 5 sets to test
    public double expo ( double x, double y){
        return Math.pow(x, y);
    }
    //create a method that computes for the factorial of a value
    //use parameterizedTest- 5 values to test
    public long factorial(int n) {
        return (1 > n) ? 1 : n * factorial(n - 1);
    }
    //create a method that checks if a given string is a palindrome
    //use parameterizedTest - 5 values to test
    public static boolean isPalindrome(String word) {
        String originalString = word;
        int i = 0, j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) return false;
            i++;
            j--;
        }
        return originalString.equalsIgnoreCase(word);
    }
    //create a method that accepts an array of integer values, the method then sorts the value in ascending order
    //** you may choose whatever sort data structure (bubble sort, shell sort,...)
    //use parameterizedTest methodSource
    public void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}
