public class WordInfo {
    private String inputSentence;
    private int wordCount;

    public WordInfo(String inputSetence, int wordCount){
        this.inputSentence = inputSetence;
        this.wordCount = wordCount;
    }


    public String getInputSentence() {
        return this.inputSentence;
    }

    public int getWordCount() {
        return this.wordCount;
    }


}
