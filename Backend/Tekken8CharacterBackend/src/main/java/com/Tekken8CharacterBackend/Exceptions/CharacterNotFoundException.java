package com.Tekken8CharacterBackend.Exceptions;

public class CharacterNotFoundException extends RuntimeException{
    public CharacterNotFoundException(Long id){
        super("Character could not be found.");
    }

}
