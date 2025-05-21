package com.giuseppe.spring.jdbc.mysql.controller;

import com.giuseppe.spring.jdbc.mysql.model.Tutorial;
import com.giuseppe.spring.jdbc.mysql.service.TutorialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

  private final TutorialService tutorialService;

  public TutorialController(TutorialService tutorialService) {
    this.tutorialService = tutorialService;
  }

  @GetMapping
  public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
    return tutorialService.getAllTutorials(title);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
    return tutorialService.getTutorialById(id);
  }

  @PostMapping
  public ResponseEntity<String> createTutorial(@RequestBody Tutorial tutorial) {
    return tutorialService.createTutorial(tutorial);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
    return tutorialService.updateTutorial(id, tutorial);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteTutorial(@PathVariable("id") long id) {
    return tutorialService.deleteTutorial(id);
  }

  @DeleteMapping
  public ResponseEntity<String> deleteAllTutorials() {
    return tutorialService.deleteAllTutorials();
  }

  @GetMapping("/published")
  public ResponseEntity<List<Tutorial>> findByPublished() {
    return tutorialService.findByPublished();
  }
}
