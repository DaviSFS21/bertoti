package entities;

import org.junit.Assert;
import org.junit.Test;

public class FractionUtilsTest {
    @Test
    public void FindLCMTest() {
        Assert.assertEquals(12, FractionUtils.findLCM(3,4));
        Assert.assertEquals(12, FractionUtils.findLCM(6,4));
        Assert.assertEquals(35, FractionUtils.findLCM(5,7));
    }

    @Test
    public void FindGCDTest() {
        Assert.assertEquals(4, FractionUtils.findGCD(24,28));
        Assert.assertEquals(36, FractionUtils.findGCD(36,72));
        Assert.assertEquals(2, FractionUtils.findGCD(2,28));
        Assert.assertEquals(1, FractionUtils.findGCD(3,7));
    }
}
