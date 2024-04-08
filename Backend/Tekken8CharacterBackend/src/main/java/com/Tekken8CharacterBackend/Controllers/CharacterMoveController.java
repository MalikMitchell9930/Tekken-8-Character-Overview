package com.Tekken8CharacterBackend.Controllers;

import com.Tekken8CharacterBackend.Exceptions.CharacterMoveNotFoundException;
import com.Tekken8CharacterBackend.Exceptions.CharacterNotFoundException;
import com.Tekken8CharacterBackend.Model.CharacterMove;
import com.Tekken8CharacterBackend.Repository.CharacterMoveRepository;
import com.Tekken8CharacterBackend.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/overview")
public class CharacterMoveController {

    @Autowired
    private CharacterRepository characterRepo;

    @Autowired
    private CharacterMoveRepository characterMoveRepository;

    @PostMapping("/characters/{tekkenCharacterId}/moves")
    CharacterMove newCharacterMove(@PathVariable("tekkenCharacterId") Long tekkenCharacterId,@RequestBody CharacterMove newMoveRequest){
        CharacterMove characterMove = characterRepo.findById(tekkenCharacterId).map(tekkenCharacter -> {
            newMoveRequest.setCharacter(tekkenCharacter);
            return newMoveRequest;
        }).orElseThrow(() -> new CharacterNotFoundException(tekkenCharacterId));
        return characterMoveRepository.save(newMoveRequest);
    }

    @GetMapping("/moves")
    List<CharacterMove> getAllMoves(){
       return characterMoveRepository.findAll();
    }

    @GetMapping("/characters/{tekkenCharacterId}/moves")
    List<CharacterMove> getAllCharacterMoves(@PathVariable (value = "tekkenCharacterId") Long tekkenCharacterId){
        return characterMoveRepository.getAllByTekkenCharacterId(tekkenCharacterId);
    }

    @GetMapping("/moves/{id}")
    CharacterMove getCharacterMoveById(@PathVariable("id") Long id){
        return characterMoveRepository.findById(id)
                .orElseThrow(() -> new CharacterMoveNotFoundException(id));
    }

    @PutMapping("/moves/{id}")
    CharacterMove updateCharacterMove(@PathVariable("id") Long id, @RequestBody CharacterMove characterMove){
        CharacterMove updatedCharacterMove = characterMoveRepository.findById(id)
                .orElseThrow(()-> new CharacterMoveNotFoundException(id));
        updatedCharacterMove.setCharacter(characterMove.getCharacter());
        updatedCharacterMove.setMoveName(characterMove.getMoveName());
        updatedCharacterMove.setAnnotation(characterMove.getAnnotation());
        updatedCharacterMove.setHitLevel(characterMove.getHitLevel());
        updatedCharacterMove.setOnBlock(characterMove.getOnBlock());
        updatedCharacterMove.setOnHit(characterMove.getOnHit());
        updatedCharacterMove.setStartupFrames(characterMove.getStartupFrames());
        updatedCharacterMove.setOnCounterHit(characterMove.getOnCounterHit());

        return characterMoveRepository.save(updatedCharacterMove);
    }

    @DeleteMapping("/moves/{id}")
    String deleteCharacterMove(@PathVariable Long id) {
        if (!characterMoveRepository.existsById(id)) {
            throw new CharacterMoveNotFoundException(id);
        }
        characterMoveRepository.deleteById(id);
        return "Character move has been deleted successfully.";
    }
}

