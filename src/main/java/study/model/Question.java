package study.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Question {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(targetEntity = User.class)
	private Long writer;
	private String title;
	@Lob
	private String contents;
	private Date datetime;

	public Question() {
	}

	public Question(String title, String contents, Date datetime) {
		this.title = title;
		this.contents = contents;
		this.datetime = datetime;
	}
}
