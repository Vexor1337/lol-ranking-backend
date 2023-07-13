rootProject.name = "lol"
include(
    "monolith:ranking:application",
    "monolith:ranking:infrastructure",
    "monolith:ranking:interfaces",
    "monolith:ranking:ports-input",
    "monolith:ranking:ports-output",

    "monolith:commons",
    "monolith:commons:arrow",

    "monolith:config",
)
