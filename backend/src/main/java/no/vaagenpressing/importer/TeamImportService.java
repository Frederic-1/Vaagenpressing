package no.vaagenpressing.importer;

import org.springframework.transaction.annotation.Transactional;
import no.vaagenpressing.importer.dto.TeamsResponse;
import no.vaagenpressing.team.Team;
import no.vaagenpressing.team.TeamRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.nio.file.Path;
import java.util.List;
import org.slf4j.Logger;


/**
 * Imports teams from and API-football /teams response into the database.
 * <p></p>
 * Teams are saved with their API-Football ID, so running the import again.
 * updates existing rows instead of creating duplicates.
 */
@Service
public class TeamImportService {

    private static final Logger log = LoggerFactory.getLogger(TeamImportService.class);

    private final TeamRepository teamRepository;
    private final ObjectMapper objectMapper;

    public TeamImportService(TeamRepository teamRepository, ObjectMapper objectMapper){
        this.teamRepository = teamRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * @param file path to a saved /teams JSON response
     * @return number of teams imported
     */
    @Transactional
    public int importTeams(Path file){
        TeamsResponse data = objectMapper.readValue(file.toFile(), TeamsResponse.class);

        List<Team> teams = data.response().stream()
                .map(item -> new Team(
                        item.team().id(),
                        item.team().name(),
                        item.team().code(),
                        item.team().founded())).toList();

        teamRepository.saveAll(teams);
        log.info("Imported {} teams from {}", teams.size(), file);
        return teams.size();
    }
}
