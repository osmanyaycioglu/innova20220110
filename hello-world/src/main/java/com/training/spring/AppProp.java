package com.training.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProp {

    private String name;
    private String version;
    private String test;
    private String patch;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(final String versionParam) {
        this.version = versionParam;
    }

    public String getTest() {
        return this.test;
    }

    public void setTest(final String testParam) {
        this.test = testParam;
    }

    public String getPatch() {
        return this.patch;
    }

    public void setPatch(final String patchParam) {
        this.patch = patchParam;
    }

    @Override
    public String toString() {
        return "AppProp [name="
               + this.name
               + ", version="
               + this.version
               + ", test="
               + this.test
               + ", patch="
               + this.patch
               + "]";
    }


}
