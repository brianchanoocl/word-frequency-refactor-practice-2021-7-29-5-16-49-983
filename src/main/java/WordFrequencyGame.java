import java.util.*;
import java.util.stream.Collectors;

/*
Refactor:
3. temp var
4. for loop
5. Long methods
6. useless if
7. comment
 */

public class WordFrequencyGame {

    public static final String SPACE_PATTERN = "\\s+";
    public static final String CALCULATE_ERROR = "Calculate Error";

    public String getResult(String inputSentence){
            try {
                List<WordInfo> wordInfoList = calculateWordFrequency(inputSentence);

                sortWordListByFrequencyDescendant(wordInfoList);

                return computeResultingString(wordInfoList);
            } catch (Exception e) {
                return CALCULATE_ERROR;
            }
    }

    private String computeResultingString(List<WordInfo> wordInfoList) {
        StringJoiner resultString = new StringJoiner("\n");
        for (WordInfo wordInfo : wordInfoList) {
            String wordFrequencyPair = wordInfo.getInputSentence() + " " +wordInfo.getWordFrequncy();
            resultString.add(wordFrequencyPair);
        }
        return resultString.toString();
    }

    private void sortWordListByFrequencyDescendant(List<WordInfo> wordInfoList) {
        wordInfoList.sort((word1, word2) -> word2.getWordFrequncy() - word1.getWordFrequncy());
    }

    private List<WordInfo> calculateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<String> distinctedWords = words.stream().distinct().collect(Collectors.toList());

        List<WordInfo> wordInfos = new ArrayList<WordInfo>();
        distinctedWords.forEach(distinctedWord -> {
            int frequency = (int) words.stream().filter(word -> word.equals(distinctedWord)).count();
            WordInfo wordInfo = new WordInfo(distinctedWord, frequency);

            wordInfos.add(wordInfo);
        });

        return wordInfos;
    }
}
