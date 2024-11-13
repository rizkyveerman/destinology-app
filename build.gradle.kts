// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21" apply false
}
