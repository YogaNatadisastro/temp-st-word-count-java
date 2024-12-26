import com.github.affandes.kuliah.st.WordCount;
import com.github.affandes.kuliah.st.WordInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordCountTest {
    private WordCount wordCount;

    @BeforeEach
    public void setUp() {
        wordCount = new WordCount();
    }

    @Test
    public void testWordCountWithSingleWord() {
        wordCount.wordCount("hello");

        List<WordInfo> result = wordCount.wordCount;
        assertEquals(1, result.size(), "There should be one word");
        assertEquals("hello", result.get(0).word, "The word should be 'hello'");
        assertEquals(1, result.get(0).count, "The count should be 1");
    }

    @Test
    public void testWordCountWithMultipleWords() {
        wordCount.wordCount("hello world hello");

        List<WordInfo> result = wordCount.wordCount;
        result.sort(Comparator.comparing(WordInfo::getWord));
        assertEquals(2, result.size(), "There should be two distinct words");
        //
        assertEquals("hello", result.get(0).word, "The first word should be 'hello'");
        assertEquals(2, result.get(0).count, "The count for 'hello' should be 2");
        assertEquals("world", result.get(1).word, "The second word should be 'world'");
        assertEquals(1, result.get(1).count, "The count for 'world' should be 1");
    }

    @Test
    public void testWordCountWithEmptyString() {
        wordCount.wordCount("");

        List<WordInfo> result = wordCount.wordCount;
        assertTrue(result.isEmpty(), "The word count list should be empty for an empty string");
    }

    @Test
    public void testWordCountWithSpaces() {
        wordCount.wordCount("    ");

        List<WordInfo> result = wordCount.wordCount;
        assertTrue(result.isEmpty(), "The word count list should be empty for a string with only spaces");
    }

}
