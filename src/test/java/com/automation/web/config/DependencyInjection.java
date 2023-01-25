package com.automation.web.config;

import com.automation.web.exceptions.StopTestException;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.google.inject.name.Names;
import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.InjectorSource;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class DependencyInjection extends AbstractModule implements InjectorSource {

    private Injector injector;

    @Override
    protected void configure() {
        bind(WebDriver.class).toProvider(WebDriverProvider.class).in(ScenarioScoped.class);
        bind(Configuration.class).toProvider(ConfigurationProvider.class)
                .in(ScenarioScoped.class);

        ConfigurationBuilder reflectionsConfiguration = new ConfigurationBuilder()
                .forPackages("com.automation.web")
                .setScanners(Scanners.MethodsAnnotated, Scanners.SubTypes, Scanners.TypesAnnotated);

        Reflections reflections = new Reflections(reflectionsConfiguration);
        setAllTestClassesInScenarioScope(reflections);
        Names.bindProperties(binder(), getProperties());
    }

    @Override
    public Injector getInjector() {
        if (injector != null) return injector;
        injector = Guice.createInjector(Stage.PRODUCTION, CucumberModules.createScenarioModule(), this);
        return injector;
    }

    private void setAllTestClassesInScenarioScope(Reflections reflections) {
        ArrayList<Class<?>> scenarioScopedClasses = new ArrayList<>();

        // All classes containing methods annotated with Cucumber keywords
        Class<? extends Annotation>[] cucumberKeywordClasses = new Class[]{
                Given.class, When.class, Then.class, And.class, But.class,
                Before.class, After.class};
        for (Class<? extends Annotation> cucumberKeywordClass : cucumberKeywordClasses) {
            for (Method method : reflections
                    .getMethodsAnnotatedWith(cucumberKeywordClass)) {
                if (!scenarioScopedClasses.contains(method.getDeclaringClass())) {
                    scenarioScopedClasses.add(method.getDeclaringClass());
                }
            }
        }

        for (Class<?> klass : scenarioScopedClasses) {
            bind(klass).in(ScenarioScoped.class);
        }
    }

    private Properties getProperties() {

        try {
            Properties legacyProperties = Configuration
                    .getConfiguration()
                    .getProperties();

//            legacyProperties.putAll(new TestExecutionSystemProperties()
//                    .getProperties());
            return legacyProperties;

        } catch (StopTestException e) {
            e.printStackTrace();
        }
//        If we fail to load properties from configuration, we'll return system properties only
        return System.getProperties();
    }
}
