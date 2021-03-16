package com.example.EmailDemo;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	private FeedbackService feedbackService;
	
	
	public FeedbackController(FeedbackService feedbackService) {
		super();
		this.feedbackService = feedbackService;
	}


	@PostMapping
	public void sendFeedback(@RequestBody Feedback feedback, BindingResult bindingResult) {
		feedbackService.sendFeedback(feedback, bindingResult);
	}
}
