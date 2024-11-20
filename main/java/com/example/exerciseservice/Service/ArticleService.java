package com.example.exerciseservice.Service;

import com.example.exerciseservice.Model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleService {
ArrayList<Article>articles=new ArrayList<>();

public ArrayList<Article>getArticles(){
    return articles;
}

public void addArt(Article article){
articles.add(article);
}

public boolean updateArt(Article article,String id){
    for (int i = 0; i <articles.size() ; i++) {
        if(articles.get(i).getId().equalsIgnoreCase(id)){
            articles.set(i,article);
            return true;
        }
    }
return false;
}
public boolean deletArt(String id){
    for (int i = 0; i < articles.size(); i++) {
        if(articles.get(i).getId().equalsIgnoreCase(id)){
            articles.remove(id);
            return true;
        }

    }
    return false;
}


public boolean publish(String id){
    for (int i = 0; i <articles.size() ; i++) {
        if(articles.get(i).getId().equalsIgnoreCase(id)){
            if(articles.get(i).isPublished()==false){
                articles.get(i).setPublished(true);
                return true;
            }
        }
    }
    return false;
}

public ArrayList<Article>allB(){
    ArrayList<Article> newArt=new ArrayList<>();
    for (int i = 0; i <articles.size() ; i++) {
        if (articles.get(i).isPublished()==true){
            newArt.add(articles.get(i));
        }
    }
    if(newArt.isEmpty()){return null;}
    else return newArt;

}
//Get NewsArticles by Category
public ArrayList<Article>catgory(String catg){
    ArrayList<Article>newCat=new ArrayList<>();
    for (int i = 0; i < articles.size(); i++) {
        if(articles.get(i).getCategory().equalsIgnoreCase(catg)){
            newCat.add(articles.get(i));
        }

    }
    if(newCat.isEmpty()){
        return null;
    }
    else return newCat;
}







}
