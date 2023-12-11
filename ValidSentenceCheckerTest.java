import org.junit.Test;
import static org.junit.Assert.*;
public class ValidSentenceCheckerTest {

    @Test
    public void validSentenceTest(){
        assertTrue(ValidSentenceChecker.isValidSentence("The quick brown fox said \"hello Mr lazy dog\"."));
        assertTrue(ValidSentenceChecker.isValidSentence("How many \"lazy dogs\" are there?"));
        assertTrue(ValidSentenceChecker.isValidSentence("One lazy dog is too few, thirteen is too many."));
    }

    @Test
    public void invalidSentenceTest(){
        assertFalse(ValidSentenceChecker.isValidSentence(null));
        assertFalse(ValidSentenceChecker.isValidSentence(""));
        assertFalse(ValidSentenceChecker.isValidSentence("noCapital"));
        assertFalse(ValidSentenceChecker.isValidSentence("This sentence has an odd number of quotation marks \""));
        assertFalse(ValidSentenceChecker.isValidSentence("Invalid termination character;"));
        assertFalse(ValidSentenceChecker.isValidSentence("Too many periods in this sentence..."));
    }

    @Test
    public void validSentenceEdgeCasesTest(){
        assertTrue(ValidSentenceChecker.isValidSentence("A."));
        assertTrue(ValidSentenceChecker.isValidSentence("This is a valid sentence!"));
    }

    @Test
    public void invalidSentenceEdgeCasesTest(){
        assertFalse(ValidSentenceChecker.isValidSentence("."));
        assertFalse(ValidSentenceChecker.isValidSentence("Invalid termination character here: ;"));
        assertFalse(ValidSentenceChecker.isValidSentence("Numbers below 13 are not spelled out: 12"));
    }
}
