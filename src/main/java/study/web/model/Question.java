package study.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String writer;

	@Column
	private String title;

	@Column
	private String contents;

	@Column
	private Date datetime;
	
	@Column
	private int point;

	public void setId(Long id) {
		this.id = id;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
}
