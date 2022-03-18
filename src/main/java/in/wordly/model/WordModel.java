package in.wordly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_word")
public class WordModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String word;
	
	@Column
	private String meaning;
	
	@Column
	private String sentence1;
	
	@Column
	private String sentence2;
	
	@Column
	private String sentence3;

	@OneToOne
	@JoinColumn(name = "user_id")
	private UserModel user;

	
	
	public WordModel() {}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getSentence1() {
		return sentence1;
	}

	public void setSentence1(String sentence1) {
		this.sentence1 = sentence1;
	}

	public String getSentence2() {
		return sentence2;
	}

	public void setSentence2(String sentence2) {
		this.sentence2 = sentence2;
	}

	public String getSentence3() {
		return sentence3;
	}

	public void setSentence3(String sentence3) {
		this.sentence3 = sentence3;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "WordModel [id=" + id + ", word=" + word + ", meaning=" + meaning + ", sentence1=" + sentence1
				+ ", sentence2=" + sentence2 + ", sentence3=" + sentence3 + ", user=" + user + "]";
	}
	
	
	
}
