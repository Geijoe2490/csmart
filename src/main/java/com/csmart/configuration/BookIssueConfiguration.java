package com.csmart.configuration;

import com.csmart.dao.BookIssueDao;
import com.csmart.dao.BookIssueMongoDAO;
import com.csmart.dao.MongoConnection;
import com.csmart.delegate.BookDelegate;
import com.csmart.delegate.UserDelegate;
import com.csmart.service.BookIssueService;
import com.csmart.service.BookIssueServiceImpl;
import com.csmart.validator.BookIssueValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Shubhank Mittal (Shubhank.mittal@cdk.com)
 * @since 1.0 12/16/17.
 */

@Configuration
public class BookIssueConfiguration {

    @Bean
    public BookIssueService bookIssueService(BookIssueValidator bookIssueValidator, BookIssueDao bookIssueDao) {
        return new BookIssueServiceImpl(bookIssueValidator, bookIssueDao);
    }

    @Bean
    public BookIssueDao bookIssueDao(MongoConnection connection) {
        return new BookIssueMongoDAO(connection);
    }

    @Bean
    public BookIssueValidator bookIssueValidator(UserDelegate userDelegate, BookDelegate bookDelegate) {
        return new BookIssueValidator(userDelegate, bookDelegate);
    }

    @Bean
    public UserDelegate userDelegate() {
        return new UserDelegate();
    }

    @Bean
    public BookDelegate bookDelegate() {
        return new BookDelegate();
    }

    @Bean
    public MongoConnection mongoConnection() {
        return new MongoConnection();
    }
}
