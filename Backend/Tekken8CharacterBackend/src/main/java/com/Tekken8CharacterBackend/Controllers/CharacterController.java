package com.Tekken8CharacterBackend.Controllers;

import com.Tekken8CharacterBackend.Exceptions.CharacterNotFoundException;
import com.Tekken8CharacterBackend.Repository.CharacterMoveRepository;
import com.Tekken8CharacterBackend.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Tekken8CharacterBackend.Model.TekkenCharacter;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepo;

    @Autowired
    private CharacterMoveRepository characterMoveRepository;

    @PostMapping("/character")
    TekkenCharacter newCharacter(@RequestBody TekkenCharacter newTekkenCharacter){
        return characterRepo.save(newTekkenCharacter);
    }

    @GetMapping("/characters")
    List<TekkenCharacter> getAllCharacters(){
        return characterRepo.findAll();
    }

    @GetMapping("/character/{id}")
    TekkenCharacter getCharacterById(@PathVariable Long id){
        return characterRepo.findById(id)
                .orElseThrow(() ->new CharacterNotFoundException(id));
    }
}
