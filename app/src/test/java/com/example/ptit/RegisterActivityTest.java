package com.example.ptit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
public class RegisterActivityTest {

    @Test
    public void testCheckRegistrationFieldsWithBlankUsername() {
        RegisterActivity registerActivity = new RegisterActivity();
        String username = "";
        String password = "123456";
        int expectedWarningIndex = 0;
        int actualWarningIndex = registerActivity.checkRegistrationFields(username, password);
        assertEquals(expectedWarningIndex, actualWarningIndex);
    }

    @Test
    public void testCheckRegistrationFieldsWithBlankPassword() {
        RegisterActivity registerActivity = new RegisterActivity();
        String username = "user123";
        String password = "";
        int expectedWarningIndex = 1;
        int actualWarningIndex = registerActivity.checkRegistrationFields(username, password);
        assertEquals(expectedWarningIndex, actualWarningIndex);
    }

    @Test
    public void testCheckRegistrationFieldsWithBlankUsernameAndPassword() {
        RegisterActivity registerActivity = new RegisterActivity();
        String username = "";
        String password = "";
        int expectedWarningIndex = 0;
        int actualWarningIndex = registerActivity.checkRegistrationFields(username, password);
        assertEquals(expectedWarningIndex, actualWarningIndex);
    }

    @Test
    public void testCheckRegistrationFieldsWithInvalidUsername() {
        RegisterActivity registerActivity = new RegisterActivity();
        String username = "abc";
        String password = "123456";
        int expectedWarningIndex = 2;
        int actualWarningIndex = registerActivity.checkRegistrationFields(username, password);
        assertEquals(expectedWarningIndex, actualWarningIndex);
    }

    @Test
    public void testCheckRegistrationFieldsWithShortPassword() {
        RegisterActivity registerActivity = new RegisterActivity();
        String username = "user123";
        String password = "12";
        int expectedWarningIndex = 3;
        int actualWarningIndex = registerActivity.checkRegistrationFields(username, password);
        assertEquals(expectedWarningIndex, actualWarningIndex);
    }

    @Test
    public void testCheckRegistrationFieldsWithValidInput() {
        RegisterActivity registerActivity = new RegisterActivity();
        String username = "user123";
        String password = "123456";
        int expectedWarningIndex = -1;
        int actualWarningIndex = registerActivity.checkRegistrationFields(username, password);
        assertEquals(expectedWarningIndex, actualWarningIndex);
    }
}