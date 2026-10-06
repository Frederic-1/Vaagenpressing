package no.vaagenpressing.fixture;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fixture")
public class Fixture {

    @Id
    private Integer id;

    @Column(nullable = false)
    private Integer season;

    @Column(nullable = false, length = 50)
    private String round;

    @Column
    private
}
