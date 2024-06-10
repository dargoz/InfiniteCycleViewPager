// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    id("com.jfrog.artifactory") version "5.1.10"
}


buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.4")
    }
}

tasks {
    named<org.jfrog.gradle.plugin.artifactory.task.ArtifactoryTask>("artifactoryPublish") {
        skip = true
    }
}

subprojects {
    apply(plugin = "com.jfrog.artifactory")
    apply(plugin = "maven-publish")

    println("project name ${project.name}")
    println("project version ${project.version}")
    plugins.withId("com.android.library") {
        configure<com.android.build.gradle.LibraryExtension> {
            compileSdk = 34

            defaultConfig {
                minSdk = 21

                resourceConfigurations.addAll(setOf("en", "in"))
                // Needed for jUnit4 support.
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
                isCoreLibraryDesugaringEnabled = true
            }

            testOptions {
                unitTests.isIncludeAndroidResources = false
                unitTests.isReturnDefaultValues = true
            }


        }
    }

}

configure<org.jfrog.gradle.plugin.artifactory.dsl.ArtifactoryPluginConvention> {
    clientConfig.isIncludeEnvVars = true
    clientConfig.info.addEnvironmentProperty("test.adding.dynVar", java.util.Date().toString())

    publish {
        contextUrl = "http://bcaartifactory:8080/artifactory"
        repository {
            repoKey = "RepositoryMBI" // The Artifactory repository key to publish to
            username = "mbi" // The publisher user name
            password = "Bcabca123!" // The publisher password
        }

        defaults {
            publications("publishAar")
            setPublishArtifacts(true)
            // Properties to be attached to the published artifacts.
            //properties.put("gradle.test.multi.values.key", "val1, val2, val3")
            //properties.put("gradle.test.single.value.key", "basic")
            setPublishPom(true) // Publish generated POM files to Artifactory (true by default)
        }
    }
}