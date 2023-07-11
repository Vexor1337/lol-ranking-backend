import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
    kotlin("kapt")
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

    implementation(project(":monolith:ranking:ports-output"))

    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation(group = "io.arrow-kt", name = "arrow-core", version = "1.0.1")
    implementation(group = "io.github.openfeign", name = "feign-core", version = "11.8")
    implementation(group = "io.github.openfeign", name = "feign-gson", version = "11.8")
    implementation(group = "io.github.openfeign", name = "feign-okhttp", version = "11.8")
    implementation(group = "io.github.openfeign", name = "feign-slf4j", version = "11.8")

    implementation(group = "org.springframework.boot", name = "spring-boot-starter-data-jpa", version = "3.1.1")
    implementation(group = "org.hibernate", name = "hibernate-envers", version = "6.0.0.Final")

    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.3.Final")

    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

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
