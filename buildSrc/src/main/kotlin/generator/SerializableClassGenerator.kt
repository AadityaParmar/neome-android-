package generator

import java.io.File

/**
 * Represents a Kotlin property
 */
data class PropertyInfo(
    val name: String,
    val type: String,
    val isVar: Boolean,
    val isNullable: Boolean,
    val defaultValue: String? = null
)

/**
 * Represents a Kotlin interface
 */
data class InterfaceInfo(
    val name: String,
    val packageName: String,
    val filePath: String,
    val properties: List<PropertyInfo>,
    val parentInterfaces: List<String> = emptyList(),
    val childInterfaces: MutableList<String> = mutableListOf(),
    var isPolymorphicRoot: Boolean = false
) {
    val fullQualifiedName: String
        get() = "$packageName.$name"

    // Cached all properties (including inherited)
    var allProperties: List<PropertyInfo>? = null
}

/**
 * Main generator class
 */
class SerializableClassGenerator(
    private val projectRoot: File,
    private val config: SerializableClassGeneratorConfig = SerializableClassGeneratorConfig()
) {
    private val interfaceRegistry = mutableMapOf<String, InterfaceInfo>()
    private val sysIdTypes = mutableSetOf<String>()
    private val enumTypeLocations = mutableMapOf<String, String>() // EnumName -> Package
    private val nucleusAnyValueClassesSet = mutableSetOf<String>() // AnyOtpValue, AnyPrefixKey, AppVersion

    fun generate(): List<File> {
        println("=== Serializable Data Class Generator ===")
        println("API Package: ${config.apiPackageRoot}")
        println("Output Package: ${config.outputPackageRoot}")

        // Phase 0: Generate SysId Serializers
        println("\n[Phase 0] Generate SysId Serializers")
        generateSysIdSerializers()

        // Phase 1: Discovery & Analysis
        println("\n[Phase 1] Discovery & Analysis")
        extractSystemIdTypes()
        scanInterfaces()
        analyzeInheritance()

        println("Found ${interfaceRegistry.size} interfaces")
        println("Found ${sysIdTypes.size} System ID types")

        // Phase 2: Code Generation
        println("\n[Phase 2] Code Generation")
        val generatedFiles = mutableListOf<File>()
        interfaceRegistry.values.forEach { interfaceInfo ->
            // Skip interfaces in the skip list
            if (interfaceInfo.name in config.skipInterfaces) {
                println("Skipped: ${interfaceInfo.name}")
                // Delete existing generated file if it exists
                val outputDir = config.getOutputDirectory(interfaceInfo.filePath)
                val existingFile = File(outputDir, "${interfaceInfo.name}Data.kt")
                if (existingFile.exists()) {
                    existingFile.delete()
                    println("Deleted existing: ${existingFile.absolutePath}")
                }
                return@forEach
            }

            val file = generateFile(interfaceInfo)
            generatedFiles.add(file)
            println("Generated: ${file.relativeTo(projectRoot)}")
        }

        // Phase 3: Validation & Reporting
        println("\n[Phase 3] Validation & Reporting")
        println("Total files generated: ${generatedFiles.size}")

        return generatedFiles
    }

    private fun generateSysIdSerializers() {
        // Parse both Types.kt files for SysId and AnyValue classes
        val metaTypesFile =
            File(projectRoot, "${config.apiSourceRoot}/${config.metaTypesFilePath.replace('.', '/')}.kt")
        val nucleusTypesFile =
            File(projectRoot, "${config.apiSourceRoot}/${config.nucleusTypesFilePath.replace('.', '/')}.kt")

        if (!metaTypesFile.exists()) {
            println("Warning: meta/base/Types.kt not found at ${metaTypesFile.absolutePath}")
            return
        }

        println("Parsing Types.kt files for SysId and AnyValue classes...")

        // Regex patterns for extraction
        val openClassRegex = Regex("""^\s*open class (\w+)\s*:\s*(\w+)""")
        val classRegex = Regex("""^\s*class (\w+)\s*:\s*(\w+)""")
        val sysIdPatternRegex =
            Regex("""(SysId|ArtifactId|ChatId|ContactId|InboxId|MediaId|MetaId|MetaIdComp|MetaIdComposite|MetaIdPipelineParam)""")
        val anyValuePatternRegex = Regex("""(AnyValue|AnyKey)""")

        val sysIdClassNames = mutableListOf<String>()
        val metaAnyValueClasses = mutableListOf<String>() // AnyValue classes from meta/base/Types.kt
        val nucleusAnyValueClasses = mutableListOf<String>() // AnyValue classes from nucleus/base/Types.kt

        // Parse meta/base/Types.kt for SysId classes
        println("Parsing ${metaTypesFile.name}...")
        metaTypesFile.readLines().forEach { line ->
            // Check for open class (SysId types)
            openClassRegex.find(line)?.let { match ->
                val className = match.groupValues[1]
                val parentClass = match.groupValues[2]
                if (sysIdPatternRegex.containsMatchIn(parentClass) || parentClass == "SysId") {
                    sysIdClassNames.add(className)
                    sysIdTypes.add(className)
                }
            }
            // Check for class (AnyValue types in Types.kt)
            classRegex.find(line)?.let { match ->
                val className = match.groupValues[1]
                val parentClass = match.groupValues[2]
                if (anyValuePatternRegex.containsMatchIn(parentClass)) {
                    metaAnyValueClasses.add(className)
                    sysIdTypes.add(className)
                }
            }
        }

        // Parse nucleus/base/Types.kt for AnyValue classes
        if (nucleusTypesFile.exists()) {
            println("Parsing ${nucleusTypesFile.name}...")
            nucleusTypesFile.readLines().forEach { line ->
                classRegex.find(line)?.let { match ->
                    val className = match.groupValues[1]
                    val parentClass = match.groupValues[2]
                    if (anyValuePatternRegex.containsMatchIn(parentClass)) {
                        nucleusAnyValueClasses.add(className)
                        nucleusAnyValueClassesSet.add(className) // Track for full qualification
                        sysIdTypes.add(className)
                    }
                }
            }
        }

        // Add individual AnyValue class files from config
        val individualAnyValueClasses = config.individualAnyValueClasses.toList().sorted()
        sysIdTypes.addAll(individualAnyValueClasses)

        sysIdClassNames.sort()
        metaAnyValueClasses.sort()
        nucleusAnyValueClasses.sort()

        println("Found ${sysIdClassNames.size} SysId classes")
        println("Found ${individualAnyValueClasses.size} individual AnyValue classes")
        println("Found ${metaAnyValueClasses.size} AnyValue classes in meta/base/Types.kt")
        println("Found ${nucleusAnyValueClasses.size} AnyValue classes in nucleus/base/Types.kt")

        // Generate output file
        val outputFile = File(
            projectRoot,
            "${config.apiSourceRoot}/com/neome/core/common/serializer/sysId/SerializerSysIdGenerated.kt"
        )

        val content = buildString {
            // Header
            appendLine("// Auto-generated file. Do not edit manually.")
            appendLine("// Generated by SerializableClassGenerator")
            appendLine()
            appendLine("package com.neome.core.common.serializer.sysId")
            appendLine()
            appendLine("// SysId imports")
            appendLine("import com.neome.api.meta.base.Types")
            appendLine()

            // Import individual AnyValue classes (from separate files in meta.base)
            appendLine("// AnyValue class imports (individual files)")
            individualAnyValueClasses.forEach { className ->
                appendLine("import com.neome.api.meta.base.$className")
            }
            appendLine()

            // Import AnyValue classes from meta/base/Types.kt
            if (metaAnyValueClasses.isNotEmpty()) {
                appendLine("// AnyValue class imports (from meta/base/Types.kt)")
                metaAnyValueClasses.forEach { className ->
                    appendLine("import com.neome.api.meta.base.Types.$className")
                }
                appendLine()
            }

            // Import AnyValue classes from nucleus/base/Types.kt
            if (nucleusAnyValueClasses.isNotEmpty()) {
                appendLine("// AnyValue class imports (from nucleus/base/Types.kt)")
                nucleusAnyValueClasses.forEach { className ->
                    appendLine("import com.neome.api.nucleus.base.Types.$className")
                }
                appendLine()
            }

            // Generate SysId serializer objects
            sysIdClassNames.forEach { className ->
                appendLine("object ${className}Ser : SysIdSerializer<Types.$className>(\"$className\")")
            }

            appendLine()

            // Generate serializer objects for individual classes
            individualAnyValueClasses.forEach { className ->
                if (className == "SysId") {
                    // SysId uses SysIdSerializer, not AnyValueSerializer
                    appendLine("object ${className}Ser : SysIdSerializer<$className>(\"$className\")")
                } else {
                    appendLine("object ${className}Ser : AnyValueSerializer<$className>(\"$className\", $className::class.java)")
                }
            }

            // Generate AnyValue serializer objects for meta/base/Types.kt classes
            metaAnyValueClasses.forEach { className ->
                appendLine("object ${className}Ser : AnyValueSerializer<$className>(\"$className\", $className::class.java)")
            }

            // Generate AnyValue serializer objects for nucleus/base/Types.kt classes
            nucleusAnyValueClasses.forEach { className ->
                appendLine("object ${className}Ser : AnyValueSerializer<$className>(\"$className\", $className::class.java)")
            }
        }

        outputFile.parentFile.mkdirs()
        outputFile.writeText(content)
        println("Generated ${outputFile.relativeTo(projectRoot)}")

        val totalAnyValue = individualAnyValueClasses.size + metaAnyValueClasses.size + nucleusAnyValueClasses.size
        println("SysId serializers: ${sysIdClassNames.size}")
        println("AnyValue serializers: $totalAnyValue")
        println("Total serializers: ${sysIdClassNames.size + totalAnyValue}")
    }

    private fun extractSystemIdTypes() {
        // SysId types are already populated by generateSysIdSerializers()
        // Just scan enum types now
        scanEnumTypes()
    }

    private fun scanEnumTypes() {
        val apiDir = File(projectRoot, "${config.apiSourceRoot}/${config.apiPackageRoot.replace('.', '/')}")
        apiDir.walkTopDown()
            .filter { it.isFile && it.name == "Types.kt" }
            .forEach { typesFile ->
                val packageRegex = Regex("""^package\s+([\w.]+)""")
                val enumRegex = Regex("""^\s*enum class (\w+)""")

                var currentPackage = ""
                typesFile.readLines().forEach { line ->
                    packageRegex.find(line)?.let { match ->
                        currentPackage = match.groupValues[1]
                    }
                    enumRegex.find(line)?.let { match ->
                        val enumName = match.groupValues[1]
                        // Enums in Types.kt are always under Types class
                        enumTypeLocations[enumName] = "$currentPackage.Types.$enumName"
                    }
                }
            }
    }

    private fun scanInterfaces() {
        val apiDir = File(projectRoot, "${config.apiSourceRoot}/${config.apiPackageRoot.replace('.', '/')}")
        if (!apiDir.exists()) {
            error("API directory not found: ${apiDir.absolutePath}")
        }

        apiDir.walkTopDown()
            .filter { it.isFile && it.extension == "kt" }
            .forEach { file ->
                parseInterfaceFile(file)
            }
    }

    private fun parseInterfaceFile(file: File) {
        val content = file.readText()
        val lines = content.lines()

        // Extract package
        val packageRegex = Regex("""^package\s+([\w.]+)""")
        val packageName = lines.firstNotNullOfOrNull { line ->
            packageRegex.find(line)?.groupValues?.get(1)
        } ?: return

        // Extract interfaces
        val interfaceRegex = Regex("""^interface\s+(\w+)(?:\s*:\s*([^{]+))?""")
        val propertyRegex = Regex("""^\s*(val|var)\s+(\w+):\s*([^=\n]+)(?:\s*=.*)?""")

        var currentInterface: String? = null
        val currentProperties = mutableListOf<PropertyInfo>()
        val currentParents = mutableListOf<String>()

        lines.forEach { line ->
            val trimmedLine = line.trim()

            // Interface declaration
            interfaceRegex.find(trimmedLine)?.let { match ->
                // Save previous interface if exists
                if (currentInterface != null) {
                    saveInterface(
                        currentInterface!!,
                        packageName,
                        file.absolutePath,
                        currentProperties.toList(),
                        currentParents.toList()
                    )
                    currentProperties.clear()
                    currentParents.clear()
                }

                currentInterface = match.groupValues[1]
                val parents = match.groupValues.getOrNull(2)?.trim()
                if (!parents.isNullOrBlank()) {
                    currentParents.addAll(parents.split(",").map { it.trim() })
                }
            }

            // Property declaration
            if (currentInterface != null) {
                propertyRegex.find(trimmedLine)?.let { match ->
                    val isVar = match.groupValues[1] == "var"
                    val propName = match.groupValues[2]
                    val propType = match.groupValues[3].trim()
                    val isNullable = propType.endsWith("?")

                    currentProperties.add(
                        PropertyInfo(
                            name = propName,
                            type = propType,
                            isVar = isVar,
                            isNullable = isNullable
                        )
                    )
                }
            }
        }

        // Save last interface
        if (currentInterface != null) {
            saveInterface(
                currentInterface!!,
                packageName,
                file.absolutePath,
                currentProperties.toList(),
                currentParents.toList()
            )
        }
    }

    private fun saveInterface(
        name: String,
        packageName: String,
        filePath: String,
        properties: List<PropertyInfo>,
        parents: List<String>
    ) {
        val fullName = "$packageName.$name"
        interfaceRegistry[fullName] = InterfaceInfo(
            name = name,
            packageName = packageName,
            filePath = filePath,
            properties = properties,
            parentInterfaces = parents
        )
    }

    private fun analyzeInheritance() {
        // Build parent-child relationships
        interfaceRegistry.values.forEach { interfaceInfo ->
            interfaceInfo.parentInterfaces.forEach { parentName ->
                val parentFullName = if (parentName.contains(".")) {
                    parentName
                } else {
                    "${interfaceInfo.packageName}.$parentName"
                }

                interfaceRegistry[parentFullName]?.childInterfaces?.add(interfaceInfo.fullQualifiedName)
            }
        }

        // Mark polymorphic roots
        config.polymorphicInterfaces.forEach { polyName ->
            interfaceRegistry.values.find { it.name == polyName }?.isPolymorphicRoot = true
        }

        // Resolve all properties (including inherited) for each interface
        interfaceRegistry.values.forEach { interfaceInfo ->
            interfaceInfo.allProperties = getAllProperties(interfaceInfo)
        }
    }

    private fun getAllProperties(interfaceInfo: InterfaceInfo): List<PropertyInfo> {
        // If already cached, return it
        interfaceInfo.allProperties?.let { return it }

        val allProps = mutableListOf<PropertyInfo>()
        val seenPropertyNames = mutableSetOf<String>()

        // Recursively collect properties from parent interfaces first
        interfaceInfo.parentInterfaces.forEach { parentName ->
            val parentInfo = findInterfaceByName(parentName, interfaceInfo.packageName)
            if (parentInfo != null) {
                val parentProps = getAllProperties(parentInfo)
                parentProps.forEach { prop ->
                    if (prop.name !in seenPropertyNames) {
                        allProps.add(prop)
                        seenPropertyNames.add(prop.name)
                    }
                }
            }
        }

        // Add own properties
        interfaceInfo.properties.forEach { prop ->
            if (prop.name !in seenPropertyNames) {
                allProps.add(prop)
                seenPropertyNames.add(prop.name)
            }
        }

        return allProps
    }

    private fun generateFile(interfaceInfo: InterfaceInfo): File {
        val outputDir = File(projectRoot, config.getOutputDirectory(interfaceInfo.filePath).path)
        outputDir.mkdirs()

        val outputFile = File(outputDir, "${interfaceInfo.name}Data.kt")
        val content = generateFileContent(interfaceInfo)

        outputFile.writeText(content)
        return outputFile
    }

    private fun generateFileContent(interfaceInfo: InterfaceInfo): String {
        val builder = StringBuilder()

        // Package declaration
        val outputPackage = config.getOutputPackage(interfaceInfo.packageName)
        builder.appendLine("package $outputPackage")
        builder.appendLine()

        // Imports
        val imports = generateImports(interfaceInfo)
        imports.forEach { builder.appendLine(it) }
        builder.appendLine()
        builder.appendLine()

        // Sealed interface (if polymorphic)
        if (interfaceInfo.isPolymorphicRoot) {
            builder.appendLine("@Serializable(with = ${interfaceInfo.name}Serializer::class)")
            builder.appendLine("sealed interface ${interfaceInfo.name}Seal : ${interfaceInfo.name}")
            builder.appendLine()
            builder.appendLine()
        } else if (hasPolymorphicParent(interfaceInfo)) {
            builder.appendLine("@Serializable")
            builder.appendLine("sealed interface ${interfaceInfo.name}Seal : ${interfaceInfo.name}")
            builder.appendLine()
            builder.appendLine()
        }

        // Data class
        builder.append(generateDataClass(interfaceInfo))
        builder.appendLine()

        // Polymorphic serializer (if polymorphic root)
        if (interfaceInfo.isPolymorphicRoot) {
            builder.appendLine()
            builder.append(generatePolymorphicSerializer(interfaceInfo))
        }

        return builder.toString()
    }

    private fun generateImports(interfaceInfo: InterfaceInfo): List<String> {
        val imports = mutableSetOf<String>()

        // Import the interface itself
        imports.add("import ${interfaceInfo.fullQualifiedName}")

        // Import parent interfaces
        interfaceInfo.parentInterfaces.forEach { parentName ->
            val parentInfo = findInterfaceByName(parentName, interfaceInfo.packageName)
            if (parentInfo != null) {
                imports.add("import ${parentInfo.fullQualifiedName}")
            }
        }

        // Import polymorphic root's Seal if this interface has a polymorphic ancestor
        val polymorphicRoot = findPolymorphicRootAncestor(interfaceInfo)
        if (polymorphicRoot != null) {
            val rootOutputPackage = config.getOutputPackage(polymorphicRoot.packageName)
            imports.add("import $rootOutputPackage.${polymorphicRoot.name}Seal")
        }

        // Use allProperties for complete imports
        val allProps = interfaceInfo.allProperties ?: emptyList()

        // Import all enum types used in properties
        allProps.forEach { prop ->
            extractTypeImports(prop.type).forEach { typeImport ->
                imports.add(typeImport)
            }
        }

        // Import Seal classes for polymorphic interface types used in properties
        allProps.forEach { prop ->
            config.polymorphicInterfaces.forEach { polyInterface ->
                val regex = Regex("""(?<![A-Za-z])$polyInterface(?![A-Za-z])""")
                if (regex.containsMatchIn(prop.type)) {
                    // Find the polymorphic interface and import its Seal
                    val polyInfo = interfaceRegistry.values.find { it.name == polyInterface }
                    if (polyInfo != null) {
                        val polyOutputPackage = config.getOutputPackage(polyInfo.packageName)
                        imports.add("import $polyOutputPackage.${polyInterface}Seal")
                    }
                }
            }
        }

        // Import Types if needed
        val needsTypes = allProps.any { prop ->
            prop.type.contains("Types.") || sysIdTypes.any { prop.type.contains(it) }
        }
        if (needsTypes) {
            imports.add("import com.neome.api.meta.base.Types")
        }

        // Import system ID serializers (extract ALL SysId types from each property)
        allProps.forEach { prop ->
            extractAllSystemIdFromType(prop.type).forEach { sysIdType ->
                imports.add("import ${config.serializerPackage}.${sysIdType}Ser")
            }
        }

        // Import Kotlin serialization
        imports.add("import kotlinx.serialization.Serializable")

        // Import JsonElement if any property has Object, Any, or JsonElement type
        val hasJsonElementType = allProps.any { prop ->
            val jsonElementRegex = Regex("""(?<![A-Za-z])(Object|Any|JsonElement)(?![A-Za-z])""")
            jsonElementRegex.containsMatchIn(prop.type)
        }
        if (hasJsonElementType) {
            imports.add("import kotlinx.serialization.json.JsonElement")
        }

        if (interfaceInfo.isPolymorphicRoot) {
            imports.add("import kotlinx.serialization.DeserializationStrategy")
            imports.add("import kotlinx.serialization.json.JsonContentPolymorphicSerializer")
            imports.add("import kotlinx.serialization.json.JsonElement")
            imports.add("import kotlinx.serialization.json.jsonObject")
            imports.add("import kotlinx.serialization.json.jsonPrimitive")

            // Import the discriminator enum class
            val discriminatorDto = config.discriminatorFields[interfaceInfo.name]
            if (discriminatorDto != null) {
                val enumClassName = discriminatorDto.enum
                // Find the enum location
                val enumFullName = enumTypeLocations[enumClassName]
                if (enumFullName != null) {
                    imports.add("import $enumFullName")
                }
            }

            // Import ALL subtype data classes from typeMappings config
            val subtypeMap = config.typeMappings[interfaceInfo.name]
            if (subtypeMap != null) {
                subtypeMap.keys.forEach { subtypeName ->
                    // Find the interface by name
                    val subtypeInfo = interfaceRegistry.values.find { it.name == subtypeName }
                    if (subtypeInfo != null) {
                        val subtypeOutputPackage = config.getOutputPackage(subtypeInfo.packageName)
                        imports.add("import $subtypeOutputPackage.${subtypeName}Data")
                    }
                }
            } else {
                // Fallback: Import child data classes
                interfaceInfo.childInterfaces.forEach { childFullName ->
                    interfaceRegistry[childFullName]?.let { child ->
                        val childOutputPackage = config.getOutputPackage(child.packageName)
                        imports.add("import $childOutputPackage.${child.name}Data")
                    }
                }
            }
        }

        return imports.sorted()
    }

    private fun extractTypeImports(type: String): List<String> {
        val imports = mutableListOf<String>()

        // Extract all custom types from the type string (handle generics too)
        val typePattern = Regex("""([A-Z]\w+)""")
        typePattern.findAll(type).forEach { match ->
            val typeName = match.groupValues[1]

            // Skip common Kotlin/Java types
            if (typeName in setOf(
                    "Map",
                    "List",
                    "Set",
                    "Array",
                    "String",
                    "Long",
                    "Int",
                    "Boolean",
                    "Double",
                    "Float",
                    "Types"
                )
            ) {
                return@forEach
            }

            // Check if it's an individual AnyValue class (Symbol, AnyEmailId, etc.)
            if (typeName in config.individualAnyValueClasses) {
                imports.add("import com.neome.api.meta.base.$typeName")
                return@forEach
            }

            // Find where this type is defined in the registry (interfaces)
            val typeInfo = interfaceRegistry.values.find { it.name == typeName }
            if (typeInfo != null) {
                // Import from the API package
                imports.add("import ${typeInfo.fullQualifiedName}")
                return@forEach
            }

            // Check enum types - look up in the enum location map (includes ServiceName, EnumMessageType, etc.)
            val enumFullQualifiedName = enumTypeLocations[typeName]
            if (enumFullQualifiedName != null) {
                imports.add("import $enumFullQualifiedName")
                return@forEach
            }
        }

        return imports.distinct()
    }

    private fun generateDataClass(interfaceInfo: InterfaceInfo): String {
        val builder = StringBuilder()

        // Use allProperties instead of just properties
        val allProps = interfaceInfo.allProperties ?: emptyList()

        builder.appendLine("@Serializable")

        if (allProps.isEmpty()) {
            // For empty interfaces, use object instead of data class
            builder.append("object ${interfaceInfo.name}Data")
        } else {
            builder.append("data class ${interfaceInfo.name}Data(")
            builder.appendLine()
            allProps.forEachIndexed { index, prop ->
                val modifier = if (prop.isVar) "var" else "val"
                val defaultValue = generateDefaultValue(prop, interfaceInfo)
                
                // Generate type with inline serializer annotations for generic types
                val (qualifiedType, needsPropertyAnnotation) = qualifyTypeWithInlineSerializers(prop.type)

                builder.append("    ")
                // Only add property-level annotation if type is not inside a generic
                if (needsPropertyAnnotation) {
                    val serializerAnnotation = generateSerializerAnnotation(prop.type)
                    if (serializerAnnotation.isNotEmpty()) {
                        builder.append("$serializerAnnotation ")
                    }
                }
                builder.append("override $modifier ${prop.name}: $qualifiedType")
                if (defaultValue != null) {
                    builder.append(" = $defaultValue")
                }

                if (index < allProps.size - 1) {
                    builder.appendLine(",")
                } else {
                    builder.appendLine()
                }
            }
            builder.append(")")
        }

        // Inheritance
        val inheritance = mutableListOf<String>()

        // Check if this interface or any ancestor extends a polymorphic interface
        val polymorphicRoot = findPolymorphicRootAncestor(interfaceInfo)
        
        if (polymorphicRoot != null) {
            // Add the polymorphic root's Seal class first
            inheritance.add("${polymorphicRoot.name}Seal")
            // Then add own interface
            inheritance.add(interfaceInfo.name)
        } else {
            // No polymorphic ancestor, just add own interface
            inheritance.add(interfaceInfo.name)
        }

        builder.append(" : ${inheritance.joinToString(", ")}")

        return builder.toString()
    }

    private fun generateSerializerAnnotation(type: String): String {
        val sysIdType = extractSystemIdFromType(type).firstOrNull() ?: return ""
        return "@Serializable(with = ${sysIdType}Ser::class)"
    }

    /**
     * Qualifies a type and adds inline @Serializable annotations for SysId types inside generics.
     * Returns a Pair of (qualifiedType, needsPropertyAnnotation)
     * - needsPropertyAnnotation is true if the SysId type is NOT inside a generic (direct type)
     * - needsPropertyAnnotation is false if all SysId types are inside generics (Map, Set, List, Array)
     */
    private fun qualifyTypeWithInlineSerializers(type: String): Pair<String, Boolean> {
        var result = type
        var hasDirectSysIdType = false
        
        // Check if type is a generic container
        val isGenericType = type.contains("<") && type.contains(">")
        
        if (!isGenericType) {
            // Simple type - check if it's a polymorphic interface first
            val typeWithSeal = replacePolymorphicInterfaceWithSeal(type)
            // Then qualify SysId types
            val sysIdTypes = extractSystemIdFromType(typeWithSeal)
            hasDirectSysIdType = sysIdTypes.isNotEmpty()
            return Pair(qualifySystemIdTypes(typeWithSeal), hasDirectSysIdType)
        }
        
        // For generic types, we need to add inline serializer annotations
        // Extract the generic part: Map<K, V>, Set<T>, List<T>, Array<T>
        val genericRegex = Regex("""^(\w+)<(.+)>(\?)?$""")
        val match = genericRegex.find(type.trim())
        
        if (match == null) {
            // Fallback: couldn't parse, use old behavior
            val sysIdTypes = extractSystemIdFromType(type)
            hasDirectSysIdType = sysIdTypes.isNotEmpty()
            return Pair(qualifySystemIdTypes(type), hasDirectSysIdType)
        }
        
        val containerType = match.groupValues[1] // Map, Set, List, Array
        val innerTypes = match.groupValues[2]     // K, V or T
        val nullable = match.groupValues[3]       // ? or empty
        
        // Parse inner types (handle nested generics)
        val typeParams = parseGenericTypeParams(innerTypes)
        
        // Process each type parameter
        val processedParams = typeParams.map { param ->
            processTypeParam(param.trim())
        }
        
        result = "$containerType<${processedParams.joinToString(", ")}>$nullable"
        
        // No property-level annotation needed since we added inline annotations
        return Pair(result, false)
    }
    
    /**
     * Parse generic type parameters, handling nested generics
     */
    private fun parseGenericTypeParams(innerTypes: String): List<String> {
        val params = mutableListOf<String>()
        var depth = 0
        var current = StringBuilder()
        
        for (char in innerTypes) {
            when {
                char == '<' -> {
                    depth++
                    current.append(char)
                }
                char == '>' -> {
                    depth--
                    current.append(char)
                }
                char == ',' && depth == 0 -> {
                    params.add(current.toString().trim())
                    current = StringBuilder()
                }
                else -> current.append(char)
            }
        }
        
        if (current.isNotEmpty()) {
            params.add(current.toString().trim())
        }
        
        return params
    }
    
    /**
     * Process a single type parameter, adding serializer annotation if needed
     */
    private fun processTypeParam(param: String): String {
        // Check if this param itself is a generic (nested)
        if (param.contains("<")) {
            val (qualified, _) = qualifyTypeWithInlineSerializers(param)
            return qualified
        }
        
        // First, replace polymorphic interface with Seal type
        val typeWithSeal = replacePolymorphicInterfaceWithSeal(param)
        
        // Check if this type needs a serializer
        val sysIdType = extractSystemIdFromType(typeWithSeal).firstOrNull()
        
        if (sysIdType != null) {
            // Qualify the type first
            val qualifiedType = qualifySystemIdTypes(typeWithSeal)
            // Add inline serializer annotation
            return "@Serializable(with = ${sysIdType}Ser::class) $qualifiedType"
        }
        
        // No serializer needed, just qualify
        return qualifySystemIdTypes(typeWithSeal)
    }

    /**
     * Replace polymorphic interface types with their Seal types.
     * e.g., DtoMessagePayload -> DtoMessagePayloadSeal
     */
    private fun replacePolymorphicInterfaceWithSeal(type: String): String {
        var result = type
        
        config.polymorphicInterfaces.forEach { polyInterface ->
            // Match the interface name with word boundaries, preserving nullable marker
            val regex = Regex("""(?<![A-Za-z])$polyInterface(?![A-Za-z])""")
            if (regex.containsMatchIn(result)) {
                result = regex.replace(result, "${polyInterface}Seal")
            }
        }
        
        return result
    }

    /**
     * Extract the first/longest matching SysId type from a type string.
     * Used for generating single serializer annotation.
     */
    private fun extractSystemIdFromType(type: String): List<String> {
        // Extract System ID types - use word boundary matching to avoid partial matches
        // e.g., don't match "Key" inside "LanguageKey"
        return sysIdTypes
            .filter { sysIdType ->
                val wordBoundaryRegex = Regex("""(?<![A-Za-z])$sysIdType(?![A-Za-z])""")
                wordBoundaryRegex.containsMatchIn(type)
            }
            .sortedByDescending { it.length } // Longer names first (MediaIdImage before MediaId)
            .take(1) // Only take the longest match
    }

    /**
     * Extract ALL matching SysId types from a type string.
     * Used for generating imports.
     */
    private fun extractAllSystemIdFromType(type: String): List<String> {
        val found = mutableListOf<String>()
        var remaining = type
        
        // Sort by length descending to match longer names first
        val sortedSysIdTypes = sysIdTypes.sortedByDescending { it.length }
        
        sortedSysIdTypes.forEach { sysIdType ->
            val wordBoundaryRegex = Regex("""(?<![A-Za-z])$sysIdType(?![A-Za-z])""")
            if (wordBoundaryRegex.containsMatchIn(remaining)) {
                found.add(sysIdType)
                // Remove the matched type to avoid partial re-matches
                remaining = wordBoundaryRegex.replace(remaining, "___MATCHED___")
            }
        }
        
        return found
    }

    private fun qualifySystemIdTypes(type: String): String {
        var result = type

        // Individual AnyValue classes are imported directly, not from Types
        // They should NOT be qualified with Types.
        val individualClasses = config.individualAnyValueClasses

        // Nucleus AnyValue classes need full qualification with package
        val nucleusClasses = nucleusAnyValueClassesSet

        // Sort by length descending to replace longer names first (MediaIdImage before MediaId)
        sysIdTypes.sortedByDescending { it.length }.forEach { sysIdType ->
            // Skip individual AnyValue classes - they don't need Types. prefix
            if (sysIdType in individualClasses) {
                return@forEach
            }

            // Use word boundary matching to avoid partial replacements
            // e.g., don't replace "Key" inside "LanguageKey"
            val wordBoundaryRegex = Regex("""(?<![A-Za-z.])$sysIdType(?![A-Za-z])""")

            // Nucleus AnyValue classes need full package qualification
            if (sysIdType in nucleusClasses) {
                if (wordBoundaryRegex.containsMatchIn(result) && !result.contains("com.neome.api.nucleus.base.Types.$sysIdType")) {
                    result = wordBoundaryRegex.replace(result, "com.neome.api.nucleus.base.Types.$sysIdType")
                }
                return@forEach
            }

            // Only replace if not already qualified with Types.
            if (wordBoundaryRegex.containsMatchIn(result) && !result.contains("Types.$sysIdType")) {
                result = wordBoundaryRegex.replace(result, "Types.$sysIdType")
            }
        }

        return result
    }

    private fun generateDefaultValue(prop: PropertyInfo, interfaceInfo: InterfaceInfo): String? {
        // Nullable types default to null
        if (prop.isNullable) {
            return "null"
        }

        // Enum discriminator for polymorphic types
        if (prop.name == "messageType" && prop.type.contains("EnumMessageType")) {
            val discriminatorValue = findDiscriminatorValue(interfaceInfo)
            if (discriminatorValue != null) {
                return "EnumMessageType.$discriminatorValue"
            }
        }

        // No default for required properties
        return null
    }

    private fun findDiscriminatorValue(interfaceInfo: InterfaceInfo): String? {
        config.typeMappings.forEach { (rootName, subtypeMap) ->
            subtypeMap.forEach { (subtypeName, value) ->
                if (interfaceInfo.name == subtypeName) {
                    return value
                }
            }
        }
        return null
    }

    private fun generatePolymorphicSerializer(interfaceInfo: InterfaceInfo): String {
        val builder = StringBuilder()
        val discriminatorDto = config.discriminatorFields[interfaceInfo.name]
        val discriminatorField = discriminatorDto?.property ?: "type"
        val enumClassName = discriminatorDto?.enum ?: "String"

        builder.appendLine("object ${interfaceInfo.name}Serializer : JsonContentPolymorphicSerializer<${interfaceInfo.name}Seal>(")
        builder.appendLine("    ${interfaceInfo.name}Seal::class")
        builder.appendLine(") {")
        builder.appendLine("    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<${interfaceInfo.name}Seal> {")
        builder.appendLine("        val $discriminatorField = element.jsonObject[\"$discriminatorField\"]?.jsonPrimitive?.content")
        builder.appendLine("        return when ($discriminatorField) {")

        // Get type mappings for this interface
        val subtypeMap = config.typeMappings[interfaceInfo.name] ?: emptyMap()
        
        // Get all enum values for this discriminator
        val enumValues = getEnumValues(enumClassName, interfaceInfo.packageName)
        
        // Generate when cases for all enum values
        enumValues.forEach { enumValue ->
            // Find if this enum value has a mapped subtype
            val subtypeName = subtypeMap.entries.find { it.value == enumValue }?.key
            
            if (subtypeName != null) {
                // Has a mapped data class
                builder.appendLine("            $enumClassName.$enumValue.value -> ${subtypeName}Data.serializer()")
            } else {
                // No mapping, use Seal serializer
                builder.appendLine("            $enumClassName.$enumValue.value -> ${interfaceInfo.name}Seal.serializer()")
            }
        }

        builder.appendLine("            else -> ${interfaceInfo.name}Seal.serializer()")
        builder.appendLine("        }")
        builder.appendLine("    }")
        builder.appendLine("}")

        return builder.toString()
    }

    /**
     * Extract all enum values from an enum class.
     */
    private fun getEnumValues(enumClassName: String, currentPackage: String): List<String> {
        // Find the enum in Types.kt files
        val enumValues = mutableListOf<String>()
        
        // Search in meta/base/Types.kt
        val metaTypesFile = File(projectRoot, "${config.apiSourceRoot}/${config.metaTypesFilePath.replace('.', '/')}.kt")
        if (metaTypesFile.exists()) {
            enumValues.addAll(extractEnumValuesFromFile(metaTypesFile, enumClassName))
        }
        
        // Search in nucleus/base/Types.kt
        val nucleusTypesFile = File(projectRoot, "${config.apiSourceRoot}/${config.nucleusTypesFilePath.replace('.', '/')}.kt")
        if (nucleusTypesFile.exists()) {
            enumValues.addAll(extractEnumValuesFromFile(nucleusTypesFile, enumClassName))
        }
        
        // Search in home/base/Types.kt (for EnumMessageType)
        val homeTypesFile = File(projectRoot, "${config.apiSourceRoot}/com/neome/api/home/base/Types.kt")
        if (homeTypesFile.exists()) {
            enumValues.addAll(extractEnumValuesFromFile(homeTypesFile, enumClassName))
        }
        
        // Search in form/base/Types.kt (for EnumDefnCompType)
        val formTypesFile = File(projectRoot, "${config.apiSourceRoot}/com/neome/api/form/base/Types.kt")
        if (formTypesFile.exists()) {
            enumValues.addAll(extractEnumValuesFromFile(formTypesFile, enumClassName))
        }
        
        return enumValues
    }

    /**
     * Extract enum values from a specific file.
     */
    private fun extractEnumValuesFromFile(file: File, enumClassName: String): List<String> {
        val enumValues = mutableListOf<String>()
        val lines = file.readLines()
        
        var inTargetEnum = false
        val enumStartRegex = Regex("""^\s*enum class $enumClassName\b""")
        val enumValueRegex = Regex("""^\s*(\w+)\s*\(""")
        
        for (line in lines) {
            if (enumStartRegex.containsMatchIn(line)) {
                inTargetEnum = true
                continue
            }
            
            if (inTargetEnum) {
                // Check for end of enum (next class/enum/interface or closing brace at start)
                if (line.trim().startsWith("enum class ") || 
                    line.trim().startsWith("class ") || 
                    line.trim().startsWith("interface ") ||
                    line.trim().startsWith("object ") ||
                    (line.trim() == "}" && !line.contains("("))) {
                    break
                }
                
                // Extract enum value
                enumValueRegex.find(line)?.let { match ->
                    enumValues.add(match.groupValues[1])
                }
            }
        }
        
        return enumValues
    }

    /**
     * Check if this interface or any ancestor has a polymorphic root as an ancestor.
     */
    private fun hasPolymorphicParent(interfaceInfo: InterfaceInfo): Boolean {
        return findPolymorphicRootAncestor(interfaceInfo) != null
    }

    /**
     * Recursively find the polymorphic root ancestor of an interface.
     * Returns the polymorphic root interface, or null if none found.
     */
    private fun findPolymorphicRootAncestor(interfaceInfo: InterfaceInfo, visited: MutableSet<String> = mutableSetOf()): InterfaceInfo? {
        // Prevent infinite recursion
        if (interfaceInfo.fullQualifiedName in visited) return null
        visited.add(interfaceInfo.fullQualifiedName)
        
        // Check direct parents
        for (parentName in interfaceInfo.parentInterfaces) {
            val parentInfo = findInterfaceByName(parentName, interfaceInfo.packageName)
            if (parentInfo != null) {
                // If parent is polymorphic root, return it
                if (parentInfo.isPolymorphicRoot) {
                    return parentInfo
                }
                // Otherwise, check parent's ancestors recursively
                val ancestorRoot = findPolymorphicRootAncestor(parentInfo, visited)
                if (ancestorRoot != null) {
                    return ancestorRoot
                }
            }
        }
        
        return null
    }

    private fun findInterfaceByName(name: String, currentPackage: String): InterfaceInfo? {
        // Try with full qualified name
        interfaceRegistry[name]?.let { return it }

        // Try with current package
        interfaceRegistry["$currentPackage.$name"]?.let { return it }

        // Try with simple name search
        return interfaceRegistry.values.find { it.name == name }
    }
}
