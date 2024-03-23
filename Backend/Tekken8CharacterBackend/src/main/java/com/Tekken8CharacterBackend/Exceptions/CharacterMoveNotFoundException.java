package com.Tekken8CharacterBackend.Exceptions;

public class CharacterMoveNotFoundException extends RuntimeException {
    public CharacterMoveNotFoundException(Long id){
        super("This move could not be found.");
    }
}
