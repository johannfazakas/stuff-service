package ro.jf.stuff.utils

import java.lang.IllegalArgumentException
import java.util.UUID

fun String?.toUUID(): UUID = this?.let { UUID.fromString(it) } ?: throw IllegalArgumentException("Missing id.")
