package service;

import model.NewsModel;

public interface INewsService {
    void createdNews(NewsModel newsModel);
    void updateNews(Long id, NewsModel updateNewsModel);
}
