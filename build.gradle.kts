import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    id("com.anatawa12.tools.decompileCrasher") version "1.2.3"
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "io.github.pulsebeat02"
description = "cchs-unblocker"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.googlecode.plist:dd-plist:1.23")
}

tasks {
    java {
        sourceCompatibility = JavaVersion.VERSION_16
        targetCompatibility = JavaVersion.VERSION_16
    }
    jar {
        manifest {
            attributes["Manifest-Version"] = "1.0"
            attributes["Main-Class"] = "io.github.pulsebeat02.cchsunblocker.CCHSUnblocker"
        }
    }
    named<ShadowJar>("shadowJar") {
        relocate("com.dd.plist", "io.github.pulsebeat02.cchsunblocker.lib.plist")
        relocate("com.anatawa12.tools.lib", "io.github.pulsebeat02.cchsunblocker.lib.plist.tools")
    }
    build {
        dependsOn(shadowJar)
        dependsOn(jar)
    }
}

sourceSets {
    main {
        java {
            srcDir("src/main/java")
        }
        resources {
            srcDir("src/main/resources")
        }
    }
}
