package com.collegeboard.guess;

import org.junit.Assert;
import org.junit.Test;

public class UserAnswerEnumTest {

    @Test
    public void testHigherValue() throws Exception {
        Assert.assertEquals(UserAnswerEnum.Higher.getValue(), "higher");
    }

    @Test
    public void testLowerValue() throws Exception {
        Assert.assertEquals(UserAnswerEnum.Lower.getValue(), "lower");
    }

    @Test
    public void testYesValue() throws Exception {
        Assert.assertEquals(UserAnswerEnum.Yes.getValue(), "yes");
    }

    @Test
    public void testEndValue() throws Exception {
        Assert.assertEquals(UserAnswerEnum.End.getValue(), "end");
    }

    @Test
    public void testReadyValue() throws Exception {
        Assert.assertEquals(UserAnswerEnum.Ready.getValue(), "ready");
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertEquals(UserAnswerEnum.Yes.getValue(), "yes");
    }

    @Test
    public void testToHigherEnum() throws Exception {
        Assert.assertEquals(UserAnswerEnum.toEnum("higher"), UserAnswerEnum.Higher);
    }

    @Test
    public void testToLowerEnum() throws Exception {
        Assert.assertEquals(UserAnswerEnum.toEnum("lower"), UserAnswerEnum.Lower);
    }

    @Test
    public void testToYesEnum() throws Exception {
        Assert.assertEquals(UserAnswerEnum.toEnum("yes"), UserAnswerEnum.Yes);
    }

    @Test
    public void testToReadyEnum() throws Exception {
        Assert.assertEquals(UserAnswerEnum.toEnum("ready"), UserAnswerEnum.Ready);
    }

    @Test
    public void testToHigherEnumIgnoreCase() throws Exception {
        Assert.assertEquals(UserAnswerEnum.toEnum("Higher"), UserAnswerEnum.Higher);
    }

    @Test
    public void testToLowerEnumIgnoreCase() throws Exception {
        Assert.assertEquals(UserAnswerEnum.toEnum("lOwEr"), UserAnswerEnum.Lower);
    }

    @Test
    public void testToYesEnumIgnoreCase() throws Exception {
        Assert.assertEquals(UserAnswerEnum.toEnum("YES"), UserAnswerEnum.Yes);
    }

    @Test
    public void testToReadyEnumIgnoreCase() throws Exception {
        Assert.assertEquals(UserAnswerEnum.toEnum("Ready"), UserAnswerEnum.Ready);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testToInvalidEnum() throws Exception {
        Assert.assertEquals(UserAnswerEnum.toEnum("wrong answer"), UserAnswerEnum.Yes);
    }
}