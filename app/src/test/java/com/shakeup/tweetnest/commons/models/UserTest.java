package com.shakeup.tweetnest.commons.models;

import org.junit.Test;

/**
 * Created by Jayson on 9/29/2017.
 *
 * Tests for the User POJO
 */
public class UserTest {

    @Test
    public void testBiggerUrl() {
        User user = new User();
        user.setProfileImageUrlHttps(
                "https://pbs.twimg.com/profile_images/722199003845304320/s2zwEoao_normal.jpg");

        System.out.println(user.getProfileImageUrlHttpsOriginal());
    }

}