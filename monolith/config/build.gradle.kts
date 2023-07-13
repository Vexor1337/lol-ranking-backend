import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "com.porek"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation(project(":monolith:ranking:application"))
    implementation(project(":monolith:ranking:infrastructure"))
    implementation(project(":monolith:ranking:interfaces"))
    implementation(project(":monolith:ranking:ports-input"))
    implementation(project(":monolith:ranking:ports-output"))

    implementation(group= "com.oracle.database.jdbc", name= "ojdbc8", version="23.2.0.0")
    implementation(group= "com.oracle.database.jdbc", name= "ucp", version="23.2.0.0")

    implementation(group = "io.github.openfeign", name = "feign-core", version = "11.8")
    implementation(group = "io.github.openfeign", name = "feign-gson", version = "11.8")
    implementation(group = "io.github.openfeign", name = "feign-okhttp", version = "11.8")
    implementation(group = "io.github.openfeign", name = "feign-slf4j", version = "11.8")


    implementation (group= "org.springdoc", name= "springdoc-openapi-starter-webmvc-ui", version= "2.0.2")

    //implementation("io.springfox:springfox-boot-starter:3.0.0")
    //implementation ("javax.servlet:javax.servlet-api:4.0.1")

    implementation("org.liquibase:liquibase-core:4.22.0")
    implementation("org.liquibase:liquibase-gradle-plugin:2.2.0")


    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
