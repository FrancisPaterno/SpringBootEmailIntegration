package com.example.EmailDemo;

import org.springframework.validation.BindingResult;

public interface FeedbackDAO {

	void sendFeedback(Feedback feedBack, BindingResult bindingResult);
}
