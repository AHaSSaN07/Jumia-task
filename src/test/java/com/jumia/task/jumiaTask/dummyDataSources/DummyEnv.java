package com.jumia.task.jumiaTask.dummyDataSources;

import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

public class DummyEnv implements Environment {
    @Override
    public String[] getActiveProfiles() {
        return new String[0];
    }

    @Override
    public String[] getDefaultProfiles() {
        return new String[0];
    }

    @Override
    public boolean acceptsProfiles(String... profiles) {
        return false;
    }

    @Override
    public boolean acceptsProfiles(Profiles profiles) {
        return false;
    }

    @Override
    public boolean containsProperty(String key) {
        return false;
    }

    @Override
    public String getProperty(String key) {
        switch (key) {
            case "237":
                return "\\(237\\)\\ ?[2368]\\d{7,8}$";
            case "251":
                return "\\(251\\)\\ ?[1-59]\\d{8}$";
            case "212":
                return "\\(212\\)\\ ?[5-9]\\d{8}$";
            case "258":
                return "\\(258\\)\\ ?[28]\\d{7,8}$";
            case "256":
                return "\\(256\\)\\ ?\\d{9}$";
            case "237_name":
                return "Cameroon";
            case "251_name":
                return "Ethiopia";
            case "212_name":
                return "Morocco";
            case "258_name":
                return "Mozambique";
            case "256_name":
                return "Uganda";
        }
        return null;
    }

    @Override
    public String getProperty(String key, String defaultValue) {
        return null;
    }

    @Override
    public <T> T getProperty(String key, Class<T> targetType) {
        return null;
    }

    @Override
    public <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
        return null;
    }

    @Override
    public String getRequiredProperty(String key) throws IllegalStateException {
        return null;
    }

    @Override
    public <T> T getRequiredProperty(String key, Class<T> targetType) throws IllegalStateException {
        return null;
    }

    @Override
    public String resolvePlaceholders(String text) {
        return null;
    }

    @Override
    public String resolveRequiredPlaceholders(String text) throws IllegalArgumentException {
        return null;
    }
}
