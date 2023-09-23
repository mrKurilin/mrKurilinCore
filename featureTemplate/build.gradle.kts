plugins {
    `android-setup`
}

android {
    namespace = ProjectConfig.namespace("featureTemplate")
}

dependencies{
    implementation(project(":core:ui"))
    implementation(project(":core:di"))
    implementation(project(":core:navigation"))
}