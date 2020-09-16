package kanbanjpa;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Board {

	private Long id;
	private String name;
	private List<Section> sections;
	
	public Board() {
		
	}
	
	
	public Board(Long id, String name, List<Section> sections) {
		super();
		this.id = id;
		this.setName(name);
		this.sections = sections;
	}


	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST)
	public List<Section> getSections() {
		return sections;
	}


	public void setSections(List<Section> sections) {
		this.sections = sections;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
