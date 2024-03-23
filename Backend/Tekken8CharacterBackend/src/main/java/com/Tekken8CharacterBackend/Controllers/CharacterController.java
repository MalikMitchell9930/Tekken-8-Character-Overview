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
@RequestMapping("/overview")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepo;


    @PostMapping("/character")
    TekkenCharacter newCharacter(@RequestBody TekkenCharacter newTekkenCharacter){
        return characterRepo.save(newTekkenCharacter);
    }

    @GetMapping("/characters")
    List<TekkenCharacter> getAllCharacters(){
        return characterRepo.findAll();
    }

    @GetMapping("/characters/{id}")
    TekkenCharacter getCharacterById(@PathVariable Long id){
        return characterRepo.findById(id)
                .orElseThrow(() ->new CharacterNotFoundException(id));
    }

    @PutMapping("/characters/{id}")
    TekkenCharacter updateCharacter(@PathVariable("id") Long id, @RequestBody TekkenCharacter tekkenCharacter ){
        TekkenCharacter updatedTekkenCharacter = characterRepo.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
        updatedTekkenCharacter.setTekkenCharacterName(tekkenCharacter.getTekkenCharacterName());
        updatedTekkenCharacter.setHeight(tekkenCharacter.getHeight());
        updatedTekkenCharacter.setWeight(tekkenCharacter.getWeight());
        updatedTekkenCharacter.setFightStyle(tekkenCharacter.getFightStyle());
        updatedTekkenCharacter.setNationality(tekkenCharacter.getNationality());
        updatedTekkenCharacter.setOverview(tekkenCharacter.getOverview());
        return characterRepo.save(updatedTekkenCharacter);
    }

    @DeleteMapping("/characters/{id}")
    String deleteCharacter(@PathVariable Long id){
        if(!characterRepo.existsById(id)){
            throw new CharacterNotFoundException(id);
        }
        characterRepo.deleteById(id);
        return "Character has been deleted successfully.";
    }

}
