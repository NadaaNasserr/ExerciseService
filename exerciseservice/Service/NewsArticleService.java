package com.example.exerciseservice.Service;

import com.example.exerciseservice.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
@Service
public class NewsArticleService {


    ArrayList<NewsArticle> newsArticles = new ArrayList<>();


    public ArrayList<NewsArticle> getNewsArticles() {
        return newsArticles;
    }
    public void addNewsArticle(NewsArticle newsArticle){
        newsArticles.add(newsArticle);
    }

    public boolean updateNewsArticle(String id,NewsArticle newsArticle){

        for (int i = 0; i <newsArticles.size() ; i++) {
            if (newsArticles.get(i).getId().equals(id)){
                newsArticles.set(i,newsArticle);
                return true;
            }

        }
        return false;
    }

    public boolean deleteNewsArticle(String id){
        for (int i = 0; i <newsArticles.size() ; i++) {
            if (newsArticles.get(i).getId().equals(id)){
                newsArticles.remove(i);
                return true;
            }

        }
        return false;
    }

    public void publish() {
        ArrayList<NewsArticle> newsArticles1 = new ArrayList<>();
        for (int i = 0; i < newsArticles.size(); i++) {
            if (!newsArticles.get(i).isPublished()) {
                newsArticles.get(i).setPublished(true);
                newsArticles.get(i).setPublishDate(LocalDate.now());
                newsArticles1.add(newsArticles.get(i));
            }

        }
    }


    public  ArrayList<NewsArticle> getAllPublished(){
        ArrayList<NewsArticle> newsArticles1 = new ArrayList<>();
        for (int i = 0; i <newsArticles.size() ; i++) {
            if (newsArticles.get(i).isPublished()) {
                newsArticles1.add(newsArticles.get(i));
            }

        }
            return newsArticles1;

    }
    public ArrayList<NewsArticle> getCategory(String category){
        ArrayList<NewsArticle> newsArticles1 = new ArrayList<>();
        for (int i = 0; i < newsArticles.size(); i++) {
            if(newsArticles.get(i).getCategory().equals(category)){
                newsArticles1.add(newsArticles.get(i));
            }

        }
        return newsArticles1;
    }


//
//    public boolean isCategory(String category){
//
//        for (int i = 0; i < newsArticles.size() ; i++) {
//            if(newsArticles.get(i).getCategory().contains(category)){
//               return true ;
//            }
//
//        }
//        return false;
//    }


}
