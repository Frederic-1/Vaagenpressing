package no.vaagenpressing.team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * A football team, stored with the same ID as API-football.
 * <p></p>
 * Using external ID as primary key makes key import idempotent.
 * Colours are not provided by API, will be set separately and used
 * to render generated team badges, copyright.
 */
@Entity
@Table(name = "team")
public class Team {

    @Id
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    private String code;

    private Integer founded;

    private String primaryColor;

    private String secondaryColor;

    /** required by JPA, not for use in code. */
    protected Team(){
    }

    /**
     * @param id the team's ID in API-Football
     */
    public Team(Integer id, String name, String code, Integer founded) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.founded = founded;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Integer getFounded() {
        return founded;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }
}
