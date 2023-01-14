package model.user;

import model.News;

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
}
