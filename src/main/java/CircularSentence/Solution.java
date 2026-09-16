package CircularSentence;

public class Solution {
    public boolean isCircularSentence(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) return false;

        int index = sentence.lastIndexOf(" ");
        while (index > 0) {
            if (sentence.charAt(index - 1) != sentence.charAt(index + 1)) return false;

            index = sentence.lastIndexOf(" ", index - 1);
        }

        return true;
    }
}
