plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.maven) apply false
    alias(libs.plugins.kotlin.android) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
