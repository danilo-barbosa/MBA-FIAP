package br.com.fiap.abctechapi.component;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class VersionComponent {

    private Properties properties;
    public VersionComponent () throws IOException {

        properties = new Properties();

        InputStream inptstm = getClass().getClassLoader().getResourceAsStream("application.yml");

        properties.load(inptstm);

    }
    public String getNameVersion() throws IOException {
        return getName() + " - " + getVersion();
    }

    public String getName() {
        return properties.getProperty("build.name");
    }

    public String getVersion(){
        return properties.getProperty("build.version");
    }

}
