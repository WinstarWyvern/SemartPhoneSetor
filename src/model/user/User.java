package model.user;

import java.util.ArrayList;
import java.util.Random;

import model.News;

public abstract class User implements IUser {
	protected String id;
	protected String name;
	protected String email;
	protected String password;
	protected String role;
	protected ArrayList<News> news;
	protected int balance;

	public User(String name, String email, String password, String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		setId();
	}

	public String getId() {
		return id;
	}

	private void setId() {
		Random rand = new Random();
		String alphanumeric = "abcdefghijklmnopqrstuvwxyz0123456789";
		String num = "";
		Integer mix = -1;
		for (int i = 0; i < 5; i++) {
			mix = rand.nextInt(alphanumeric.length());
			num += (alphanumeric.substring(mix, mix + 1));
		}
		this.id = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<News> getNews() {
		return news;
	}

	public void setNews(ArrayList<News> news) {
		this.news = news;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void checkPhone() {
		openPhone();
		cleanPhone();
		cleanCase();
		setPhoneBack();
		checkVirus();
	}

	public abstract void openPhone();

	public abstract void cleanPhone();

	public abstract void cleanCase();

	public abstract void setPhoneBack();

	public abstract void checkVirus();
}
