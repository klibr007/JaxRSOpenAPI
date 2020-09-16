package kanbanjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement(name = "User")
public class User {

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
	@XmlElement
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@XmlElement
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@OneToOne
	@XmlElement
	public Card getCard() {
		return card;
	}


	public void setCard(Card card) {
		this.card = card;
	}
	
	
	
	
	
}
