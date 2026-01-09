# Kotlin Script Specification: Serializable Data Class Generator

## Overview

This document specifies a Kotlin script that automatically generates `@Serializable` data classes from
Kotlin interfaces in the `com.neome.api` package. The generated classes support polymorphic JSON
serialization with custom serializers for system ID types.

**Each interface generates a separate file that mirrors the API package structure.**

---

## Purpose

- **Input**: Kotlin interfaces from `com.neome.api.*` packages (recursively traverse all nested packages)
- **Output**: Separate `.kt` files in `com.neome.core.common.api.*` mirroring the API structure
- **Key Features**:
    - One file per interface (not consolidated)
    - Mirror directory structure from `com.neome.api` to `com.neome.core.common.api`
    - Polymorphic serialization support via sealed interfaces
    - Custom serializers for system ID types (MessageId, ContactId, etc.)
    - Proper inheritance chain resolution
    - Type-safe JSON deserialization with discriminator fields

---

## File Organization Strategy

### Directory Structure Mapping

```
INPUT (API Interfaces):
com.neome.api/
├── meta/base/
│   └── dto/
│       └── DefnDtoText.kt
├── home/base/
│   └── dto/
│       ├── DtoMessagePayload.kt
│       ├── DtoMessagePayloadText.kt
│       ├── DtoMessagePayloadImage.kt
│       └── DtoMessageReaction.kt
└── home/main/
    └── sig/
        └── SigMessage.kt

OUTPUT (Generated Data Classes):
com.neome.core.common.api/
├── meta/base/
│   └── dto/
│       └── DefnDtoTextData.kt
├── home/base/
│   └── dto/
│       ├── DtoMessagePayloadData.kt        # Contains sealed interface + serializer
│       ├── DtoMessagePayloadTextData.kt    # Contains data class + sealed interface
│       ├── DtoMessagePayloadImageData.kt   # Contains data class + sealed interface
│       └── DtoMessageReactionData.kt
└── home/main/
    └── sig/
        └── SigMessageData.kt
```

### File Naming Convention

| Input Interface | Output File | Output Class |
|----------------|-------------|--------------|
| `DefnDtoText.kt` | `DefnDtoTextData.kt` | `DefnDtoTextData` |
| `SigMessage.kt` | `SigMessageData.kt` | `SigMessageData` |
| `DtoMessagePayload.kt` | `DtoMessagePayloadData.kt` | `DtoMessagePayloadSeal` + `DtoMessagePayloadSerializer` |

**Pattern**: `{InterfaceName}Data.kt` contains `{InterfaceName}Data` class

---

## Configuration

```kotlin
data class GeneratorConfig(
    // Source configuration
    val apiPackageRoot: String = "com.neome.api",
    val apiSourceRoot: String = "app/src/main/java",
    val typesFilePath: String = "com.neome.api.meta.base.Types",

    // Output configuration
    val outputPackageRoot: String = "com.neome.core.common.api",
    val outputSourceRoot: String = "app/src/main/java",

    // Serializer configuration
    val serializerPackage: String = "com.neome.core.common.serializer.sysId",

    // Polymorphic type configuration
    val polymorphicInterfaces: Set<String> = setOf("DtoMessagePayload"),

    // Discriminator field mapping: Interface -> Field name
    val discriminatorFields: Map<String, String> = mapOf(
        "DtoMessagePayload" to "messageType"
    ),

    // Type mapping: Interface -> Subtype -> Discriminator value
    val typeMappings: Map<String, Map<String, String>> = mapOf(
        "DtoMessagePayload" to mapOf(
            "DtoMessagePayloadText" to "text",
            "DtoMessagePayloadImage" to "image",
            "DtoMessagePayloadAudio" to "audio"
        )
    )
)

// Computed paths
fun GeneratorConfig.getOutputPath(apiPackagePath: String): String {
    // Convert: com.neome.api.home.base.dto -> com.neome.core.common.api.home.base.dto
    val relativePath = apiPackagePath.removePrefix("$apiPackageRoot.")
    return "$outputPackageRoot.$relativePath"
}

fun GeneratorConfig.getOutputDirectory(apiFilePath: String): File {
    // Convert: app/src/main/java/com/neome/api/home/base/dto/DefnDtoText.kt
    //     To:  app/src/main/java/com/neome/core/common/api/home/base/dto/
    val relativePath = apiFilePath.removePrefix("$apiSourceRoot/$apiPackageRoot/")
    val relativeDir = File(relativePath).parent ?: ""
    return File("$outputSourceRoot/$outputPackageRoot/$relativeDir")
}
```

