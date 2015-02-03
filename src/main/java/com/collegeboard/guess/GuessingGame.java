package com.collegeboard.guess;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * A number-guessing game. The game works as follows:
 * The user chooses a number in his mind and types “ready” to indicate to the computer that he is ready to begin playing.
 * The computer asks a series of questions to arrive at the number the user has in mind.
 * The user can only respond with “higher”, “lower” or “yes”.
 * The game ends when the user responds with “yes” or “end”.
 */
public class GuessingGame {
    private static final int INITIAL_GUESS = 1000;
    private static final int GUESS_MULTIPLIER = 2;

    private boolean gameStarted;
    private int lowerGuess;
    private int highGuess;
    private int lastGuess;
    private ConsoleReader reader;

    /**
     * Create a new game.
     */
    public GuessingGame() {
        lowerGuess = Integer.MIN_VALUE;
        highGuess = Integer.MAX_VALUE;
        lastGuess = 0;
        reader = new ConsoleReader();
    }

    /**
     * Return a list of available answer for the current game state.
     * @return list of possible user answers
     */
    public List<String> getAvailableAnswers() {
        if (gameStarted) {
            return Arrays.asList(UserAnswerEnum.Higher.getValue(),
                    UserAnswerEnum.Lower.getValue(),
                    UserAnswerEnum.Yes.getValue(),
                    UserAnswerEnum.End.getValue());
        } else {
            return Arrays.asList(UserAnswerEnum.Ready.getValue(), UserAnswerEnum.End.getValue());
        }
    }

    /**
     * Display error message and ask user for another  answer.
     * @param possibleAnswers available answers
     * @return user answer
     */
    private UserAnswerEnum askAgain(final List<String> possibleAnswers) {
        System.out.println("Invalid entry. Available choices [" + StringUtils.join(possibleAnswers, ",") + "]");
        return userAnswer();
    }

    /**
     * Repeatedly ask the user for an answer until a valid one is given.
     */
    public UserAnswerEnum userAnswer() {
        String answer = reader.getInput();
        List<String> possibleAnswers = getAvailableAnswers();
        try {
            UserAnswerEnum answerEnum = UserAnswerEnum.toEnum(answer);
            if (!possibleAnswers.contains(answerEnum.getValue())) {
                return askAgain(possibleAnswers);
            } else {
                return answerEnum;
            }
        } catch (IllegalArgumentException e) {
            return askAgain(possibleAnswers);
        }
    }

    /**
     * Process the user answer.
     * @param answer user answer
     */
    public void processAnswer(final UserAnswerEnum answer) {
        if (answer == UserAnswerEnum.Ready) {
            gameStarted = true;
        }
        makeGuess(answer);
    }

    /**
     * Make a guess based on the user answer.
     * @param answer user answer
     */
    public void makeGuess(final UserAnswerEnum answer) {
        if (answer == UserAnswerEnum.Ready) {
            lastGuess = INITIAL_GUESS;
        } else if (answer == UserAnswerEnum.Higher) {
            lowerGuess = lastGuess;
            lastGuess = nextHighGuess();
        } else if (answer == UserAnswerEnum.Lower) {
            highGuess = lastGuess;
            lastGuess = nextLowGuess();
        } else if (answer == UserAnswerEnum.Yes) {
            // Found it!
            return;
        } else if (answer == UserAnswerEnum.End) {
            // Had enough
            return;
        }
        System.out.println("Computer: Is the number " + lastGuess + "?");
    }

    /**
     * Try to make a higher guess.
     * @return new guess
     */
    public int nextHighGuess() {
        int nextGuess = lastGuess * GUESS_MULTIPLIER;
        if (nextGuess < highGuess) {
            return nextGuess;
        } else {
            nextGuess = lastGuess + ((highGuess - lastGuess) / GUESS_MULTIPLIER);
            if (nextGuess == lastGuess) {
                nextGuess++;
            }
            return nextGuess;
        }
    }

    /**
     * Try to make a lower guess.
     * @return new guess
     */
    public int nextLowGuess() {
        int nextGuess = lastGuess / GUESS_MULTIPLIER;
        if (nextGuess > lowerGuess) {
            return nextGuess;
        } else {
            nextGuess = lastGuess - ((lastGuess - lowerGuess) / GUESS_MULTIPLIER);
            if (nextGuess == lastGuess) {
                nextGuess--;
            }
            return nextGuess;
        }
    }

    public static void main(String[] args) {
        UserAnswerEnum answer = null;
        GuessingGame game = new GuessingGame();

        System.out.println("A number guessing game.  Type 'ready' to begin'");
        while (answer != UserAnswerEnum.Yes && answer != UserAnswerEnum.End) {
            answer = game.userAnswer();
            game.processAnswer(answer);
        }
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public int getLowerGuess() {
        return lowerGuess;
    }

    public void setLowerGuess(int lowerGuess) {
        this.lowerGuess = lowerGuess;
    }

    public int getHighGuess() {
        return highGuess;
    }

    public void setHighGuess(int highGuess) {
        this.highGuess = highGuess;
    }

    public int getLastGuess() {
        return lastGuess;
    }

    public void setLastGuess(int lastGuess) {
        this.lastGuess = lastGuess;
    }

    public ConsoleReader getReader() {
        return reader;
    }

    public void setReader(ConsoleReader reader) {
        this.reader = reader;
    }
}
