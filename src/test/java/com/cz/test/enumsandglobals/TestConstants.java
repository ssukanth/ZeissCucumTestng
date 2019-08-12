package com.cz.test.enumsandglobals;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
* Define Constants.
* Create a new enum Class for defining new constants
*/


@AllArgsConstructor
public enum TestConstants {
    TEST_FRAMEWORK("Api_Cucumber"),
    TEST_COUNT("test count");

    @Getter
    String cssClass;
}
