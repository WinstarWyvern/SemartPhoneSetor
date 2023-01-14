package model.user;

import model.News;

public class VIP extends User {
    private int discount = 15;

    public VIP(String name, String email, String password, String role) {
        super(name, email, password, role);
    }

    @Override
    public void receiveNews(News news, String type) {
        if (type.equalsIgnoreCase("all") || type.equalsIgnoreCase("vip")) {
            this.news.add(news);
        }
    }

    @Override
    public void showNews() {
        for (News n : this.news) {
            System.out.println("Title: " + n.getTitle());
            System.out.println("Content: ");
            System.out.println(n.getContent());
            System.out.println("Discount: " + this.discount);

            System.out.println();
            System.out.println();
        }
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
