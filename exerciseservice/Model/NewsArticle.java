package com.example.exerciseservice.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsArticle {
    @NotEmpty(message = "id cannot be null")
    private String id;

    @NotEmpty(message = "title cannot be null")
    @Size(max = 100, message = "the title must be a maximum length of 100")
    private String title;

    @NotEmpty(message = "author cannot be null.")
    @Size(min = 4,max = 20, message = "the title must be a max length of 20 and  min 4")
    private String author;


    @Size(max = 200, message = "the content must be a maximum length of 200")
    @NotEmpty(message = "content cannot be null.")
    private String content;

    @NotEmpty(message = "category cannot be null.")
    @Pattern(regexp = "^(politics|sports|technology)$" ,message = "The category must be politics,sports or technology)")
    private String category;


    @NotEmpty(message = "image Url cannot be null.")
    private String imageUrl;

@AssertFalse(message = "isPublished Must be by default false")
    private boolean isPublished;



    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;

}
