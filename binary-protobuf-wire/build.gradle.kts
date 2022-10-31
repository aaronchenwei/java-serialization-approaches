plugins {
  id("java")
  id("com.squareup.wire") version ("4.4.2")
}

group = "io.github.aaronchenwei.example"
version = "0.0.1-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(project(":common-dto"))

  implementation("com.squareup.wire:wire-runtime:4.4.3")

  compileOnly("org.projectlombok:lombok:1.18.24")
  annotationProcessor("org.projectlombok:lombok:1.18.24")

  testCompileOnly("org.projectlombok:lombok:1.18.24")
  testAnnotationProcessor("org.projectlombok:lombok:1.18.24")

  implementation("org.slf4j:slf4j-api:2.0.3")
  runtimeOnly("ch.qos.logback:logback-classic:1.4.3")

  testImplementation(platform("org.junit:junit-bom:5.9.1"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

wire {
  java {}
}

tasks.withType<Test> {
  useJUnitPlatform()
}
