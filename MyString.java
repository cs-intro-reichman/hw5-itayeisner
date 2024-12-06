/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
    
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int sum = 0;
        for(int i=0;i<str.length();i++){sum += str.charAt(i)==ch ? 1:0;}
        return sum;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns false
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        String lowstr1=str1.toLowerCase();
        String lowstr2=str2.toLowerCase();
        if(remove(lowstr2, lowstr1).length()==(str2.length()-str1.length())){return true;}
       /*code for find substring: 
        for(int i=0;i<(str1.length()-str2.length());i++){
            int counter = 0;
            for(int j=0;j<str2.length();j++){
               if(lowstr1.charAt(i+j)==lowstr2.charAt(j)){counter++;}
               else{
                counter=0;
                break;} 
            }
            if(counter==str2.length()){return true;}
        }*/
        return false;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String spaced = "";
        for(int i=0;i<str.length();i++){
           if(i+1!=str.length()) spaced += str.charAt(i) + " ";
            else spaced += str.charAt(i);
        }
        return spaced;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String str = "";
        for(int i=0;i<n;i++){
            str += (char) ((int) (Math.random()*26+97));
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        char[] arr1 = String2Arr(str1);
        char[] arr2 = String2Arr(str2);
        String removing ="";
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr1.length;j++){
                if(arr1[j]==arr2[i]){
                    arr1[j]=' ';
                    break;
                }
            }
        }
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=' '){removing+=arr1[i];}
        }
        return removing;
    }

    public static char[] String2Arr(String str) {
        char[] arr1 = new char[str.length()];
        for(int i=0;i<str.length();i++){
            arr1[i]= str.charAt(i);
        }
        return arr1;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    } 
    
    public static boolean isRuni(String str1) {
        String lowstr1="runni";
        String lowstr2=str1.toLowerCase();
     
        for(int i=0;i<(str1.length()-lowstr1.length());i++){
            int counter = 0;
            for(int j=0;j<lowstr1.length();j++){
               if(lowstr2.charAt(i+j)==lowstr1.charAt(j)){counter++;}
               else{
                counter=0;
                break;} 
            }
            if(counter==lowstr1.length()){return true;}
        }
        return false;
    }
}
