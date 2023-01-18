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

    @Override
    public void openPhone() {
        System.out.println("Remove Phone From the Case");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Opening the Inside of Phone with Smartphone Repair Tool Kit");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Remove Display");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Remove LCD Assembly");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Remove Battery");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Remove Loudspeaker Cable");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Remove Rear Facing Camera");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Remove Loudspeaker");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cleanPhone() {
        System.out.println("Clean the Inside of the Phone with a brush gently...");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
        System.out.println("Put Loudspeaker back");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Put Rear Facing Camera Back");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Put Loudspeaker Cable Back");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Put Battery Back");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Put LCD Assembly Back");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Put Display Back");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Close the Phone Back with Smartphone Repair Tool Kit");
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
