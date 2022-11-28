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

  //implementation("de.ruedigermoeller:fst:2.57")
  implementation("de.ruedigermoeller:fst:3.0.4-jdk17")


  compileOnly("org.projectlombok:lombok:1.18.24")
  annotationProcessor("org.projectlombok:lombok:1.18.24")

  testCompileOnly("org.projectlombok:lombok:1.18.24")
  testAnnotationProcessor("org.projectlombok:lombok:1.18.24")

  implementation("org.slf4j:slf4j-api:2.0.3")
  runtimeOnly("ch.qos.logback:logback-classic:1.4.5")

  testImplementation(platform("org.junit:junit-bom:5.9.1"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<Test> {
  useJUnitPlatform()
  jvmArgs("--add-opens", "java.base/java.lang=ALL-UNNAMED")
  jvmArgs("--add-opens", "java.base/java.math=ALL-UNNAMED")
  jvmArgs("--add-opens", "java.base/java.util=ALL-UNNAMED")
  jvmArgs("--add-opens", "java.base/java.util.concurrent=ALL-UNNAMED")
  jvmArgs("--add-opens", "java.base/java.net=ALL-UNNAMED")
  jvmArgs("--add-opens", "java.base/java.text=ALL-UNNAMED")
  jvmArgs("--add-opens", "java.sql/java.sql=ALL-UNNAMED")
  jvmArgs("--add-opens", "java.base/java.time=ALL-UNNAMED")
}
