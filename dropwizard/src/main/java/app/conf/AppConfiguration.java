package app.conf;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Pattern;

public class AppConfiguration extends Configuration {
    @Pattern(regexp = "^AppModule$")
    private String moduleName = "AppModule";

    @JsonProperty
    public String getModuleName() {
        return moduleName;
    }

    @JsonProperty
    public void setModuleName(String name) {
        this.moduleName = name;
    }
}
