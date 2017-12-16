package com.csmart.param;

/**
 * @author Shubhank Mittal (Shubhank.mittal@cdk.com)
 * @since 1.0 12/16/17.
 */
public class ValidatorResponse {

    private boolean valid;

    private String message;

    public ValidatorResponse(boolean valid , String message ){
        this.valid=valid;
        this.message=message;
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }
}
