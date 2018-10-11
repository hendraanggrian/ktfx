group = "$RELEASE_GROUP.test"
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
}

sourceSets {
    get("main").java.srcDir("src")
}

dependencies {
    compile(project(":$ARTIFACT_DEV_RULESET_CORE"))
    compile(kotlin("stdlib", VERSION_KOTLIN))
    compile(kotlin("test", VERSION_KOTLIN))
    compile(ktlint("core"))
    compile(ktlint("test"))
    compile(truth())
    compile(junit())
}