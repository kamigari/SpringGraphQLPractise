package graphql.beans;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "posts")
@XmlRootElement(name = "post")
public class Post {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer authorId;
	private String text;
	public Post(Integer id, Integer authorId, String text) {
		super();
		this.id = id;
		this.authorId = authorId;
		this.text = text;
	}
	public Post(Integer authorId, String text) {
		super();
		this.authorId = authorId;
		this.text = text;
	}
	public Post() {
		super();	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Post [id=");
		builder.append(id);
		builder.append(", authorId=");
		builder.append(authorId);
		builder.append(", text=");
		builder.append(text);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		return Objects.hash(authorId, id, text);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(authorId, other.authorId) && Objects.equals(id, other.id)
				&& Objects.equals(text, other.text);
	}
}
