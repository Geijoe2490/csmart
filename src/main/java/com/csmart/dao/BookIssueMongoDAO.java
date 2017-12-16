package com.csmart.dao;

import com.csmart.param.BookIssueDetail;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.net.UnknownHostException;
import java.util.List;

/**
 * @author Shubhank Mittal (Shubhank.mittal@cdk.com)
 * @since 1.0 12/16/17.
 */
public class BookIssueMongoDAO implements BookIssueDao {

    private MongoConnection connection;

    public BookIssueMongoDAO(MongoConnection connection) {
        this.connection = connection;
    }

    @Override
    public void issue(BookIssueDetail bookIssueDetail) throws UnknownHostException {
        MongoTemplate template = new MongoTemplate(connection.getMongoFactory());
        template.save(bookIssueDetail, "bookIssueDetail");
    }

    @Override
    public List<BookIssueDetail> booksByUser(String userPhoneNo) throws UnknownHostException {
        MongoTemplate template = new MongoTemplate(connection.getMongoFactory());
        Query query = new Query();
        query.addCriteria(Criteria.where("userPhoneNo").is(userPhoneNo));
        return template.find(query, BookIssueDetail.class, "bookIssueDetail");
    }

    @Override
    public List<BookIssueDetail> bookHistoryByUser(String isbn,String userPhoneNo) throws UnknownHostException {
        MongoTemplate template = new MongoTemplate(connection.getMongoFactory());
        Query query = new Query();
        query.addCriteria(Criteria.where("userPhoneNo").is(userPhoneNo));
        query.addCriteria(Criteria.where("isbn").is(isbn));
        return template.find(query, BookIssueDetail.class, "bookIssueDetail");
    }

}
