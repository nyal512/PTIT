package com.example.ptit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)

public class LoginActivityTest {

    @Test
    public void testCheckLoginFieldsWithBlankUsername() {
        LoginActivity loginActivity = new LoginActivity();
        String username = "";
        String password = "123456";
        int expectedWarningIndex = 0;
        int actualWarningIndex = loginActivity.checkLoginFields(username, password);
        assertEquals(expectedWarningIndex, actualWarningIndex);
    }

    @Test
    public void testCheckLoginFieldsWithBlankPassword() {
        LoginActivity loginActivity = new LoginActivity();
        String username = "user123";
        String password = "";
        int expectedWarningIndex = 1;
        int actualWarningIndex = loginActivity.checkLoginFields(username, password);
        assertEquals(expectedWarningIndex, actualWarningIndex);
    }

    @Test
    public void testCheckLoginFieldsWithBlankUsernameAndPassword() {
        LoginActivity loginActivity = new LoginActivity();
        String username = "";
        String password = "";
        int expectedWarningIndex = 2;
        int actualWarningIndex = loginActivity.checkLoginFields(username, password);
        assertEquals(expectedWarningIndex, actualWarningIndex);
    }

    @Test
    public void testCheckLoginFieldsWithValidInput() {
        LoginActivity loginActivity = new LoginActivity();
        String username = "user123";
        String password = "123456";
        int expectedWarningIndex = -1;
        int actualWarningIndex = loginActivity.checkLoginFields(username, password);
        assertEquals(expectedWarningIndex, actualWarningIndex);
    }
}