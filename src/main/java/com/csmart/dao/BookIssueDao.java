package com.csmart.dao;

import com.csmart.param.BookIssueDetail;
import com.csmart.param.BookIssueRequest;

import java.net.UnknownHostException;
import java.util.List;

/**
 * @author Shubhank Mittal (Shubhank.mittal@cdk.com)
 * @since 1.0 12/16/17.
 */
public interface BookIssueDao {

    void issue(BookIssueDetail bookIssueDetail) throws UnknownHostException;

    List<BookIssueDetail> booksByUser(String userPhoneNo) throws UnknownHostException;

    List<BookIssueDetail> bookHistoryByUser(String isbn,String userPhoneNo) throws UnknownHostException;
}
