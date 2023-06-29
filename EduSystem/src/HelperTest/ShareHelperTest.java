package HelperTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Helper.ShareHelper;

import java.io.File;

public class ShareHelperTest {

    @Test
    public void testSaveLogo() {
        File testFile = new File("Add.png");
        boolean result = ShareHelper.saveLogo(testFile);
        Assert.assertTrue(result);
        testFile.delete();
    }
}

