public class Model {
    private String phrase = "";

    private static final String WHITESPACE = " ";
    private static final String EXCLAMATION_MARK = "!";
    public static final String HELLO = "hello";
    public static final String WORLD = "world";


    public String getPhrase() {
        addExclamationMark();
        return phrase;
    }

    private void addExclamationMark() {
        phrase = phrase.substring(0, phrase.length() - 1) + EXCLAMATION_MARK;
    }

    public void accumulateWords(String word) {
        phrase += word + WHITESPACE;
    }

    public boolean isCorrectWord(String word, String expectedWord) {
        return (word.toLowerCase().equals(expectedWord));
    }


}
