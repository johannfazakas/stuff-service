package ro.jf.stuff.api.utils

import java.lang.IllegalArgumentException
import java.util.UUID

fun String?.toUUID(): UUID = this?.let { UUID.fromString(it) } ?: throw IllegalArgumentException("Missing id.")
