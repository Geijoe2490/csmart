package com.csmart.service;

import com.csmart.param.BookIssueDetail;
import com.csmart.param.BookIssueRequest;

import java.net.UnknownHostException;
import java.util.List;

/**
 * @author Shubhank Mittal (Shubhank.mittal@cdk.com)
 * @since 1.0 12/16/17.
 */


public interface BookIssueService {

    void issue(BookIssueRequest request) throws Exception;

    List<BookIssueDetail> booksByUser(String userPhoneNo) throws UnknownHostException;

    List<BookIssueDetail> bookHistoryByUser(String isbn,String userPhoneNo) throws UnknownHostException;
}