---

## Algorithm Flow

### Phase 1: Discovery & Analysis

```
1. RECURSIVE SCAN PHASE
   ├─ Start from com.neome.api root directory
   ├─ Recursively traverse ALL nested directories
   ├─ For each .kt file:
   │  ├─ Parse file to extract interface declarations
   │  ├─ Record: interface name, package, file path
   │  └─ Add to interface registry
   ├─ Parse Types.kt to extract system ID types (open class declarations)
   └─ Build complete interface registry with metadata

2. INHERITANCE ANALYSIS
   ├─ For each interface in registry:
   │  ├─ Identify parent interfaces (extends clause)
   │  ├─ Identify child interfaces (interfaces extending this one)
   │  └─ Build inheritance graph
   └─ Determine polymorphic roots (interfaces with subtypes)

3. PROPERTY ANALYSIS
   For each interface:
   ├─ Extract direct properties (val/var, type, nullability)
   ├─ Resolve inherited properties from parent interfaces (walk inheritance chain)
   ├─ Determine property order (inherited first, then direct)
   ├─ Identify system ID fields (match property types against Types)
   └─ Analyze default value requirements
```

### Phase 2: Code Generation (Per Interface)

```
4. FOR EACH INTERFACE IN REGISTRY:

   a) DETERMINE FILE STRUCTURE
      ├─ Calculate output package (mirror API package)
      ├─ Calculate output directory (mirror API directory structure)
      ├─ Calculate output file name ({Interface}Data.kt)
      └─ Create output directory if not exists

   b) GENERATE FILE CONTENTS
      ├─ Package declaration
      ├─ Import statements (organized by category)
      ├─ Sealed interface (if polymorphic root OR polymorphic subtype)
      ├─ Data class
      └─ Polymorphic serializer (if polymorphic root)

   c) WRITE FILE
      ├─ Create/overwrite output file
      ├─ Write generated content
      └─ Format code (indentation, spacing)
```

### Phase 3: Validation & Reporting

```
5. VALIDATION PHASE
   ├─ Verify all interfaces have corresponding data class files
   ├─ Check for compilation errors (optional - requires kotlinc)
   ├─ Verify directory structure mirrors API structure
   └─ Check for missing imports or serializers

6. REPORTING
   ├─ Log generated file count
   ├─ Log any errors or warnings
   ├─ Generate summary report
   └─ List all generated files with paths
```

---

## Per-File Content Generation Rules

### File Structure Template

Each generated file follows this structure:

```kotlin
package com.neome.core.common.api.{mirrored.package.path}

// ============================================
// IMPORTS - API Interfaces
// ============================================
import com.neome.api.{original.package}.{InterfaceName}
import com.neome.api.{other.packages}.{OtherInterfaces}
// ... more API imports

// ============================================
// IMPORTS - System ID Serializers
// ============================================
import com.neome.core.common.serializer.sysId.MessageIdSer
import com.neome.core.common.serializer.sysId.ContactIdSer
// ... more serializer imports (only if used in this file)

// ============================================
// IMPORTS - Kotlin Serialization
// ============================================
import kotlinx.serialization.Serializable
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
// ... more serialization imports (only if needed)

// ============================================
// IMPORTS - Generated Data Classes
// ============================================
import com.neome.core.common.api.{other.package}.{OtherData}
// ... imports for referenced generated classes


// ============================================
// SEALED INTERFACE (if polymorphic root)
// ============================================
@Serializable(with = {Interface}Serializer::class)
sealed interface {Interface}Seal : {Interface}


// ============================================
// SEALED INTERFACE (if polymorphic subtype)
// ============================================
@Serializable
sealed interface {Interface}Seal : {Interface}


// ============================================
// DATA CLASS
// ============================================
@Serializable
data class {Interface}Data(
    // ... properties
) : {InheritanceClause}


// ============================================
// POLYMORPHIC SERIALIZER (if polymorphic root)
// ============================================
object {Interface}Serializer : JsonContentPolymorphicSerializer<{Interface}Seal>(
    {Interface}Seal::class
) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<{Interface}Seal> {
        // ... implementation
    }
}
```

