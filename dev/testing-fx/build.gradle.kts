group = "$RELEASE_GROUP.test"
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
}

sourceSets {
    get("main").java.srcDir("src")
}

dependencies {
    compile(project(":$ARTIFACT_DEV_TESTING_CORE"))
    compile(testFx("core"))
    compile(testFx("junit"))
}