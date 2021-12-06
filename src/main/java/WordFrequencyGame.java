import java.util.*;
import java.util.stream.Collectors;

/*
Refactor:
1. naming
2. magic String
3. temp var
4. for loop
5. Long methods
 */

public class WordFrequencyGame {

    public static final String SPACE_PATTERN = "\\s+";

    public String getResult(String inputSentence){


        if (inputSentence.split(SPACE_PATTERN).length==1) {
            return inputSentence + " 1";
        } else {

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


                return "Calculate Error";
            }
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


    private Map<String,List<WordInfo>> generateWordToWordInfoMap(List<WordInfo> wordInfoList) {
        Map<String, List<WordInfo>> map = new HashMap<>();
        for (WordInfo wordInfo : wordInfoList){
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(wordInfo.getInputSentence())){
                ArrayList arr = new ArrayList<>();
                arr.add(wordInfo);
                map.put(wordInfo.getInputSentence(), arr);
            }

            else {
                map.get(wordInfo.getInputSentence()).add(wordInfo);
            }
        }


        return map;
    }


}
