import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.4.10"
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
	testImplementation(platform("org.junit:junit-bom:5.7.0"))
	testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
		showStandardStreams = true // This has to come after events to work
	}
}

// config JVM target to 1.8 for kotlin compilation tasks
tasks.withType<KotlinCompile>().configureEach {
	kotlinOptions.jvmTarget = "1.8"
}

// This is for our github actions CI. See kotlin.yml
tasks.register("practicekotlin") {
	dependsOn("clean", "test")
    group = "practicekotlin"
    description = "$ ./gradlew practicekotlin"
}