package com.csmart.controller;

import com.csmart.param.BookIssueDetail;
import com.csmart.param.BookIssueRequest;
import com.csmart.service.BookIssueService;
import com.wordnik.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author Shubhank Mittal (Shubhank.mittal@cdk.com)
 * @since 1.0 12/16/17.
 */

@RestController
public class BookIssueController {

    @Resource
    private BookIssueService service;

    @RequestMapping(value = "/issueBooks", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "issue a book")
    public ResponseEntity issue(@ApiParam(value = "Book Issue details") @RequestBody BookIssueRequest request) {
        try {
            service.issue(request);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(CREATED);
    }

    @RequestMapping(value = "/issueBooks/user/{userPhoneNo}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Book Issue details")
    public ResponseEntity<BookIssueDetail> booksDetailByUser(@ApiParam(value = "User Email ID") @PathVariable("userPhoneNo") String userPhoneNo) {
        try {
            return new ResponseEntity(service.booksByUser(userPhoneNo), OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/issueBooks/{isbn}/user/{userPhoneNo}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Book Issue History")
    public ResponseEntity<BookIssueDetail> bookHistoryByUser(@ApiParam(value = "Book isbn number") @PathVariable("isbn") String isbn,
                                                             @ApiParam(value = "Book Issue History") @PathVariable("userEmailId") String userPhoneNo) {
        try {
            return new ResponseEntity(service.bookHistoryByUser(isbn, userPhoneNo), OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
