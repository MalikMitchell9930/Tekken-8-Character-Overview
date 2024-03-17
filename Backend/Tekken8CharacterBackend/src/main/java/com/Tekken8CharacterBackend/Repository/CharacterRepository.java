package com.Tekken8CharacterBackend.Repository;

import com.Tekken8CharacterBackend.Model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepo extends JpaRepository<Character, Long> {


}
