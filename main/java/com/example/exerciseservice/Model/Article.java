package com.example.exerciseservice.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.lang.reflect.MalformedParametersException;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Article {
@NotEmpty(message = "ID cannot be Empty! ")
    private String id;
@NotEmpty(message ="Title cannot be Empty!" )
@Size (max = 100,message = "Maximum length of title is 100")
private String title;

@NotEmpty(message = " Author cannot be Empty!")
@Size(min=4,max = 20, message = "The length of author must be 4 to 20 ")
private String author;

@NotEmpty(message = "Content cannot be Empty!")
@Size(max=200,message = "The Content must be more than 200 characters. ")
private String content;

@NotEmpty(message = "Category cannot be Empty!")
@Pattern(regexp ="^(politics|sports|technology)$", message =" Category must be either 'politics', ' sports ', or 'technology'.")
private String category;

@NotEmpty(message =" Image Url cannot be Empty!")
private String imageUrl;

private boolean isPublished=false;

@NotNull(message = " Publish Date cannot be Empty!")
@FutureOrPresent(message = "The publish Date must be future or present")
@JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate publishDate;

}