---

## Content Generation Rules by File Type

### Type 1: Simple Interface (No Inheritance, Not Polymorphic)

**Example**: `DefnDtoText.kt` → `DefnDtoTextData.kt`

```kotlin
package com.neome.core.common.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoText
import kotlinx.serialization.Serializable

@Serializable
data class DefnDtoTextData(
    override var value: Array<String>?
) : DefnDtoText
```

**Generation Rules**:
- Simple package + imports + data class
- No sealed interface
- No polymorphic serializer

### Type 2: Polymorphic Root Interface

**Example**: `DtoMessagePayload.kt` → `DtoMessagePayloadData.kt`

```kotlin
package com.neome.core.common.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.meta.base.Types
import com.neome.core.common.api.home.base.dto.DtoMessagePayloadTextData
import com.neome.core.common.api.home.base.dto.DtoMessagePayloadImageData
import com.neome.core.common.api.home.base.dto.DtoMessagePayloadAudioData
import com.neome.core.common.serializer.sysId.ContactIdSer
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable(with = DtoMessagePayloadSerializer::class)
sealed interface DtoMessagePayloadSeal : DtoMessagePayload

object DtoMessagePayloadSerializer : JsonContentPolymorphicSerializer<DtoMessagePayloadSeal>(
    DtoMessagePayloadSeal::class
) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<DtoMessagePayloadSeal> {
        val messageType = element.jsonObject["messageType"]?.jsonPrimitive?.content
        return when (messageType) {
            "text", EnumMessageType.text.value -> DtoMessagePayloadTextData.serializer()
            "image", EnumMessageType.image.value -> DtoMessagePayloadImageData.serializer()
            "audio", EnumMessageType.audio.value -> DtoMessagePayloadAudioData.serializer()
            else -> DtoMessagePayloadSeal.serializer()
        }
    }
}
```

**Generation Rules**:
- Include sealed interface with serializer annotation
- Include polymorphic serializer object
- Import all subtype data classes
- Import JsonContentPolymorphicSerializer and related classes

### Type 3: Polymorphic Subtype Interface

**Example**: `DtoMessagePayloadText.kt` → `DtoMessagePayloadTextData.kt`

```kotlin
package com.neome.core.common.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessagePayloadText
import com.neome.api.meta.base.Types.ContactId
import com.neome.core.common.serializer.sysId.ContactIdSer
import kotlinx.serialization.Serializable

@Serializable
sealed interface DtoMessagePayloadTextSeal : DtoMessagePayloadText

@Serializable
data class DtoMessagePayloadTextData(
    override var isForwarded: Boolean? = null,
    override var mentionMap: Map<String, @Serializable(with = ContactIdSer::class) ContactId>? = null,
    override var messageType: EnumMessageType = EnumMessageType.text,
    override var isUpdated: Boolean? = null,
    override var text: String,
) : DtoMessagePayloadSeal, DtoMessagePayloadTextSeal
```

**Generation Rules**:
- Include sealed interface (no serializer annotation)
- Data class implements BOTH parent sealed interface AND own sealed interface
- Import parent sealed interface from its file: `import com.neome.core.common.api.home.base.dto.DtoMessagePayloadSeal`
- Include all properties from entire inheritance chain

