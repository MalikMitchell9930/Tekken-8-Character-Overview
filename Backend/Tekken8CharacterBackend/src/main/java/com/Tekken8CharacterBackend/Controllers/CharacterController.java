package com.Tekken8CharacterBackend.Controllers;

import com.Tekken8CharacterBackend.Exceptions.CharacterNotFoundException;
import com.Tekken8CharacterBackend.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import  com.Tekken8CharacterBackend.Model.Character;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepo;

    @PostMapping("/character")
    Character newCharacter(@RequestBody Character newCharacter){
        return characterRepo.save(newCharacter);
    }

    @GetMapping("/characters")
    List<Character> getAllCharacters(){
        return characterRepo.findAll();
    }

    @GetMapping("/character/{id}")
    Character getCharacterById(@PathVariable Long id){
        return characterRepo.findById(id)
                .orElseThrow(() ->new CharacterNotFoundException(id));
    }
}
