public class WordInfo {
    private String word;
    private int wordFrequncy;

    public WordInfo(String inputSetence, int wordFrequncy){
        this.word = inputSetence;
        this.wordFrequncy = wordFrequncy;
    }


    public String getInputSentence() {
        return this.word;
    }

    public int getWordFrequncy() {
        return this.wordFrequncy;
    }


}