### Type 4: Interface with Inheritance (Not Polymorphic)

**Example**: Interface `B` extends interface `A`, but `A` has no other subtypes

```kotlin
package com.neome.core.common.api.example

import com.neome.api.example.InterfaceB
import com.neome.core.common.api.example.InterfaceAData
import kotlinx.serialization.Serializable

@Serializable
data class InterfaceBData(
    override val propFromA: String,  // From parent
    override val propFromB: Int      // From this interface
) : InterfaceB
```

**Generation Rules**:
- No sealed interface (not polymorphic)
- Include all inherited properties
- Import parent interface's data class if used as property type

---

## Data Class Generation Rules (Unchanged from Before)

### Rule 1: Basic Naming Convention

**Pattern**: `{InterfaceName}Data`

### Rule 2: Sealed Interface Creation

**When**: Interface has subtypes (polymorphic root) OR interface extends a polymorphic root

**Polymorphic root**:
```kotlin
@Serializable(with = {Interface}Serializer::class)
sealed interface {Interface}Seal : {Interface}
```

**Polymorphic subtype**:
```kotlin
@Serializable
sealed interface {Interface}Seal : {Interface}
```

### Rule 3: Property Resolution

```kotlin
// Include ALL properties from inheritance chain
// Order: Inherited (defaults first, required last) → Direct (defaults first, required last)
@Serializable
data class ExampleData(
    override val inheritedOptional: String? = null,  // Inherited with default
    override val inheritedRequired: String,          // Inherited required
    override val directOptional: Int? = null,        // Direct with default
    override val directRequired: Int                 // Direct required
) : ParentSeal, ExampleSeal
```

### Rule 4: val/var Matching

**MUST match interface declaration EXACTLY**

### Rule 5: Default Value Assignment

Same algorithm as before:
1. Nullable (`Type?`) → `= null`
2. Enum discriminator → `= Enum.{matchingValue}`
3. Required (no `?`) → NO default
4. Optional `String` → `= ""`
5. Numeric nullable → `= null`

### Rule 6: Type Substitution

**Decision Tree**:
1. **Polymorphic type?** → Use `{Type}Seal` (import from generated file)
2. **Simple interface?** → Use `{Type}Data` (import from generated file)
3. **System ID?** → Keep as `Types.{TypeName}` + add serializer
4. **Otherwise** → Keep original type

### Rule 7: System ID Serializer Application

Same rules as before - apply `@Serializable(with = {Type}Ser::class)` annotation

---

## Import Generation Rules

### Import Categories (Ordered)

1. **API Interface Imports**
   ```kotlin
   import com.neome.api.{package}.{InterfaceName}
   ```

2. **Generated Data Class Imports** (NEW - for separate files)
   ```kotlin
   import com.neome.core.common.api.{package}.{DataClassName}
   import com.neome.core.common.api.{package}.{SealInterfaceName}
   ```

3. **System ID Serializer Imports**
   ```kotlin
   import com.neome.core.common.serializer.sysId.{Type}Ser
   ```

4. **Kotlin Serialization Imports**
   ```kotlin
   import kotlinx.serialization.Serializable
   import kotlinx.serialization.DeserializationStrategy
   // ... only import what's used in THIS file
   ```

### Import Resolution Algorithm

