package no.vaagenpressing.importer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

/**
 * Loads sample data from api-samples /on start up, for local development.
 * <p></p>
 * Temporary: will be replaced by a scheduled job calling API-Football directly.
 * Teams must be imported before fixtures, since fixtures reference teams.
 */
@Component
public class DevDataLoader implements CommandLineRunner {

    private final TeamImportService teamImportService;

    public DevDataLoader(TeamImportService teamImportService){
        this.teamImportService = teamImportService;
    }

    @Override
    public void run(String... args){
        teamImportService.importTeams(Path.of("api-samples/teams-2024.json"));
    }
}
