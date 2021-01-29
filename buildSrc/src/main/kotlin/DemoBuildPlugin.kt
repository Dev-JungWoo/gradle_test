import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import java.io.ByteArrayOutputStream

open class DemoBuildExtension(val project: Project) {
    var message: String? = null
}

class DemoBuildPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create<DemoBuildExtension>("demo", project)

        project.task("demoTask") {
            doLast {
                println("Message:\n${testLog(project)}")
            }
        }
    }

    private fun testLog(project: Project): String {
        var committerEmail = ""

        ByteArrayOutputStream().use { gitOutput ->
            project.exec {
                commandLine(
                    "echo", "1@example.com"
                )
                standardOutput = gitOutput
            }

            committerEmail = gitOutput.toString().trim('\n')
        }

        if (committerEmail != "1@example.com") return committerEmail

        ByteArrayOutputStream().use { gitOutput ->
            project.exec {
                commandLine(
                    "echo", "2@example.com"
                )
                standardOutput = gitOutput
            }

            committerEmail = gitOutput.toString().trim('\n')
        }

        return committerEmail
    }
}
