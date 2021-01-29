
/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    // Support convention plugins written in Kotlin. Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        create("demoBuildPlugin") {
            id = "com.jung.demoBuildPlugin"
            implementationClass = "DemoBuildPlugin"
        }
    }
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
    testImplementation("junit:junit:4.12")
}