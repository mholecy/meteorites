package sk.mholecy.meteorites

import Project
import org.gradle.api.DefaultTask
import org.gradle.kotlin.dsl.configure

open class Lint : DefaultTask() {

    init {
        group = Project.TASK_GROUP

        configure {
            dependsOn("detekt")
            project.subprojects.forEach {
                dependsOn("${it.name}:ktlintCheck")
            }
        }
    }
}
