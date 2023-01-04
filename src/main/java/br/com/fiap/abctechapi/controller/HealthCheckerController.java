package br.com.fiap.abctechapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RestController
@RequestMapping("/")
public class HealthCheckerController {

    @GetMapping
    public ResponseEntity<Object> status () {
        return ResponseEntity.ok().build();
    }
    @GetMapping("version")
    public ResponseEntity<String> version () throws IOException {

        Properties properties = new Properties();

        InputStream inptstm = getClass().getClassLoader().getResourceAsStream("application.yml");

        properties.load(inptstm);

        return ResponseEntity.ok(properties.getProperty("build.name") + " - " + properties.getProperty("build.version"));


    }

}
