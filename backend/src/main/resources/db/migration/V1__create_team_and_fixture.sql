CREATE TABLE team (
    id INTEGER primary key ,
    name VARCHAR(100) not null ,
    code VARCHAR(10) ,
    founded INTEGER ,
    primary_color VARCHAR(7),
    secondary_color varchar(7)
);

CREATE TABLE fixture (
    id INTEGER primary key ,
    season INTEGER not null ,
    round VARCHAR(50) not null ,
    kickoff TIMESTAMPTZ not null,
    status VARCHAR(10) not null,
    home_team_id INTEGER NOT NULL REFERENCES team(id),
    away_team_id INTEGER NOT NULL REFERENCES team(id),
    home_goals INTEGER,
    away_goals INTEGER
);

CREATE INDEX idx_fixture_season ON fixture(season);