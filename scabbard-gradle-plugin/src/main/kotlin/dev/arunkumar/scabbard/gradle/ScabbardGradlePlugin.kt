package dev.arunkumar.scabbard.gradle

import dev.arunkumar.scabbard.gradle.processor.ScabbardProcessorManager
import dev.arunkumar.scabbard.gradle.propertiesdelegate.ScabbardPropertiesDelegate
import org.gradle.api.Plugin
import org.gradle.api.Project

class ScabbardGradlePlugin : Plugin<Project> {

  override fun apply(project: Project) {
    val extension = project.extensions.create(
      SCABBARD,
      ScabbardPluginExtension::class.java,
      project
    )
    project.afterEvaluate {
      ScabbardPropertiesDelegate(extension).delegate()
      ScabbardProcessorManager(extension).manage()
    }
  }

  companion object {
    internal const val SCABBARD = "scabbard"
    internal const val SCABBARD_PLUGIN_ID = "scabbard.gradle"
  }
}