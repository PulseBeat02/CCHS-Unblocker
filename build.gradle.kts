plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.googlecode.plist:dd-plist:1.23")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}