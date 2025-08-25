package CoreJavaConceptsForSelenium.InterviewQuestions;

public class a2b3c4 {

    public static void main(String[] args) {

        String str = "a2b3c4";  //o/p: aabbbcccc
        char[] ch = str.toCharArray();

        for (int i = 1; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                for (int j = 0; j < Character.getNumericValue(ch[i]); j++) {
                    System.out.print(ch[i-1]);
                }
            }
        }
    }
}
