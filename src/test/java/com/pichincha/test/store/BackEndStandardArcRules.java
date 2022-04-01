package com.pichincha.test.store;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.junit.Assert;

@AnalyzeClasses(packages = "com.pichincha.mvc")
public class BackEndStandardArcRules {
  private final Set<String> ALLOWED_BASE_PACKAGES = new HashSet<>(
      List.of(
          "controller","util","configuration","service","domain",
          "repository","helper","exception","handler")
  );

  @ArchTest
  ArchRule serviceRules = classes()
      .that().resideInAPackage("..service..")
      .should().onlyBeAccessed().byAnyPackage("..controller..", "..handler..", "..service..");

  @ArchTest
  ArchRule repository = classes()
      .that().resideInAPackage("..repository..")
      .should().onlyBeAccessed().byAnyPackage("..service..", "..repository..");

  @ArchTest
  ArchRule layers = layeredArchitecture()
      .optionalLayer("Controller").definedBy("..controller..")
      .optionalLayer("Handler").definedBy("..handler..")
      .optionalLayer("Util").definedBy("..util..")
      .optionalLayer("Helper").definedBy("..helper..")
      .layer("Service").definedBy("..service..")
      .layer("Repository").definedBy("..repository..")
      .layer("Model").definedBy("..model..")
      .layer("Configuration").definedBy("..configuration..")

      .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
      .whereLayer("Handler").mayOnlyBeAccessedByLayers("Configuration")
      .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Service", "Handler")
      .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
      .allowEmptyShould(true);

  @ArchTest
  ArchRule implementations = classes().that().haveSimpleNameEndingWith("Impl")
      .should().resideInAPackage("..impl");


  @ArchTest
  void checkOwnInterfaceImplementations(JavaClasses classes) {
    classes.stream()
        .filter(clazz -> clazz.isInterface())
        .map(clazz -> {
          try {
            return clazz.getClass().getClassLoader().loadClass(clazz.getFullName());
          } catch (ClassNotFoundException e) {
            return null;
          }
        })
        .filter(Objects::nonNull)
        .forEach(
            clazz -> classes().that().implement(clazz).should().haveSimpleNameEndingWith("Impl")
                .allowEmptyShould(true).check(classes));

  }

  @ArchTest
  void checkBasePackages(JavaClasses classes) {
    Set<String> allPackages = new HashSet<>();
    classes.stream()
        .map(JavaClass::getPackageName)
        .forEach(allPackages::add);

    String rootPackage = allPackages.stream()
        .sorted(Comparator.comparingInt(String::length))
        .findFirst().get();

    Set<String> projectBasePackages = new HashSet<>();

    allPackages.stream()
        .filter(pk -> !pk.equals(rootPackage))
        .map(pk -> pk.substring(rootPackage.length() + 1))
        .map(pk -> pk.contains(".") ? pk.substring(0, pk.indexOf(".")) : pk)
        .forEach(projectBasePackages::add);

    Assert.assertTrue(ALLOWED_BASE_PACKAGES.containsAll(projectBasePackages));

  }

}
