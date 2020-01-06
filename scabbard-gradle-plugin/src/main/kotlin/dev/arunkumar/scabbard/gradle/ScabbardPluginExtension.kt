package dev.arunkumar.scabbard.gradle

import org.gradle.api.Project

/**
 * Scabbard plugin extension that configures the project.
 */
open class ScabbardPluginExtension(val project: Project) {
  open var enabled = true
  open var failOnError = false
  open var fullBindingGraphValidation = false

  inline fun ifEnabled(block: () -> Unit) {
    if (enabled) {
      block()
    }
  }
}