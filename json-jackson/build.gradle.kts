plugins {
  id("java")
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

  implementation("com.fasterxml.jackson.core:jackson-core:2.14.1")
  implementation("com.fasterxml.jackson.core:jackson-annotations:2.14.1")
  implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")
  implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.1")

  compileOnly("org.projectlombok:lombok:1.18.24")
  annotationProcessor("org.projectlombok:lombok:1.18.24")

  testCompileOnly("org.projectlombok:lombok:1.18.24")
  testAnnotationProcessor("org.projectlombok:lombok:1.18.24")

  implementation("org.slf4j:slf4j-api:2.0.6")
  runtimeOnly("ch.qos.logback:logback-classic:1.4.5")

  testImplementation(platform("org.junit:junit-bom:5.9.1"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<Test> {
  useJUnitPlatform()
}
