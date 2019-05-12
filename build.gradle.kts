import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType
import sk.mholecy.meteorites.Clean
import sk.mholecy.meteorites.Lint

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        maven { setUrl("https://maven.fabric.io/public") }
    }

    dependencies {
        classpath(Dependencies.gradlePlugin)
        classpath(kotlin(Dependencies.Kotlin.gradlePlugin, Versions.kotlin))
        classpath(Dependencies.NavigationComponents.safeArgs)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { setUrl("https://jitpack.io") }
    }
}

plugins {
    idea
    id(Dependencies.Plugins.detekt) version Versions.detekt
    id(Dependencies.Plugins.ktlint) version Versions.ktlintGradle
    id(Dependencies.Plugins.dependencyUpdates) version Versions.dependencyUpdates
}

tasks {
    register<Clean>("clean")
    register<Lint>("lint")

    named<DependencyUpdatesTask>("dependencyUpdates") {
        group = Project.TASK_GROUP
        resolutionStrategy {
            componentSelection {
                all {
                    val rejected = listOf("alpha", "beta", "rc", "cr", "m", "preview", "testing")
                        .map { qualifier -> Regex("(?i).*[.-]$qualifier[.\\d-]*") }
                        .any { it.matches(candidate.version) }
                    if (rejected) {
                        reject("Release candidate")
                    }
                }
            }
        }
    }
}

subprojects {
    apply(plugin = Dependencies.Plugins.ktlint)

    ktlint {
        version.set(Versions.ktlint)
        ignoreFailures.set(true)
        android.set(true)
        outputToConsole.set(true)
        reporters.set(setOf(ReporterType.PLAIN, ReporterType.CHECKSTYLE))
    }
}

detekt {
    version = Versions.detekt
    input = files(rootDir)
    filters = ".*/resources/.*,.*/build/.*"
    config = files("$rootDir/detekt.yml")
    failFast = false
}
