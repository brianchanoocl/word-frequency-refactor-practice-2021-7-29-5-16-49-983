public class wordInfo {
    private String inputSentence;
    private int wordCount;

    public wordInfo(String w, int wordCount){
        this.inputSentence = w;
        this.wordCount = wordCount;
    }


    public String getInputSentence() {
        return this.inputSentence;
    }

    public int getWordCount() {
        return this.wordCount;
    }


}
