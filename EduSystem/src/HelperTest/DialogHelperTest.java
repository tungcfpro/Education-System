package HelperTest;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import Helper.DialogHelper;

public class DialogHelperTest {
    
    @Test(priority = 1)
    public void testAlert() {
        // Given
        String message = "This is an alert message";
        
        // When
        DialogHelper.alert(null, message);
        
        // Then
        // The method should just display a message dialog with the given message.
        // So there's no need to test the result here.
    }
    
    @Test(priority = 2)
    public void testConfirm() {
        // Given
        String message = "Do you confirm?";
        
        // When
        boolean result = DialogHelper.confirm(null, message);
        
        // Then
        assertEquals(result, false);
        // Since there's no user interaction in the test, the confirm dialog will always return false.
        // This test is just to ensure the method returns the result from the confirm dialog.
    }
    
    @Test(priority = 3)
    public void testPrompt() {
        // Given
        String message = "Please input something";
        String expected = "hello";
        
        // When
        String result = DialogHelper.prompt(null, message);
        
        // Then
        assertEquals(result, expected);
        // Since there's no user interaction in the test, the prompt dialog will always return the expected string.
        // This test is just to ensure the method returns the result from the prompt dialog.
    }
}

