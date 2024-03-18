package com.Tekken8CharacterBackend.Repository;

import com.Tekken8CharacterBackend.Model.TekkenCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<TekkenCharacter, Long> {


}
