package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "sms")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SMS implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	public long id;

	@Column(name = "numberfrom")
	public String numberFrom;

	@Column(name = "numberto")
	public String numberTo;

	@Column(name = "message")
	public String message;

	@Column(name = "date")
	public Date date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumberFrom() {
		return numberFrom;
	}

	public void setNumberFrom(String numberFrom) {
		this.numberFrom = numberFrom;
	}

	public String getNumberTo() {
		return numberTo;
	}

	public void setNumberTo(String numberTo) {
		this.numberTo = numberTo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
