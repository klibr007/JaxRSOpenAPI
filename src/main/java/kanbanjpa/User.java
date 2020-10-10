package kanbanjpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "User")
@Entity
public class User implements Serializable{

	private Long id;
	private String name;
	private Card card;
	
	public User() {
		
	}
	
	
	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	@OneToOne
	public Card getCard() {
		return card;
	}


	public void setCard(Card card) {
		this.card = card;
	}
	
	
	
	
	
}
