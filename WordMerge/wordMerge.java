package WordMerge;
import java.util.*;
public class wordMerge{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String w1 = sc.nextLine();
        String w2 = sc.nextLine();

        String temp = w1+""+w2;
        char[] arr = temp.toCharArray();
        
        System.out.println("Merged Word: " + wordMerge(w1, w2));
        System.out.println("Alphabetical Merged Word: " + AlphaMergeSort(arr));
    }

    private static String wordMerge(String w1, String w2){
        String r = "", longWord = "";
        int longWordLength = 0, shortWordLength = 0;

        if(w1.length() < w2.length()){
            longWordLength = w2.length();
            shortWordLength = w1.length();
            longWord = w2;
        }else{
            longWordLength = w1.length();
            shortWordLength = w2.length();
            longWord = w1;
        }

        for(int i = 0; i < longWordLength; i++){
            if(i < shortWordLength){
                r = r + w1.charAt(i);
                r = r + w2.charAt(i);
            }else{
                r = r+longWord.charAt(i);
            }
        }
        return r;
    }

    private static String AlphaMergeSort(char[] arr){
        for(int i = 0; i< arr.length; i++){
            for(int j=0; j < arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    char tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        String r = new String(arr);
        return r;
    }
}