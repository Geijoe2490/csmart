package com.csmart.delegate;

/**
 * @author Shubhank Mittal (Shubhank.mittal@cdk.com)
 * @since 1.0 12/16/17.
 */

/*
* class to hit user service to fetch user information i.e. check whether subscription ended or not
* */
public class UserDelegate {

    public boolean isSubscriptionAvailable(String emailId){
        return true;
    }
}
