plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.postgresql:postgresql:42.2.27")
    implementation("io.freefair.gradle:lombok-plugin:8.4");
    implementation("org.hibernate.orm:hibernate-gradle-plugin:+")

    implementation ("org.apache.logging.log4j:log4j-api:2.21.1")
    implementation ("org.apache.logging.log4j:log4j-core:2.21.1")
    implementation("org.apache.poi:poi-ooxml:5.2.2")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}