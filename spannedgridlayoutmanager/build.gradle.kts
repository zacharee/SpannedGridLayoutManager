import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.maven.publish)
}

android {
    compileSdk = 36

    defaultConfig {
        namespace = "com.arasthel.spannedgridlayoutmanager"
        minSdk = 21
        lint.targetSdk = 36
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

dependencies {
    implementation(fileTree("libs") { include("*.jar") })

    implementation(libs.androidx.recyclerview)
    implementation(libs.kotlin.stdlib)
}