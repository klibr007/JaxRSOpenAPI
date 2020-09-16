package kanbanjpa;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Card {
	
	private Long id;
	private String label;
	private Date date;
	private User user;
	private int durating;
	private List <Tag> tags;
	private String location;
	private String url;
	private String description;
	private Section section;
	
	public Card() {
		
	}

	public Card(Long id, String label, Date date, User user, int durating, List<Tag> tags,
			String location, String url, String description, Section section) {
		super();
		this.id = id;
		this.label = label;
		this.date = date;
		this.user = user;
		this.durating = durating;
		this.tags = tags;
		this.location = location;
		this.url = url;
		this.description = description;
		this.section = section;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToOne(mappedBy = "card" , cascade = CascadeType.PERSIST)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getDurating() {
		return durating;
	}

	public void setDurating(int durating) {
		this.durating = durating;
	}

	@OneToMany(mappedBy = "card", cascade = CascadeType.PERSIST)
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	
	
	

}
