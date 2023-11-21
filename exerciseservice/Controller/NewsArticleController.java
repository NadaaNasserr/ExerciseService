package com.example.exerciseservice.Controller;


import com.example.exerciseservice.Model.NewsArticle;
import com.example.exerciseservice.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor

public class NewsArticleController {

    private final NewsArticleService newsArticleService;

    @GetMapping("/get")
    public ResponseEntity getNewsArticles() {

        return ResponseEntity.status(200).body(newsArticleService.getNewsArticles());
    }

    @PostMapping("/add")
    public ResponseEntity addNewsArticles(@Valid @RequestBody NewsArticle newsArticle, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        newsArticleService.addNewsArticle(newsArticle);
        return ResponseEntity.status(HttpStatus.OK).body("News Article added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateNewsArticles(@PathVariable String id, @Valid @RequestBody NewsArticle newsArticle, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated = newsArticleService.updateNewsArticle(id, newsArticle);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("newsArticle updated");

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNewsArticles(@PathVariable String id) {


        boolean isDeleted = newsArticleService.deleteNewsArticle(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("NewsArticles Deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }



    @GetMapping("/getCategory/{category}")
    public ResponseEntity getCategory(@PathVariable String category) {
            return ResponseEntity.status(200).body(newsArticleService.getCategory(category));

    }

    @PutMapping("/publish")
    public ResponseEntity publish(){

        newsArticleService.publish();
        return ResponseEntity.status(200).body("publish");
    }




    @GetMapping("/getAllPublished")
    public ResponseEntity getAllPublished(){
        return ResponseEntity.status(200).body(newsArticleService.getAllPublished());



    }







//    @GetMapping("/getCategory/{category}")
//    public ResponseEntity getCategory(@PathVariable String category) {
//
//        boolean isCategory = newsArticleService.getNewsArticles().contains(category);
//        if (isCategory) {
//            return ResponseEntity.status(200).body(newsArticleService.getCategory(category));
//
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong category!! the category must be politics,sports or technology");
//    }
}
