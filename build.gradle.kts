plugins {
    java
}

group = "com.dev_rohit"
version = "1.0.0"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT")
    // compileOnly("net.citizensnpcs:citizens:2.0.39") // optional if you add Citizens API to your repo
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}
