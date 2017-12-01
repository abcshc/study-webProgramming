package study.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(targetEntity = User.class)
	private Long answer;

	@ManyToOne(targetEntity = Question.class)
	private Long question;

	@Lob
	private String contents;
	private Date regDate;

}
