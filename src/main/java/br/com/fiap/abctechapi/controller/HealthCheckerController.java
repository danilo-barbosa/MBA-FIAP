package br.com.fiap.abctechapi.controller;

import br.com.fiap.abctechapi.component.VersionComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HealthCheckerController {

    private final VersionComponent versionComponent;
    @GetMapping
    public ResponseEntity<Object> status () {
        return ResponseEntity.ok().build();
    }
    @GetMapping("version")
    public ResponseEntity<String> version () throws IOException {

        return ResponseEntity.ok(versionComponent.getNameVersion());


    }



}