```kotlin
fun generateImports(interface: InterfaceInfo): List<String> {
    val imports = mutableSetOf<String>()

    // 1. Import the interface itself
    imports.add("import ${interface.fullPackageName}.${interface.name}")

    // 2. Import parent interfaces (if any)
    interface.parentInterfaces.forEach { parent ->
        imports.add("import ${parent.fullPackageName}.${parent.name}")

        // If parent is polymorphic, import parent's Seal interface
        if (parent.isPolymorphic) {
            val parentOutputPackage = getOutputPackage(parent.packageName)
            imports.add("import $parentOutputPackage.${parent.name}Seal")
        }
    }

    // 3. Import property types (if they are interfaces)
    interface.allProperties.forEach { prop ->
        if (prop.type.isInterface && prop.type.isInApiPackage) {
            val outputPackage = getOutputPackage(prop.type.packageName)

            if (prop.type.isPolymorphic) {
                imports.add("import $outputPackage.${prop.type.name}Seal")
            } else {
                imports.add("import $outputPackage.${prop.type.name}Data")
            }
        }
    }

    // 4. Import system ID serializers
    interface.allProperties.forEach { prop ->
        if (prop.type.isSystemId || prop.type.containsSystemIdInGenerics) {
            prop.type.getAllSystemIdTypes().forEach { sysIdType ->
                imports.add("import ${config.serializerPackage}.${sysIdType}Ser")
            }
        }
    }

    // 5. Import serialization classes
    imports.add("import kotlinx.serialization.Serializable")

    if (interface.isPolymorphicRoot) {
        imports.add("import kotlinx.serialization.DeserializationStrategy")
        imports.add("import kotlinx.serialization.json.JsonContentPolymorphicSerializer")
        imports.add("import kotlinx.serialization.json.JsonElement")
        imports.add("import kotlinx.serialization.json.jsonObject")
        imports.add("import kotlinx.serialization.json.jsonPrimitive")

        // Import subtype data classes
        interface.childInterfaces.forEach { child ->
            val childOutputPackage = getOutputPackage(child.packageName)
            imports.add("import $childOutputPackage.${child.name}Data")
        }
    }

    return imports.sorted()
}
```

---

## Polymorphic Serializer Generation (Per Root Interface)

Same pattern as before, but note:
- Serializer is in the SAME file as the polymorphic root sealed interface
- Imports subtype Data classes from their respective files

---

## Directory & File Management

### Create Output Directory Structure

```kotlin
fun createOutputDirectories(interfaces: List<InterfaceInfo>, config: GeneratorConfig) {
    interfaces.forEach { interface ->
        val outputDir = config.getOutputDirectory(interface.filePath)
        if (!outputDir.exists()) {
            outputDir.mkdirs()
            println("Created directory: ${outputDir.absolutePath}")
        }
    }
}
```

### Generate Output File Path

```kotlin
fun getOutputFilePath(interface: InterfaceInfo, config: GeneratorConfig): String {
    val outputDir = config.getOutputDirectory(interface.filePath)
    val outputFileName = "${interface.name}Data.kt"
    return File(outputDir, outputFileName).absolutePath
}
```

---

## Complete Example: Multi-File Generation

### Input Files

**File 1**: `com/neome/api/meta/base/dto/DefnDtoText.kt`
```kotlin
package com.neome.api.meta.base.dto

interface DefnDtoText {
    val value: Array<String>?
}
```

**File 2**: `com/neome/api/home/base/dto/DtoMessagePayload.kt`
```kotlin
package com.neome.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType

interface DtoMessagePayload {
    var isForwarded: Boolean?
    var messageType: EnumMessageType
}
```

**File 3**: `com/neome/api/home/base/dto/DtoMessagePayloadText.kt`
```kotlin
package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.ContactId

interface DtoMessagePayloadText : DtoMessagePayload {
    var text: String
    var mentionMap: Map<String, ContactId>?
}
```

**File 4**: `com/neome/api/home/main/sig/SigMessage.kt`
```kotlin
package com.neome.api.home.main.sig

import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.meta.base.Types.*

interface SigMessage {
    var messageId: MessageId
    var senderId: EntUserId
    var payload: DtoMessagePayload
    var creationTime: String
}
```

### Generated Files

**Generated 1**: `com/neome/core/common/api/meta/base/dto/DefnDtoTextData.kt`
```kotlin
package com.neome.core.common.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoText
import kotlinx.serialization.Serializable

@Serializable
data class DefnDtoTextData(
    override var value: Array<String>?
) : DefnDtoText
```

