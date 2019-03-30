package service.impl;

import dao.INewsDAO;
import dao.impl.NewsDaoImpl;
import model.NewsModel;
import service.INewsService;

import java.sql.Timestamp;


public class NewsService implements INewsService{
    private INewsDAO newsDAO;

    public NewsService(){
        this.newsDAO = new NewsDaoImpl();
    }

    public void createdNews(NewsModel newsModel) {
        newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newsModel.setCreatedBy("");
        newsDAO.insertNews(newsModel);
    }

    public void updateNews(Long id, NewsModel updateNewsModel) {
        NewsModel oldNewsModel = newsDAO.findByID(id);
        updateNewsModel.setCreatedDate(oldNewsModel.getCreatedDate());
        updateNewsModel.setCreatedBy(oldNewsModel.getCreatedBy());
        updateNewsModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateNewsModel.setModifiedBy("");
        newsDAO.updateNews(id, updateNewsModel);
    }
}
