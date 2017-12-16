package com.csmart.service;

import com.csmart.dao.BookIssueDao;
import com.csmart.param.BookIssueDetail;
import com.csmart.param.BookIssueRequest;
import com.csmart.param.ValidatorRequest;
import com.csmart.param.ValidatorResponse;
import com.csmart.validator.Validator;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

/**
 * @author Shubhank Mittal (Shubhank.mittal@cdk.com)
 * @since 1.0 12/16/17.
 */
public class BookIssueServiceImpl implements BookIssueService {

    private Validator validator;

    private BookIssueDao dao;

    public BookIssueServiceImpl(Validator bookIssueValidator, BookIssueDao dao) {
        this.validator=bookIssueValidator;
        this.dao = dao;
    }

    @Override
    public void issue(BookIssueRequest bookIssueRequest) throws Exception {
        ValidatorRequest validatorRequest= new ValidatorRequest();
        validatorRequest.setBookIssueRequest(bookIssueRequest);
        ValidatorResponse validatorResponse=validator.validate(validatorRequest);
        if(!validatorResponse.isValid()){
            throw new Exception(validatorResponse.getMessage());
        }
        BookIssueDetail bookIssueDetail= new BookIssueDetail();
        bookIssueDetail.setIsbn(bookIssueRequest.getIsbn());
        bookIssueDetail.setUserPhoneNo(bookIssueRequest.getUserPhoneNo());
        bookIssueDetail.setDateOfIssue(new Date().toString());
        dao.issue(bookIssueDetail);
    }

    @Override
    public List<BookIssueDetail> booksByUser(String userPhoneNo) throws UnknownHostException {
        return dao.booksByUser(userPhoneNo);
    }

    @Override
    public List<BookIssueDetail> bookHistoryByUser(String isbn,String userPhoneNo) throws UnknownHostException {
        return dao.bookHistoryByUser(isbn,userPhoneNo);
    }
}
