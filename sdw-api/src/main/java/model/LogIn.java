package model;

import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ============================================================================
 * Project Name : User Authentication System
 * Class Name   : LogIn
 * Author       : Logan Hendricks
 * Date         : 2025-08-07  12:00:00
 * ----------------------------------------------------------------------------
 * Description:
 * This class represents a login model containing credentials and user type 
 * information. It supports validation and basic equality checks.
 *
 * Purpose:
 * - To store and validate login credentials.
 * - To support deserialization from JSON using Jackson annotations.
 * - To assist with login and user type verification.
 * ============================================================================
 */
@SuppressWarnings("unused")
public class LogIn {

    private static final Logger LOG = Logger.getLogger(LogIn.class.getName());
    
    static final String STRING_FORMAT = "User [username=%s, password=%s, userType=%b]";

    @JsonProperty("username") private String username;
    @JsonProperty("password") private String password;
    @JsonProperty("type") private boolean type;
    
    /**
     * Constructor for the LogIn Class.
     * 
     * @param username  -  Username for Login, Must be Between 8 and 20 Characters.
     * @param password  -  Password for Login, Must be Between 8 and 28 Characters.
     * @param type      -  Boolean Indicating User Type (True - Admin  :  False - Not).
     */
    public LogIn(@JsonProperty("username") String username, @JsonProperty("password") String password, @JsonProperty("type") boolean type) {

        this.username = username;
        this.password = password;
        this.type = type;

    }

    /**
     * Getter Function for Username.
     * 
     * @return username  -  String
     */
    public String getUsername() {

        return username;

    }
    
    /**
     * Validates the Username Based on Length Constraints.
     * 
     * @return validation  -  Message
     */
    public String checkUsername() {

        if (username.length() < 8) {

            return "Username Cannot be Less Than 8 Characters";

        } else if (username.length() > 20) {

            return "Username Cannot Exceed 20 Characters";

        } else {

            return "Valid";

        }

    }

    /**
     * Getter Function for Password.
     * 
     * @return password  -  String
     */
    public String getPassword() {

        return password;

    }

    /**
     * Validates the Password Based on Length Constraints.
     * 
     * @return validation  -  Message
     */
    public String checkPassword() {

        if (password.length() < 8) {

            return "Password Cannot be Less Than 8 Characters";

        } else if (password.length() > 28) {

            return "Password Cannot Exceed 28 Characters";

        } else {

            return "Valid";

        }

    }

    /**
     * Getter Function for Type.
     * 
     * @return type  -  Boolean
     */
    public boolean userType() {

        return type;

    }

    /**
     * Checks if Two LogIn Objects are Equal Based on Username, Password, and Type.
     * 
     * @param o  -  Object to Compare With
     * 
     * @return equals  -  Boolean
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }

        if (!(o instanceof LogIn)) {

            return false;

        }

        LogIn logIn = (LogIn) o;
        return (username == logIn.getUsername() && password == logIn.getPassword() && type == userType());

    }

    /**
     * String Representation of the LogIn Object.
     * 
     * @return "User [username=%s, password=%s, userType=%b]"  -  toString
     */
    @Override
    public String toString() {

        return String.format(STRING_FORMAT, username, password, type);

    }

}
