import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    public static final String SPACE_PATTERN = "\\s+";
    public static final String CALCULATE_ERROR = "Calculate Error";
    public static final String LINE_BREAK_PATTERN = "\n";

    public String getWordFrequencyResult(String sentence){
            try {
                List<WordInfo> wordInfoList = generateWordFrequency(sentence);

                sortWordListByFrequencyDescendant(wordInfoList);

                return generateResultingString(wordInfoList);
            } catch (Exception e) {
                return CALCULATE_ERROR;
            }
    }

    private String generateResultingString(List<WordInfo> wordInfoList) {
        StringJoiner resultString = new StringJoiner(LINE_BREAK_PATTERN);
        wordInfoList.forEach(wordInfo -> {
            resultString.add(String.format("%s %s", wordInfo.getInputSentence(), wordInfo.getWordFrequncy()));
        });
        return resultString.toString();
    }

    private void sortWordListByFrequencyDescendant(List<WordInfo> wordInfoList) {
        wordInfoList.sort((word1, word2) -> word2.getWordFrequncy() - word1.getWordFrequncy());
    }

    private List<WordInfo> generateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<String> distinctedWords = words.stream().distinct().collect(Collectors.toList());

        return generateWordInfoByDistinctedWords(words, distinctedWords);
    }

    private List<WordInfo> generateWordInfoByDistinctedWords(List<String> words, List<String> distinctedWords) {
        List<WordInfo> wordInfos = new ArrayList<>();
        distinctedWords.forEach(distinctWord -> {
            int frequency = (int) words.stream().filter(word -> word.equals(distinctWord)).count();
            WordInfo wordInfo = new WordInfo(distinctWord, frequency);

            wordInfos.add(wordInfo);
        });
        return wordInfos;
    }
}
