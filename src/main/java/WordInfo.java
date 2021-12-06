public class WordInfo {
    private String inputSentence;
    private int wordFrequncy;

    public WordInfo(String inputSetence, int wordFrequncy){
        this.inputSentence = inputSetence;
        this.wordFrequncy = wordFrequncy;
    }


    public String getInputSentence() {
        return this.inputSentence;
    }

    public int getWordFrequncy() {
        return this.wordFrequncy;
    }


}
