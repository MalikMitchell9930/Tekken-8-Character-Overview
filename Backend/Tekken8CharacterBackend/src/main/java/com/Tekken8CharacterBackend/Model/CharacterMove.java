package com.Tekken8CharacterBackend.Model;

import jakarta.persistence.*;

@Entity
public class CharacterMove {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moveId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="tekkenCharacter_id", referencedColumnName = "id")
    private TekkenCharacter tekkenCharacter;
    @Column(name = "Move_Name")
    private String moveName;
    @Column(name = "Annotation")
    private String annotation;
    @Column(name ="Hit_Level")
    private String hitLevel;
    @Column(name = "Startup_Frames")
    private int startupFrames;
    @Column(name ="On_Hit")
    private int onHit;
    @Column(name = "On_Block")
    private int onBlock;
    @Column(name = "On_Counter_Hit")
    private String onCounterHit;

    public Long getMoveId() {
        return moveId;
    }

    public void setMoveId(Long moveId) {
        this.moveId = moveId;
    }

    public TekkenCharacter getCharacter() {
        return tekkenCharacter;
    }

    public void setCharacter(TekkenCharacter tekkenCharacter) {
        this.tekkenCharacter = tekkenCharacter;
    }

    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getHitLevel() {
        return hitLevel;
    }

    public void setHitLevel(String hitLevel) {
        this.hitLevel = hitLevel;
    }

    public int getStartupFrames() {
        return startupFrames;
    }

    public void setStartupFrames(int startupFrames) {
        this.startupFrames = startupFrames;
    }

    public int getOnHit() {
        return onHit;
    }

    public void setOnHit(int onHit) {
        this.onHit = onHit;
    }

    public int getOnBlock() {
        return onBlock;
    }

    public void setOnBlock(int onBlock) {
        this.onBlock = onBlock;
    }

    public String getOnCounterHit() {
        return onCounterHit;
    }

    public void setOnCounterHit(String onCounterHit) {
        this.onCounterHit = onCounterHit;
    }
}