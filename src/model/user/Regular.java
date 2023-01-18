package model.user;

import model.News;
import model.Phone;

public class Regular extends User {

    public Regular(String name, String email, String password, String role) {
        super(name, email, password, role);
    }

    @Override
    public void receiveNews(News news, String type) {
        if (type.equalsIgnoreCase("all") || type.equalsIgnoreCase("regular")) {
            this.news.add(news);
        }
    }

    @Override
    public void showNews() {
        for (News n : this.news) {
            System.out.println("Title: " + n.getTitle());
            System.out.println("Content: ");
            System.out.println(n.getContent());

            System.out.println();
            System.out.println();
        }
    }

    @Override
    public void openPhone() {
        System.out.println("Not Opening the Inside of the Phone, Skipping the process...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cleanPhone() {
        System.out.println("Clean the Outside of the Phone with a toothbrush...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cleanCase() {
        System.out.println("Clean the Case with a Brush...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setPhoneBack() {
        System.out.println("There's no need to set the PhoneBack, Skipping the process...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkVirus() {
        System.out.println("Check whether this phone contains virus or not...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
