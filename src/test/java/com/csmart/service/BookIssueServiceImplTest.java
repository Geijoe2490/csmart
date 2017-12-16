package com.csmart.service;

import com.csmart.dao.BookIssueDao;
import com.csmart.param.BookIssueRequest;
import com.csmart.param.ValidatorResponse;
import com.csmart.validator.Validator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.UnknownHostException;

import static org.mockito.Mockito.*;

/**
 * @author Shubhank Mittal (Shubhank.mittal@cdk.com)
 * @since 1.0 12/16/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class BookIssueServiceImplTest {

    private BookIssueService bookIssueService;

    @Mock
    private Validator validator;

    @Mock
    private BookIssueDao bookIssueDao;

    private BookIssueRequest request;

    private static final String USER_EMAIL="shubhank@gmail.com";

    private static final String ISBN="A2344";

    @Before
    public void setUp() throws UnknownHostException {
        bookIssueService = spy(new BookIssueServiceImpl(validator, bookIssueDao));
        request = new BookIssueRequest();
        request.setIsbn(ISBN);
        request.setUserPhoneNo(USER_EMAIL);
        doNothing().when(bookIssueDao).issue(any());
    }


    @Test
    public void testIssue() throws Exception {
        when(validator.validate(any())).thenReturn(new ValidatorResponse(true, ""));
        doNothing().when(bookIssueDao).issue(any());
        bookIssueService.issue(request);
        verify(validator, times(1)).validate(any());
        verify(bookIssueDao, times(1)).issue(any());
    }

    @Test(expected = Exception.class)
    public void testIssueWhenDataInvalid() throws Exception {
        when(validator.validate(any())).thenReturn(new ValidatorResponse(false, ""));
        bookIssueService.issue(any());
    }

    @Test
    public void testBooksByUser() throws Exception {
        bookIssueService.booksByUser(USER_EMAIL);
        verify(bookIssueDao, times(1)).booksByUser(any());
    }

    @Test
    public void testBookHistoryByUser() throws Exception {
        bookIssueService.bookHistoryByUser(ISBN,USER_EMAIL);
        verify(bookIssueDao, times(1)).bookHistoryByUser(anyString(),anyString());
    }

}