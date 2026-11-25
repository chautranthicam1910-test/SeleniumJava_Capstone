package com.automation.utils;

import net.datafaker.Faker;

public class RandomDataUtils {
    private static final Faker faker = new Faker();

    public static String getRandomUsername() {

        return faker.name().username().replace(".", "") + faker.number().digits(3);
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword() {
        return faker.internet().password(8, 12, true, true, true);
    }

    public static String getRandomFullName() {
        return faker.name().fullName();
    }
}
