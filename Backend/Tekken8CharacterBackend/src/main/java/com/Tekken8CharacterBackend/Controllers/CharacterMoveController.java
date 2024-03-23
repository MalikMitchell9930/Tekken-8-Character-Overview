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

    @PostMapping("/characters/{tekkenCharacter_id}/moves")
    CharacterMove newCharacterMove(@PathVariable(value = "tekkenCharacter_id") Long tekkenCharacter_id,@RequestBody CharacterMove newMoveRequest){
        CharacterMove characterMove = characterRepo.findById(tekkenCharacter_id).map(tekkenCharacter -> {
            newMoveRequest.setCharacter(tekkenCharacter);
            return newMoveRequest;
        }).orElseThrow(() -> new CharacterNotFoundException(tekkenCharacter_id));
        return characterMoveRepository.save(newMoveRequest);
    }

    @GetMapping("/moves")
    List<CharacterMove> getAllMoves(){
       return characterMoveRepository.findAll();
    }

    @GetMapping("/characters/{id}/moves")
    List<CharacterMove> getAllCharacterMoves(Long tekkenCharacter_id){
        return characterMoveRepository.getAllByTekkenCharacterId(tekkenCharacter_id);
    }

    @PutMapping("/moves/{id}")
    CharacterMove updateCharacterMove(@PathVariable("id") Long id, CharacterMove characterMove){
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