**Generated 2**: `com/neome/core/common/api/home/base/dto/DtoMessagePayloadData.kt`
```kotlin
package com.neome.core.common.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.core.common.api.home.base.dto.DtoMessagePayloadTextData
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable(with = DtoMessagePayloadSerializer::class)
sealed interface DtoMessagePayloadSeal : DtoMessagePayload

object DtoMessagePayloadSerializer : JsonContentPolymorphicSerializer<DtoMessagePayloadSeal>(
    DtoMessagePayloadSeal::class
) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<DtoMessagePayloadSeal> {
        val messageType = element.jsonObject["messageType"]?.jsonPrimitive?.content
        return when (messageType) {
            "text", EnumMessageType.text.value -> DtoMessagePayloadTextData.serializer()
            else -> DtoMessagePayloadSeal.serializer()
        }
    }
}
```

**Generated 3**: `com/neome/core/common/api/home/base/dto/DtoMessagePayloadTextData.kt`
```kotlin
package com.neome.core.common.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoMessagePayloadText
import com.neome.api.meta.base.Types.ContactId
import com.neome.core.common.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.sysId.ContactIdSer
import kotlinx.serialization.Serializable

@Serializable
sealed interface DtoMessagePayloadTextSeal : DtoMessagePayloadText

@Serializable
data class DtoMessagePayloadTextData(
    override var isForwarded: Boolean? = null,
    override var messageType: EnumMessageType = EnumMessageType.text,
    override var text: String,
    override var mentionMap: Map<String, @Serializable(with = ContactIdSer::class) ContactId>? = null,
) : DtoMessagePayloadSeal, DtoMessagePayloadTextSeal
```

**Generated 4**: `com/neome/core/common/api/home/main/sig/SigMessageData.kt`
```kotlin
package com.neome.core.common.api.home.main.sig

import com.neome.api.home.main.sig.SigMessage
import com.neome.api.meta.base.Types
import com.neome.core.common.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MessageIdSer
import kotlinx.serialization.Serializable

@Serializable
data class SigMessageData(
    @Serializable(with = MessageIdSer::class)
    override var messageId: Types.MessageId,
    @Serializable(with = EntUserIdSer::class)
    override var senderId: Types.EntUserId,
    override var payload: DtoMessagePayloadSeal,
    override var creationTime: String
) : SigMessage
```

---

## Edge Cases & Error Handling

| Edge Case | Handling Strategy |
|-----------|------------------|
| **Nested package depth** | Recursively create all parent directories |
| **Interface in default package** | Log warning, skip (requires package declaration) |
| **Duplicate interface names in different packages** | Handle separately - package distinguishes them |
| **Circular dependencies** | Allow - Kotlin handles forward references |
| **Missing parent interface** | Log error, skip this interface |
| **Interface extends external interface** | Import external interface, no Seal needed |
| **File already exists** | Overwrite with warning |
| **Invalid interface name** | Log error, skip |
| **No properties in interface** | Generate empty data class |

---

## Validation & Testing

### Post-Generation Validation

```kotlin
fun validateGeneratedFiles(generatedFiles: List<File>) {
    // 1. Directory structure check
    assert(generatedFiles.all { it.exists() })

    // 2. Package declaration check
    generatedFiles.forEach { file ->
        val content = file.readText()
        assert(content.startsWith("package com.neome.core.common.api."))
    }

    // 3. Interface coverage check
    val allInterfaces = scanApiInterfaces()
    val generatedClasses = generatedFiles.map { parseClassName(it) }
    assert(allInterfaces.all { "${it.name}Data" in generatedClasses })

    // 4. Import validity check (no circular imports)
    generatedFiles.forEach { file ->
        val imports = extractImports(file)
        assert(imports.none { it.contains("..") || it.endsWith(".") })
    }
}
```

---

## Script Implementation Checklist

- [ ] Set up project structure
- [ ] Implement GeneratorConfig with path computation methods
- [ ] Implement Phase 1: Discovery & Analysis
    - [ ] Recursive directory scanner
    - [ ] Interface parser (per file)
    - [ ] System ID type extractor
    - [ ] Inheritance graph builder
    - [ ] Property resolver
