import java.util.*;
import java.util.stream.Collectors;

/*
Refactor:
1. naming
2. magic String
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

                wordInfoList.sort((word1, word2) -> word2.getWordFrequncy() - word1.getWordFrequncy());

                StringJoiner resultString = new StringJoiner("\n");
                for (WordInfo wordInfo : wordInfoList) {
                    String wordFrequencyPair = wordInfo.getInputSentence() + " " +wordInfo.getWordFrequncy();
                    resultString.add(wordFrequencyPair);
                }
                return resultString.toString();
            } catch (Exception e) {
                // TODO add test case (null String) for this catch

                return CALCULATE_ERROR;
            }
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


    private Map<String,List<WordInfo>> generateWordToWordInfoHashMap(List<WordInfo> wordInfoList) {
        Map<String, List<WordInfo>> wordInfoMap = new HashMap<>();
        for (WordInfo wordInfo : wordInfoList){
//       wordInfoMap.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!wordInfoMap.containsKey(wordInfo.getInputSentence())){
                ArrayList wordAndWordInfoPair = new ArrayList<>();
                wordAndWordInfoPair.add(wordInfo);
                wordInfoMap.put(wordInfo.getInputSentence(), wordAndWordInfoPair);
            }

            else {
                wordInfoMap.get(wordInfo.getInputSentence()).add(wordInfo);
            }
        }


        return wordInfoMap;
    }


}
