package kanbandao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.taa.jaxrs.dao.generic.EntityManagerHelper;
import kanbanjpa.Board;
import kanbanjpa.Card;
import kanbanjpa.Section;
import kanbanjpa.Tag;
import kanbanjpa.User;



public class Kanban {

    /**
     * @param args
     */
    public static void main(String[] args) {
    	//Users
    	User u1 = new User();
    	u1.setName("Jean");
    	User u2 = new User();
    	u2.setName("Paul");
    	User u3 = new User();
    	u3.setName("Pierre");
    	User u4 = new User();
    	u4.setName("Papin");
    	//Tags
    	Tag t1 = new Tag();
    	t1.setName("dev");
    	Tag t2 = new Tag();
    	t2.setName("mob");
    	Tag t3 = new Tag();
    	t3.setName("dev");
    	Tag t4 = new Tag();
    	t4.setName("rob");
    	List<Tag> tags1 = new ArrayList<Tag>();
    	tags1.add(t1);
    	tags1.add(t2);
    	List<Tag> tags2 = new ArrayList<Tag>();
    	tags1.add(t3);
    	tags1.add(t4);
    	//sections
    	Section await = new Section();
    	await.setName("Await");
    	Section ongoing = new Section();
    	ongoing.setName("Ongoing");
    	Section finished = new Section();
    	finished.setName("Done");
    	//cards
    	Card c1 = new Card();
    	c1.setLabel("taff");
    	c1.setTags(tags1);
    	c1.setUser(u1);
    	u1.setCard(c1);
    	c1.setSection(await);
    	Card c2 = new Card();
    	c2.setLabel("tgv");
    	c2.setTags(tags2);
    	c2.setUser(u2);
    	u2.setCard(c2);
    	c2.setSection(await);
    	Card c3 = new Card();
    	c3.setLabel("ratp");
    	c3.setTags(tags1);
    	c3.setUser(u3);
    	u3.setCard(c3);
    	c3.setSection(ongoing);
    	Card c4 = new Card();
    	c4.setLabel("rennes");
    	c4.setTags(tags2);
    	c4.setUser(u4);
    	u4.setCard(c4);
    	c4.setSection(finished);
    	List<Card> cards1 = new ArrayList<Card>();
    	cards1.add(c1);
    	cards1.add(c2);
    	List<Card> cards2 = new ArrayList<Card>();
    	cards2.add(c3);
    	List<Card> cards3 = new ArrayList<Card>();
    	cards3.add(c4);
    	//Board
    	Board kanban = new Board();
    	kanban.setName("Kanban1");
    	await.setCards(cards1);
    	await.setBoard(kanban);
    	ongoing.setCards(cards2);
    	ongoing.setBoard(kanban);
    	finished.setCards(cards3);
    	finished.setBoard(kanban);
    	List<Section> sec = new ArrayList<Section>();
    	sec.add(await);
    	sec.add(finished);
    	sec.add(ongoing);
    	kanban.setSections(sec);
    	
    	
    	
    	
    	
        EntityManager manager = EntityManagerHelper.getEntityManager();
        

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        manager.persist(kanban);
        UserDao userDao = new UserDao();
        List<User> users = userDao.findAll();
        for(User u : users) {
        	System.out.println(u.getName());
        }
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        
            
        manager.close();
        System.out.println(".. done");
    }
    
    


    


}
