package com.csmart.validator;

import com.csmart.param.ValidatorRequest;
import com.csmart.param.ValidatorResponse;

/**
 * @author Shubhank Mittal (Shubhank.mittal@cdk.com)
 * @since 1.0 12/16/17.
 */
public interface Validator {

     ValidatorResponse validate(ValidatorRequest request);
}
