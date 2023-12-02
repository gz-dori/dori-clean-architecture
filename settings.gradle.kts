rootProject.name = "dori"
val prefix = "application-"
include(
    "${prefix}api",
    "${prefix}domain",
    "${prefix}http",
    "${prefix}datastore",
    "${prefix}shared"
)
