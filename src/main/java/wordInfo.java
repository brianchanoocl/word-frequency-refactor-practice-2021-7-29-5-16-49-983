public class wordInfo {
    private String value;
    private int count;

    public wordInfo(String w, int wordCount){
        this.value =w;
        this.count =wordCount;
    }


    public String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }


}
