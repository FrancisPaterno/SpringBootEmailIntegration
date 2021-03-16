package com.example.EmailDemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FeedbackService {
	
	private FeedbackDAO feedbackDao;
	
	public FeedbackService(@Qualifier("mailtrap") FeedbackDAO feedbackDao) {
		super();
		this.feedbackDao = feedbackDao;
	}


	public void sendFeedback(@RequestBody Feedback feedback, BindingResult bindingResult) {
		feedbackDao.sendFeedback(feedback, bindingResult);
	}
}
