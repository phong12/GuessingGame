package com.collegeboard.guess;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GuessingGameTest {

    @Test
    public void testGetAvailableReadyAnswers() throws Exception {
        GuessingGame instance = new GuessingGame();
        List<String> answers = instance.getAvailableAnswers();
        Assert.assertTrue(answers.contains(UserAnswerEnum.Ready.getValue()));
    }

    @Test
    public void testGetAvailableOtherAnswers() throws Exception {
        GuessingGame instance = new GuessingGame();
        instance.setGameStarted(true);
        List<String> answers = instance.getAvailableAnswers();
        Assert.assertFalse(answers.contains(UserAnswerEnum.Ready.getValue()));
        Assert.assertTrue(answers.contains(UserAnswerEnum.Lower.getValue()));
        Assert.assertTrue(answers.contains(UserAnswerEnum.Higher.getValue()));
        Assert.assertTrue(answers.contains(UserAnswerEnum.Yes.getValue()));
    }

    @Test
    public void testUserAnswerReady() throws Exception {
        GuessingGame instance = new GuessingGame();
        ConsoleReader reader = mock(ConsoleReader.class);
        instance.setReader(reader);

        when(reader.getInput()).thenReturn("ready");
        Assert.assertEquals(UserAnswerEnum.Ready, instance.userAnswer());
    }

    @Test
    public void testUserAnswerInvalidThenReady() throws Exception {
        GuessingGame instance = new GuessingGame();
        ConsoleReader reader = mock(ConsoleReader.class);
        instance.setReader(reader);

        when(reader.getInput()).thenReturn("invalid", "ready");
        Assert.assertEquals(UserAnswerEnum.Ready, instance.userAnswer());

        verify(reader, times(2)).getInput();
    }

    @Test
    public void testProcessAnswer() throws Exception {
        GuessingGame instance = new GuessingGame();
        instance.processAnswer(UserAnswerEnum.Ready);
        Assert.assertTrue(instance.isGameStarted());
    }

    @Test
    public void testMakeGuess() throws Exception {
        // TODO: Create a next guess interface so we can test using mock
    }

    @Test
    public void testNextHighGuess() throws Exception {
        // TODO: Create a next guess interface so we can test using mock
    }

    @Test
    public void testNextLowGuess() throws Exception {
        // TODO: Create a next guess interface so we can test using mock
    }

}