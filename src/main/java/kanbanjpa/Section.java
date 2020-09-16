package kanbanjpa;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Section {

	private Long id;
	private String name;
	private List<Card> cards;
	private Board board;
	
	public Section() {
		
	}
	
	

	public Section(Long id, String name, List<Card> cards, Board board) {
		super();
		this.id = id;
		this.setName(name);
		this.cards = cards;
		this.board = board;
	}


	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	@OneToMany(mappedBy="section", cascade = CascadeType.PERSIST)
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}


	@ManyToOne
	public Board getBoard() {
		return board;
	}



	public void setBoard(Board board) {
		this.board = board;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
