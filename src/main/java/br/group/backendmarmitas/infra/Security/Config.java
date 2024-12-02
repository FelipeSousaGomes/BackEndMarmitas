package br.group.backendmarmitas.infra.Security;

import br.group.backendmarmitas.services.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Config {
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;
    @Autowired
    private DBservice dbService;
    @Bean
    public Boolean InstanciaDB(){
        if (value.equals("create-drop")){
            this.dbService.InstanciaDB();
        }if (value.equals("create")){
            this.dbService.InstanciaDB();
        }
        return false;
    }
}


