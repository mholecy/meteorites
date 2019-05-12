package sk.mholecy.meteorites

import Project
import org.gradle.api.tasks.Delete
import org.gradle.api.tasks.TaskAction

open class Clean : Delete() {

    init {
        group = Project.TASK_GROUP
    }

    @TaskAction
    fun cleanProject() {
        delete(project.rootProject.buildDir)
        project.rootProject.subprojects.forEach {
            delete(it.buildDir)
        }
    }
}
