package no.vaagenpressing.fixture;

import jakarta.persistence.*;
import no.vaagenpressing.team.Team;
import java.time.Instant;

/**
 * A single Eliteserien match, stored with API-Footballs fixture id
 * <p></p>
 * Status uses API-Footballs short codes:
 * NS - not started.
 * FT - full time.
 * PST - postponed.
 * Goals are null until match done, kickoff is stored in UTC
 * Convert to local when displayed
 */

@Entity
@Table(name = "fixture")
public class Fixture {

    @Id
    private Integer id;

    @Column(nullable = false)
    private Integer season;

    @Column(nullable = false, length = 50)
    private String round;

    @Column(nullable = false)
    private Instant kickoff;

    @Column(nullable = false, length = 10)
    private String status;

    // Lazy: the team is only loaded from the database when actually used
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "home_team_id", nullable = false)
    private Team homeTeam;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "away_team_id", nullable = false)
    private Team awayTeam;

    private Integer homeGoals;

    private Integer awayGoals;

    protected Fixture(){}

    public Fixture(Integer id, Integer season, String round,
                   Instant kickoff, String status, Team homeTeam,
                   Team awayTeam, Integer homeGoals, Integer awayGoals) {
        this.id = id;
        this.season = season;
        this.round = round;
        this.kickoff = kickoff;
        this.status = status;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSeason() {
        return season;
    }

    public String getRound() {
        return round;
    }

    public Instant getKickoff() {
        return kickoff;
    }

    public String getStatus() {
        return status;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public Integer getAwayGoals() {
        return awayGoals;
    }
}
