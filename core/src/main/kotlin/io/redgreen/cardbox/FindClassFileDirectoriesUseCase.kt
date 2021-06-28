package io.redgreen.cardbox

import java.io.File
import java.nio.file.Files
import kotlin.streams.toList

class FindClassFileDirectoriesUseCase {
  companion object {
    private const val EXTENSION_CLASS = ".class"
  }

  fun invoke(workingDir: File): Set<String> {
    val normalizedWorkingDirectoryPath = workingDir.toPath().toAbsolutePath().normalize()

    return Files
      .walk(normalizedWorkingDirectoryPath)
      .filter { Files.isRegularFile(it) }
      .filter { it.toString().endsWith(EXTENSION_CLASS) }
      .map { it.parent.toAbsolutePath().toString() }
      .map { it.substring(normalizedWorkingDirectoryPath.toString().length) }
      .distinct()
      .toList()
      .toSet()
  }
}
