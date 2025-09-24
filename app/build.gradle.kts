plugins {
    // Apply the shared build logic from a convention plugin.
    // The shared code is located in `buildSrc/src/main/kotlin/kotlin-jvm.gradle.kts`.
    alias(libs.plugins.kotlinPlugin)
    // Apply the Application plugin to add support for building an executable JVM application.
    application
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(libs.junitApi)
    testRuntimeOnly(libs.jUnitEngine)
}

application {
    // Define the Fully Qualified Name for the application main class
    // (Note that Kotlin compiles `App.kt` to a class with FQN `com.example.app.AppKt`.)
    mainClass = "org.example.app.AppKt"
}

tasks.test {
    useJUnitPlatform()
}
