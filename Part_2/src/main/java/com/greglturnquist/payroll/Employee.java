/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import java.util.Objects;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Entity // <1>
public class Employee {

    private @Id
    @GeneratedValue
    Long id; // <2>
    private String firstName;
    private String lastName;
    private String description;
    private String jobTitle;
    private String email;
    private final String INVALIDEMAIL = "Not a valid email";
    private final String INVALIDNAME = "Not a valid name";
    private final String INVALIDDESCRIPTION = "Not a valid description";
    private final String INVALIDJOBTITLE = "Influencer is not a valid job";


    public Employee(String firstName, String lastName, String description, String jobTitle, String email) {
        verifyFirstName(firstName);
        verifyLastName(lastName);
        verifyDescription(description);
        verifyJobTitle(jobTitle);
        verifyEmail(email);
    }

    public Employee() {
    }

    public void verifyEmail(String email) {
        if (validateEmail(email)) {
            this.email = email;
        } else {
            this.email = INVALIDEMAIL;
        }
    }

    public void verifyFirstName(String name) {
        if (validateName(name)) {
            this.firstName = name;
        } else {
            this.firstName = INVALIDNAME;
        }
    }

    public void verifyLastName(String name) {
        if (validateName(name)) {
            this.lastName = name;
        } else {
            this.lastName = INVALIDNAME;
        }
    }

    public void verifyDescription(String description) {
        if (validateDescription(description)) {
            this.description = description;
        } else {
            this.description = INVALIDDESCRIPTION;
        }
    }

    public void verifyJobTitle(String jobTitle) {
        if (validateJobTitle(jobTitle)) {
            this.jobTitle = jobTitle;
        } else {
            this.jobTitle = INVALIDJOBTITLE;
        }
    }

    //Field validations

    /**
     * Added validation for non-empty, non-null or non-blank emails.
     * Included regex verification in a posterior moment to the first validation
     * @param email
     * @return
     */
    public boolean validateEmail(String email) {
        boolean valid;
        if (email == null || email.isEmpty() || email.trim().length() == 0) {
            valid = false;
        } else {
            String emailRegex = "[A-Z0-9a-z._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}";
            Pattern pat = Pattern.compile(emailRegex);
            valid = pat.matcher(email).matches();
        }
        return valid;
    }

    private boolean validateName(String name) {
        boolean valid;
        if (name == null || name.isEmpty() || name.trim().length() == 0) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    private boolean validateDescription(String description) {
        boolean valid;
        if (description == null || description.isEmpty() || description.trim().length() == 0) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    private boolean validateJobTitle(String jobTitle) {
        boolean valid;
        if (jobTitle == null || jobTitle.isEmpty() || jobTitle.trim().length() == 0) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }




	/*
	Regex validation for email


	*/


    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(description, employee.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
// end::code[]
