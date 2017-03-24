package bwf.teaching.book.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="admininfo")
public class Admin {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="aid")
	private Integer id;
	
	@Column(name="aloginid")
	private String loginId;
	
	@Column(name="aloginpsw")
	private String loginPsw;
	
	@Column(name="aname")
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPsw() {
		return loginPsw;
	}
	public void setLoginPsw(String loginPsw) {
		this.loginPsw = loginPsw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
