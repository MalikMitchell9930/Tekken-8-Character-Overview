package com.Tekken8CharacterBackend.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Character {

@Id
@GeneratedValue
private Long id;
@Column(name = "Character_Name")
private String characterName;
@Column(name="Fight_Style")
private String fightStyle;
@Column(name ="Height")
private Long height;
@Column(name = "Weight")
private Long weight;

@OneToMany(mappedBy = "character")
@Fetch(value = FetchMode.SELECT)
private List<CharacterMove> moveList = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getFightStyle() {
        return fightStyle;
    }

    public void setFightStyle(String fightStyle) {
        this.fightStyle = fightStyle;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }
}
