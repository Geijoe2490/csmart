package com.csmart.validator;

import com.csmart.delegate.BookDelegate;
import com.csmart.delegate.UserDelegate;
import com.csmart.param.BookIssueRequest;
import com.csmart.param.ValidatorRequest;
import com.csmart.param.ValidatorResponse;

/**
 * @author Shubhank Mittal (Shubhank.mittal@cdk.com)
 * @since 1.0 12/16/17.
 *
 *
 * class will validate data in issuing the book
 */
public class BookIssueValidator implements Validator {

    private UserDelegate userDelegate;

    private BookDelegate bookDelegate;

    private static final String USER_INVALID = "user is invalid or subscription is over";

    private static final String USER_SUBSCRIPTION_OVER = "user subscription is over";

    private static final String BOOK_INVALID = "Book is invalid";

    private static final String BOOK_NOT_AVAILABLE = "Book is unavailable";

    public BookIssueValidator(UserDelegate userDelegate, BookDelegate bookDelegate) {
        this.userDelegate = userDelegate;
        this.bookDelegate = bookDelegate;
    }

    @Override
    public ValidatorResponse validate(ValidatorRequest request) {

        BookIssueRequest bookIssueRequest = request.getBookIssueRequest();
        ValidatorResponse userValidationResponse = validateUser(bookIssueRequest.getUserPhoneNo());
        if (!userValidationResponse.isValid()) {
            return userValidationResponse;
        }
        ValidatorResponse bookValidationResponse = validateBook(bookIssueRequest.getIsbn());
        if (!bookValidationResponse.isValid()) {
            return bookValidationResponse;
        }
        return new ValidatorResponse(true, "");
    }

    private ValidatorResponse validateBook(String isbn) {
        if (isbn == null) {
            return new ValidatorResponse(false, BOOK_INVALID);
        } else if (bookDelegate.isAvailable(isbn)) {
            return new ValidatorResponse(false, BOOK_NOT_AVAILABLE);
        }
        return new ValidatorResponse(true, "");
    }

    private ValidatorResponse validateUser(String emailId) {
        if (emailId == null) {
            return new ValidatorResponse(false, USER_INVALID);
        } else if (userDelegate.isSubscriptionAvailable(emailId)) {
            return new ValidatorResponse(false, USER_SUBSCRIPTION_OVER);
        }
        return new ValidatorResponse(true, "");
    }
}
