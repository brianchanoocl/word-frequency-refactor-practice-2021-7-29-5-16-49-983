public class wordInfo {
    private String value;
    private int wordCount;

    public wordInfo(String w, int wordCount){
        this.value = w;
        this.wordCount = wordCount;
    }


    public String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.wordCount;
    }


}
