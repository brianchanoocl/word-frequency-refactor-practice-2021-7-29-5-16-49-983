import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WordFrequencyGameTest {

    @Test
    public void should_get_the_1_when_input_the() throws Exception {
        //Given
        String sentence = "the";
        String expectResult = "the 1";
        validate_sentence_and_convert_sentence_to_word_frequency(sentence, expectResult);
    }

    @Test
    public void should_process_two_words() throws Exception {
        //Given
        String sentence = "the is";
        String expectResult = "the 1\nis 1";
        validate_sentence_and_convert_sentence_to_word_frequency(sentence, expectResult);
    }

    @Test
    public void should_process_two_words_with_special_spaces() throws Exception {
        //Given
        String sentence = "the      is";
        String expectResult = "the 1\nis 1";
        validate_sentence_and_convert_sentence_to_word_frequency(sentence, expectResult);
    }

    @Test
    public void should_process_two_words_with_special_enter() throws Exception {
        //Given
        String sentence = "the   \n   is";
        String expectResult = "the 1\nis 1";
        validate_sentence_and_convert_sentence_to_word_frequency(sentence, expectResult);
    }

    @Test
    public void should_process_two_same_words_with_sorted() throws Exception {
        //Given
        String sentence = "the the is";
        String expectResult = "the 2\nis 1";
        validate_sentence_and_convert_sentence_to_word_frequency(sentence, expectResult);
    }

    @Test
    public void should_process_sorted_with_count_descending() throws Exception {
        //Given
        String sentence = "the is is";
        String expectResult = "is 2\nthe 1";
        validate_sentence_and_convert_sentence_to_word_frequency(sentence, expectResult);
    }

    @Test
    public void should_return_CALCULATE_ERROR_message_with_null_input() throws Exception{
        //Given
        String sentence = null;
        String expectResult = "Calculate Error";
        validate_sentence_and_convert_sentence_to_word_frequency(sentence, expectResult);
    }

    private void validate_sentence_and_convert_sentence_to_word_frequency(String sentence, String expectResult) {
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.getWordFrequencyResult(sentence);
        //Then
        assertThat(result).isEqualTo(expectResult);
    }
}
