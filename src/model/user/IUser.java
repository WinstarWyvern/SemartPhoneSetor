package model.user;

import model.News;

public interface IUser {
    public void receiveNews(News news, String type);

    public void showNews();
}
