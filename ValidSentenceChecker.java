import java.util.Scanner;

public class ValidSentenceChecker {

    public static void main(String[] args){
        //Reading in the scanner
        Scanner scanner = new Scanner(System.in);

        //Ask for uesr input
        System.out.println("Enter a sentence: ");
        String userInput = scanner.nextLine();

        //Checking if the entered sentence is valid
        boolean isValid = isValidSentence(userInput);

        //display end result to user
        if (isValid){
            System.out.println("The sentence you have entered is valid!");
        }else {
            System.out.println("The sentence you have entered is not valid!");
        }

        scanner.close();
    }

    //check if the sentence is valid based on the specified set of rules
    public static boolean isValidSentence(String sentence){
        return startsWithCapital(sentence)
        && hasEvenQuotation(sentence)
        && endsWithValidTermination(sentence)
        && hasNoPeriodsOtherThanLast(sentence)
        && numbersBelow13AreSpelledOut(sentence);
    }

    //check if the sentence starts with a capital letter
    private static boolean startsWithCapital(String sentence){
        return sentence != null && !sentence.isEmpty() && Character.isUpperCase(sentence.charAt(0));
    }

    //check if the sentence has an even number of quotation marks
    private static boolean hasEvenQuotation(String sentence){
        return countOccurrences(sentence, '"') % 2 ==0;
    }

    //check if the sentence ends with a valid ternminaion character
    private static boolean endsWithValidTermination(String sentence){
        char lastChar = sentence.charAt(sentence.length() -1);
        return lastChar == '.' || lastChar == '?' || lastChar == '!';
    }

    //check if the sentence has no periods apart from the final character
    private static boolean hasNoPeriodsOtherThanLast(String sentence){
        return !sentence.substring(0, sentence.length() -1).contains(".");
    }


    //check if numbers below 13 are spelled out
    private static boolean numbersBelow13AreSpelledOut(String sentence){
        String[] words = sentence.split("\\s+");
        for (String word : words){
            if (isNumeric(word) && Integer.parseInt(word) < 13){
                return false;
            }
        }
        return true;
    }

    //count occurences of a character in a string
    private static int countOccurrences(String str, char target){
        int count = 0;
        for (char c : str.toCharArray()){
            if (c == target){
                count++;
            }
        }
        return count;
    }

    //check if a string represents a numeric value
    private static boolean isNumeric(String str){
        return str.matches("\\d+");
    }
}
