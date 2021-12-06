import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

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

                //split the input string with 1 to n pieces of spaces
                String[] words = inputSentence.split(SPACE_PATTERN);

                List<WordInfo> wordInfoList = new ArrayList<>();
                for (String word : words) {
                    WordInfo wordInfo = new WordInfo(word, 1);
                    wordInfoList.add(wordInfo);
                }

                //get the map for the next step of sizing the same word
                Map<String, List<WordInfo>> map = getListMap(wordInfoList);

                List<WordInfo> list = new ArrayList<>();
                for (Map.Entry<String, List<WordInfo>> entry : map.entrySet()){
                    WordInfo wordInfo = new WordInfo(entry.getKey(), entry.getValue().size());
                    list.add(wordInfo);
                }
                wordInfoList = list;

                wordInfoList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (WordInfo wordInfo : wordInfoList) {
                    String s = wordInfo.getInputSentence() + " " +wordInfo.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
    }


    private Map<String,List<WordInfo>> getListMap(List<WordInfo> wordInfoList) {
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
