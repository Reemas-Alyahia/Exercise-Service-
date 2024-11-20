package com.example.exerciseservice.Controller;

import com.example.exerciseservice.ApiResponse.ApiResponse;
import com.example.exerciseservice.Model.Article;
import com.example.exerciseservice.Service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class ArticleControoler {
    private final ArticleService articleService;

    @GetMapping("/get")
    public ResponseEntity getArticle(){
        return ResponseEntity.status(200).body(articleService.getArticles());
    }
@PostMapping("/add")
    public ResponseEntity addArt(@RequestBody @Valid Article article, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        articleService.addArt(article);
        return ResponseEntity.status(200).body(new ApiResponse("Done from adding"));
    }

@PutMapping("/update/{id}")
public ResponseEntity updateArt(@RequestBody @Valid Article article,@PathVariable String id,Errors errors){
      if(errors.hasErrors()){
          return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
      }
      boolean isFound=articleService.updateArt(article,id);
      if(isFound){
          return ResponseEntity.status(200).body(new ApiResponse("Done from Update"));
      }

      return ResponseEntity.status(400).body(new ApiResponse("Not Found the Id"));
}

@DeleteMapping("/delet/{id}")
public ResponseEntity deletArt(@PathVariable String id){
        boolean isFound=articleService.deletArt(id);
        if(isFound){
            return ResponseEntity.status(400).body(new ApiResponse("Done from Deleting"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not Found the Id"));
}
@PutMapping("/pup/{id}")
public ResponseEntity publish(@PathVariable String id){

boolean isPuplish=articleService.publish(id);
if(isPuplish){
    return ResponseEntity.status(200).body("Done from puplishing");
}
else{
    return ResponseEntity.status(400).body("Not puplish yet");}

}
@GetMapping("/allB")
public ResponseEntity allB(){
    ArrayList<Article>newArt=articleService.allB();
    if(newArt==null){
        return ResponseEntity.status(400).body("Not puplish yet");
    }
      return ResponseEntity.status(200).body(newArt);
}
@GetMapping("/cat/{catg}")
    public ResponseEntity catgory(@PathVariable String catg){
        ArrayList<Article>newCat=articleService.catgory(catg);
        if (newCat.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponse("No Catgory yet"));
        }
        return ResponseEntity.status(200).body(newCat);
    }


}
