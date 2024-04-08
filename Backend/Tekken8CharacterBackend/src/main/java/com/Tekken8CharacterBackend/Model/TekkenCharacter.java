package com.Tekken8CharacterBackend.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TekkenCharacter {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "Character_Name")
private String tekkenCharacterName;
@Column(name="Fight_Style")
private String fightStyle;
@Column(name ="Height")
private Long height;
@Column(name = "Weight")
private Long weight;

@Column(name = "Overview")
private String overview;

@Column(name = "Nationality")
private String nationality;

@OneToMany(mappedBy = "tekkenCharacter",cascade = CascadeType.ALL, orphanRemoval = true)
@Fetch(value = FetchMode.SELECT)
private List<CharacterMove> moveList = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTekkenCharacterName() {
        return tekkenCharacterName;
    }

    public void setTekkenCharacterName(String tekkenCharacterName) {
        this.tekkenCharacterName = tekkenCharacterName;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
