package com.automation.constants;

import com.automation.utils.TestDataReader;

public class TestData {

    public static final String VALID_USERNAME = TestDataReader.get("valid.username");
    public static final String INVALID_USERNAME = TestDataReader.get("invalid.username");

    public static final String VALID_PASSWORD = TestDataReader.get("valid.password");
    public static final String INVALID_PASSWORD = TestDataReader.get("invalid.password");

    public static final String VALID_FULLNAME = TestDataReader.get("valid.fullname");

    public static final String VALID_EMAIL = TestDataReader.get("valid.email");

    public static final String DEFAULT_MOVIE = "AVATAR 2";
    public static final String CINEMA_BRAND = "cgv";
    public static final String CINEMA_BRANCH = "CGV - Golden Plaza";

}