- [ ] Implement Phase 2: Per-File Generation
    - [ ] Output path calculator
    - [ ] Directory creator
    - [ ] Package declaration generator
    - [ ] Import generator (with cross-file references)
    - [ ] Sealed interface generator
    - [ ] Data class generator
    - [ ] Polymorphic serializer generator
    - [ ] File writer
- [ ] Implement Phase 3: Validation & Reporting
    - [ ] File existence validator
    - [ ] Import validator
    - [ ] Coverage validator
    - [ ] Report generator
- [ ] Add logging and error reporting
- [ ] Create CLI interface
- [ ] Write unit tests
- [ ] Write integration tests
- [ ] Document usage

---

## Usage Example

```kotlin
fun main() {
    val config = GeneratorConfig(
        apiPackageRoot = "com.neome.api",
        apiSourceRoot = "app/src/main/java",
        outputPackageRoot = "com.neome.core.common.api",
        outputSourceRoot = "app/src/main/java",
        polymorphicInterfaces = setOf("DtoMessagePayload"),
        discriminatorFields = mapOf("DtoMessagePayload" to "messageType"),
        typeMappings = mapOf(
            "DtoMessagePayload" to mapOf(
                "DtoMessagePayloadText" to "text",
                "DtoMessagePayloadImage" to "image",
                "DtoMessagePayloadAudio" to "audio"
            )
        )
    )

    val generator = SerializableClassGenerator(config)
    val generatedFiles = generator.generate()

    println("Generated ${generatedFiles.size} files:")
    generatedFiles.forEach { file ->
        println("  - ${file.relativeTo(File(config.outputSourceRoot))}")
    }
}
```

**Output**:
```
Generated 142 files:
  - com/neome/core/common/api/meta/base/dto/DefnDtoTextData.kt
  - com/neome/core/common/api/home/base/dto/DtoMessagePayloadData.kt
  - com/neome/core/common/api/home/base/dto/DtoMessagePayloadTextData.kt
  - com/neome/core/common/api/home/base/dto/DtoMessagePayloadImageData.kt
  - com/neome/core/common/api/home/main/sig/SigMessageData.kt
  ... (137 more files)
```

---

## Benefits of Separate Files

1. **Modularity**: Easy to find and edit specific data classes
2. **Clear ownership**: Each interface has exactly one corresponding file
3. **Incremental generation**: Only regenerate changed interfaces
4. **Better IDE support**: Jump to definition works across files
5. **Easier code review**: Changes are isolated to specific files
6. **Parallel generation**: Can generate multiple files concurrently
7. **Reduced merge conflicts**: Multiple developers can work on different interfaces

---

## Known Limitations

1. **Manual polymorphic configuration**: Still requires manual setup
2. **No auto-detection of discriminators**: Must be configured
3. **Full regeneration**: Always regenerates all files (future: incremental)
4. **No cleanup of orphaned files**: If interface is deleted, data class file remains

---

## Future Enhancements

1. **Incremental generation**: Track file timestamps, only regenerate if source changed
2. **Orphan cleanup**: Delete generated files for deleted interfaces
3. **Parallel file generation**: Generate multiple files concurrently (ThreadPool)
4. **AST-based parsing**: Use Kotlin compiler APIs for robustness
5. **Auto-detect polymorphic types**: Analyze subtypes automatically
6. **Gradle plugin**: Integrate as Gradle task
7. **Watch mode**: Auto-regenerate on API file changes
8. **Dry-run mode**: Preview what will be generated without writing files

---

## References

- **Kotlin Serialization Guide**: https://kotlinlang.org/docs/serialization.html
- **Polymorphic Serialization**: https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/polymorphism.md
- **Project CLAUDE.md**: Architecture rules and conventions
- **SerializationDtos.kt**: Original consolidated implementation reference
