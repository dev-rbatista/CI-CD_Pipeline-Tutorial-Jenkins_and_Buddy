package com.greglturnquist.payroll;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

    String firstName = "Tony";
    String lastName = "Ze";
    String description = "Enorme";
    String jobTitle = "Lord";
    String email = "tonyze@latinlover.pt";
    String INVALIDEMAIL = "Not a valid email";
    String INVALIDNAME = "Not a valid name";
    String INVALIDDESCRIPTION = "Not a valid description";
    String INVALIDJOBTITLE = "Influencer is not a valid job";

    @Test
    @DisplayName("Verify correct firstName in valid Employee instance")
    void verifyFirstNameInValidEmployee() {
        Employee newEmployee = new Employee(firstName, lastName, description, jobTitle, email);
        String expectedFirstName = "Tony";
        String result = newEmployee.getFirstName();
        assertEquals(expectedFirstName, result);
    }

    @Test
    @DisplayName("Verify correct lastName in valid Employee instance")
    void verifyLastNameInValidEmployee() {
        Employee newEmployee = new Employee(firstName, lastName, description, jobTitle, email);
        String expectedLastName = "Ze";
        String result = newEmployee.getLastName();
        assertEquals(expectedLastName, result);
    }

    @Test
    @DisplayName("Verify correct description in valid Employee instance")
    void verifyDescriptionInValidEmployee() {
        Employee newEmployee = new Employee(firstName, lastName, description, jobTitle, email);
        String description = "Enorme";
        String result = newEmployee.getDescription();
        assertEquals(description, result);
    }

    @Test
    @DisplayName("Verify correct job title in valid Employee instance")
    void verifyJobTitleInValidEmployee() {
        Employee newEmployee = new Employee(firstName, lastName, description, jobTitle, email);
        String jobTitle = "Lord";
        String result = newEmployee.getJobTitle();
        assertEquals(jobTitle, result);
    }

    @Test
    @DisplayName("Verify correct email in valid Employee instance")
    void verifyEmailInValidEmployee() {
        Employee newEmployee = new Employee(firstName, lastName, description, jobTitle, email);
        String email = "tonyze@latinlover.pt";
        String result = newEmployee.getEmail();
        assertEquals(email, result);
    }

    @DisplayName("Assert that null/empty/blank First Names are replaced by standard String")
    @ParameterizedTest
    @ValueSource(strings = {" "})
    @NullAndEmptySource
    void replaceEmptyNullAndBlankFirstNameForStandardMessage(String invalidValue){
        String expected = INVALIDNAME;
        Employee tony = new Employee(invalidValue, lastName, description, jobTitle, email);
        String result = tony.getFirstName();
        assertEquals(expected, result);
    }

    @DisplayName("Assert that null/empty/blank Last Names are replaced by standard String")
    @ParameterizedTest
    @ValueSource(strings = {" "})
    @NullAndEmptySource
    void replaceEmptyNullAndBlankLastNameForStandardMessage(String invalidValue){
        String expected = INVALIDNAME;
        Employee tony = new Employee(firstName, invalidValue, description, jobTitle, email);
        String result = tony.getLastName();
        assertEquals(expected, result);
    }

    @DisplayName("Assert that null/empty/blank Description are replaced by standard String")
    @ParameterizedTest
    @ValueSource(strings = {" "})
    @NullAndEmptySource
    void replaceEmptyNullAndBlankDescriptionForStandardMessage(String invalidValue){
        String expected = INVALIDDESCRIPTION;
        Employee tony = new Employee(firstName, lastName, invalidValue, jobTitle, email);
        String result = tony.getDescription();
        assertEquals(expected, result);
    }

    @DisplayName("Assert that null/empty/blank Job Title are replaced by standard String")
    @ParameterizedTest
    @ValueSource(strings = {" "})
    @NullAndEmptySource
    void replaceEmptyNullAndBlankJobTitleForStandardMessage(String invalidValue){
        String expected = INVALIDJOBTITLE;
        Employee tony = new Employee(firstName, lastName, description, invalidValue, email);
        String result = tony.getJobTitle();
        assertEquals(expected, result);
    }

    @DisplayName("Assert that null/empty/blank Job Title are replaced by standard String")
    @ParameterizedTest
    @ValueSource(strings = {" "})
    @NullAndEmptySource
    void replaceEmptyNullAndBlankEmailForStandardMessage(String invalidValue){
        String expected = INVALIDEMAIL;
        Employee tony = new Employee(firstName, lastName, description, jobTitle, invalidValue);
        String result = tony.getEmail();
        assertEquals(expected, result);
    }

    @DisplayName("Assert an invalid email is replaced with the error message")
    @ParameterizedTest
    @ValueSource(strings = {"tony","tony@bbc@pinterest","tony?itsme@tvtel.pt", "tony:tony@counterstrikeforever.com", "tonyverynice.underground"})
    @NullAndEmptySource
    void replaceInvalidEmailsWithStandardErrorMessage(String value) {
        String expected = INVALIDEMAIL;
        Employee employee = new Employee(firstName, lastName, description, jobTitle, value);
        String result = employee.getEmail();
        assertEquals(expected, result);
    }


}