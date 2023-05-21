package com.example.FileSystem.constants;

public class FileSystemConstants {
    public static final String SUCCESS_RESPONSE_CODE = "000";
    public static final String SUCCESS_RESPONSE_MESSAGE = "The transaction has been ended successfully ";

    public static final String GENERAL_ERROR_RESPONSE_CODE = "001";
    public static final String GENERAL_ERROR_RESPONSE_MESSAGE = "The transaction has been failed for reason General Error";

    public static final String BUSINESS_ERROR_RESPONSE_CODE = "002";
    public static final String BUSINESS_ERROR_RESPONSE_MESSAGE = "The transaction has been failed for reason BUSINESS Error";

    public static final String BAD_ERROR_RESPONSE_CODE = "003";
    public static final String BAD_ERROR_RESPONSE_MESSAGE = "The transaction has been failed for reason BAD Request Error";

    public static final String USER_NOT_FOUND_RESPONSE_CODE = "004";
    public static final String USER_NOT_FOUND_RESPONSE_MESSAGE = "user is not found";

    public static final String PARENT_NOT_FOUND_RESPONSE_CODE = "005";
    public static final String PARENT_NOT_FOUND_RESPONSE_MESSAGE = "parent is not found";


    public static final String INVALID_PARENT_TYPE_RESPONSE_CODE = "006";
    public static final String INVALID_PARENT_TYPE_RESPONSE_MESSAGE = "invalid parent type";

    public static final String FORBIDDEN_ERROR_RESPONSE_CODE = "403";
    public static final String FORBIDDEN_ERROR_RESPONSE_MESSAGE = "user is not allowed";

}
