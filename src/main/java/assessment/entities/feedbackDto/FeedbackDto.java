package assessment.entities.feedbackDto;

import assessment.entities.review.Review;

import java.util.Date;

/**
 * Created by jtucker on 5/11/2016.
 */
public class FeedbackDto {

	private String templateId;

	private String avatar;

	private String firstName;

	private String lastName;

	private String templateName;

	private Review review;

	public FeedbackDto() {}

	public FeedbackDto(String templateId, String avatar, String firstName, String lastName, String templateName, Review review) {
		this.templateId = templateId;
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.templateName = templateName;
		this.review = review;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
}
