plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.dargoz.android.widget.infinitecycleviewpager"
    compileSdk = 34
    version = "1.0.0"
    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}


tasks {
    named<org.jfrog.gradle.plugin.artifactory.task.ArtifactoryTask>("artifactoryPublish") {
        dependsOn("build")
        dependsOn("releaseSourcesJar")
    }
}

configure<PublishingExtension> {

    publications {
        group = "com.dargoz.android.widget"
        register<MavenPublication>("publishAar") {
            artifact("$buildDir/libs/infinitecycleviewpager-$version-sources.jar") {
                classifier = "sources"
            }
            artifact("$buildDir/outputs/aar/infinitecycleviewpager-release.aar")
            artifactId = project.name
            version = project.version.toString()
        }
    }


}

tasks {
    named<org.jfrog.gradle.plugin.artifactory.task.ArtifactoryTask>("artifactoryPublish") {
        publications("publishAar")
    }
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}