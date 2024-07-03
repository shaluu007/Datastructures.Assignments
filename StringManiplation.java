package dsa.Strings;

public class StringManiplation {

    public static String getMiddleSubstring(String s1, String s2, int length) {
        String concatenated = s1.concat(s2);
        String reversed = new StringBuilder(concatenated).reverse().toString();
        int middleIndex = reversed.length() / 2;
        int startIndex = middleIndex - length / 2;
        int endIndex = startIndex + length;
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (endIndex > reversed.length()) {
            endIndex = reversed.length();
        }
        String middleSubstring = reversed.substring(startIndex, endIndex);
        return middleSubstring;
    }

    public static void main(String[] args) {
        String s1 = "abgc";
        String s2 = "defy";
        int length = 4;

        String result = getMiddleSubstring(s1, s2, length);
        System.out.println("Middle substring: " + result); 
        String emptyS1 = "";
        String emptyS2 = "xyz";
        int emptyLength = 3;
        
        String emptyResult = getMiddleSubstring(emptyS1, emptyS2, emptyLength);
        System.out.println("Middle substring : " + emptyResult); //Empty Case
        
        String longS1 = "abcdefghijkl";
        String longS2 = "mnopqrstuvwx";
        int longLength = 15;
        
        String longResult = getMiddleSubstring(longS1, longS2, longLength);
        System.out.println("Middle substring : " + longResult); //Length case
    }
}
