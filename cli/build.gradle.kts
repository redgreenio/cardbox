plugins {
  kotlin("jvm")
}

dependencies {
  testImplementation(kotlin("test-junit5"))
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")

  testImplementation("com.google.truth:truth:1.1.2")
}
