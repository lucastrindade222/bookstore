package br.com.lucas.bookstore.config;

import br.com.lucas.bookstore.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class ConfigProjectconfig {

    @Autowired
    private DBService dbService;


    @Bean
    public void instantiateDatabase() throws ParseException {

        dbService.instantiateDatabase();

    }

}
