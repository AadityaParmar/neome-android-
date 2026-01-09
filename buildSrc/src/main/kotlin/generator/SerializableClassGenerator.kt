package generator

import java.io.File

/**
 * Configuration for the Serializable Data Class Generator
 */
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
    ),

    // Interfaces to skip during generation
    val skipInterfaces: Set<String> = setOf(
        "IRpcCall",
        "IRpcCallFactory",
        "ISigAcceptor",
        "ISigPushAcceptor",
        "IWsocCall",
        "IWsocCallFactory"
    )
) {
    fun getOutputPackage(apiPackagePath: String): String {
        val relativePath = apiPackagePath.removePrefix("$apiPackageRoot.")
        return "$outputPackageRoot.$relativePath"
    }

    fun getOutputDirectory(apiFilePath: String): File {
        // Convert to File and get absolute path
        val apiFile = File(apiFilePath)
        val apiPackagePath = apiPackageRoot.replace('.', '/')

        // Find the position where the API package starts
        val absolutePath = apiFile.absolutePath.replace("\\", "/")
        val apiPackageIndex = absolutePath.indexOf("/$apiPackagePath/")

        if (apiPackageIndex == -1) {
            error("Could not find API package path in: $absolutePath")
        }

        // Get the relative path after the API package root
        val relativePath = absolutePath.substring(apiPackageIndex + "/$apiPackagePath/".length)
        val relativeDir = File(relativePath).parent ?: ""

        // Build output directory path
        val outputPackagePath = outputPackageRoot.replace('.', '/')
        return File("$outputSourceRoot/$outputPackagePath/$relativeDir")
    }
}

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
    private val config: GeneratorConfig,
    private val projectRoot: File
) {
    private val interfaceRegistry = mutableMapOf<String, InterfaceInfo>()
    private val sysIdTypes = mutableSetOf<String>()
    private val enumTypeLocations = mutableMapOf<String, String>() // EnumName -> Package

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
        val typesFile = File(projectRoot, "${config.apiSourceRoot}/${config.typesFilePath.replace('.', '/')}.kt")
        if (!typesFile.exists()) {
            println("Warning: Types.kt not found at ${typesFile.absolutePath}")
            return
        }

        println("Parsing ${typesFile.absolutePath}...")

        // Extract all SysId class names (matching bash script logic exactly)
        // Step 1: grep "^  open class.*:"
        // Step 2: grep -E "(SysId|ArtifactId|ChatId|ContactId|InboxId|MediaId|MetaId|MetaIdComp|MetaIdComposite|MetaIdPipelineParam)"
        // Step 3: extract class name
        val sysIdClassNames = mutableListOf<String>()
        val openClassRegex = Regex("""^  open class (\w+) :""")
        val sysIdPatternRegex = Regex("""(SysId|ArtifactId|ChatId|ContactId|InboxId|MediaId|MetaId|MetaIdComp|MetaIdComposite|MetaIdPipelineParam)""")

        typesFile.readLines().forEach { line ->
            // First check: line starts with "  open class" and contains ":"
            if (openClassRegex.containsMatchIn(line)) {
                // Second check: line contains one of the patterns (anywhere in the line)
                if (sysIdPatternRegex.containsMatchIn(line)) {
                    // Extract the class name
                    openClassRegex.find(line)?.let { match ->
                        val className = match.groupValues[1]
                        sysIdClassNames.add(className)
                        sysIdTypes.add(className) // Add to sysIdTypes (without Ser suffix)
                    }
                }
            }
        }

        sysIdClassNames.sort()
        println("Found ${sysIdClassNames.size} SysId classes")

        // AnyValue classes (from bash script)
        val anyValueClasses = listOf(
            "AnyEmailId", "AnyKey", "AnyName", "AnyOtpValue", "AnyPrefixKey",
            "AnyTime", "AppVersion", "ColumnPath", "CurrencyKey", "GeoPoint",
            "HandleKey", "Key", "LanguageKey", "NanoId", "SearchPath",
            "Symbol", "SymbolColumn", "SymbolGrid", "TimeZoneKey"
        )

        // Add AnyValue classes to sysIdTypes as well
        sysIdTypes.addAll(anyValueClasses)

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
            appendLine("// AnyValue class imports (individual files)")
            appendLine("import com.neome.api.meta.base.AnyEmailId")
            appendLine("import com.neome.api.meta.base.AnyKey")
            appendLine("import com.neome.api.meta.base.AnyName")
            appendLine("import com.neome.api.meta.base.NanoId")
            appendLine("import com.neome.api.meta.base.Symbol")
            appendLine()
            appendLine("// AnyValue class imports (from Types.kt classes)")
            appendLine("import com.neome.api.meta.base.Types.AnyTime")
            appendLine("import com.neome.api.meta.base.Types.ColumnPath")
            appendLine("import com.neome.api.meta.base.Types.CurrencyKey")
            appendLine("import com.neome.api.meta.base.Types.GeoPoint")
            appendLine("import com.neome.api.meta.base.Types.HandleKey")
            appendLine("import com.neome.api.meta.base.Types.Key")
            appendLine("import com.neome.api.meta.base.Types.LanguageKey")
            appendLine("import com.neome.api.meta.base.Types.SearchPath")
            appendLine("import com.neome.api.meta.base.Types.SymbolColumn")
            appendLine("import com.neome.api.meta.base.Types.SymbolGrid")
            appendLine("import com.neome.api.meta.base.Types.TimeZoneKey")
            appendLine()
            appendLine("// AnyValue class imports (from nucleus/base/Types.kt)")
            appendLine("import com.neome.api.nucleus.base.Types.AnyOtpValue")
            appendLine("import com.neome.api.nucleus.base.Types.AnyPrefixKey")
            appendLine("import com.neome.api.nucleus.base.Types.AppVersion")
            appendLine()

            // Generate SysId serializer objects
            sysIdClassNames.forEach { className ->
                appendLine("object ${className}Ser : SysIdSerializer<Types.${className}>(\"${className}\")")
            }

            appendLine()

            // Generate AnyValue serializer objects
            anyValueClasses.forEach { className ->
                appendLine("object ${className}Ser : AnyValueSerializer<${className}>(\"${className}\", ${className}::class.java)")
            }
        }

        outputFile.writeText(content)
        println("Generated ${outputFile.relativeTo(projectRoot)}")
        println("SysId serializers: ${sysIdClassNames.size}")
        println("AnyValue serializers: ${anyValueClasses.size}")
        println("Total serializers: ${sysIdClassNames.size + anyValueClasses.size}")
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
                    saveInterface(currentInterface!!, packageName, file.absolutePath, currentProperties.toList(), currentParents.toList())
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
            saveInterface(currentInterface!!, packageName, file.absolutePath, currentProperties.toList(), currentParents.toList())
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

                // Import parent's Seal if polymorphic
                if (parentInfo.isPolymorphicRoot || hasPolymorphicParent(parentInfo)) {
                    val parentOutputPackage = config.getOutputPackage(parentInfo.packageName)
                    imports.add("import $parentOutputPackage.${parentInfo.name}Seal")
                }
            }
        }

        // Use allProperties for complete imports
        val allProps = interfaceInfo.allProperties ?: emptyList()

        // Import all enum types used in properties
        allProps.forEach { prop ->
            extractTypeImports(prop.type).forEach { typeImport ->
                imports.add(typeImport)
            }
        }

        // Import Types if needed
        val needsTypes = allProps.any { prop ->
            prop.type.contains("Types.") || sysIdTypes.any { prop.type.contains(it) }
        }
        if (needsTypes) {
            imports.add("import com.neome.api.meta.base.Types")
        }

        // Import system ID serializers
        allProps.forEach { prop ->
            extractSystemIdFromType(prop.type).forEach { sysIdType ->
                imports.add("import ${config.serializerPackage}.${sysIdType}Ser")
            }
        }

        // Import Kotlin serialization
        imports.add("import kotlinx.serialization.Serializable")

        if (interfaceInfo.isPolymorphicRoot) {
            imports.add("import kotlinx.serialization.DeserializationStrategy")
            imports.add("import kotlinx.serialization.json.JsonContentPolymorphicSerializer")
            imports.add("import kotlinx.serialization.json.JsonElement")
            imports.add("import kotlinx.serialization.json.jsonObject")
            imports.add("import kotlinx.serialization.json.jsonPrimitive")

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
            if (typeName in setOf("Map", "List", "Set", "Array", "String", "Long", "Int", "Boolean", "Double", "Float", "Types")) {
                return@forEach
            }

            // Find where this type is defined in the registry
            val typeInfo = interfaceRegistry.values.find { it.name == typeName }
            if (typeInfo != null) {
                // Import from the API package
                imports.add("import ${typeInfo.fullQualifiedName}")
            } else if (typeName.startsWith("Enum")) {
                // Enum types - look up in the enum location map
                val fullQualifiedName = enumTypeLocations[typeName]
                if (fullQualifiedName != null) {
                    imports.add("import $fullQualifiedName")
                }
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
                val serializerAnnotation = generateSerializerAnnotation(prop.type)
                val modifier = if (prop.isVar) "var" else "val"
                val defaultValue = generateDefaultValue(prop, interfaceInfo)
                val qualifiedType = qualifySystemIdTypes(prop.type)

                builder.append("    ")
                if (serializerAnnotation.isNotEmpty()) {
                    builder.append("$serializerAnnotation ")
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

        // Add parent seals if polymorphic
        interfaceInfo.parentInterfaces.forEach { parentName ->
            val parentInfo = findInterfaceByName(parentName, interfaceInfo.packageName)
            if (parentInfo?.isPolymorphicRoot == true) {
                inheritance.add("${parentInfo.name}Seal")
            }
        }

        // Add own seal if has polymorphic parent
        if (hasPolymorphicParent(interfaceInfo)) {
            inheritance.add("${interfaceInfo.name}Seal")
        }

        // Add interface itself if no seal
        if (inheritance.isEmpty()) {
            inheritance.add(interfaceInfo.name)
        }

        builder.append(" : ${inheritance.joinToString(", ")}")

        return builder.toString()
    }

    private fun generateSerializerAnnotation(type: String): String {
        val sysIdType = extractSystemIdFromType(type).firstOrNull() ?: return ""
        return "@Serializable(with = ${sysIdType}Ser::class)"
    }

    private fun extractSystemIdFromType(type: String): List<String> {
        // Extract System ID types - need to match full type names to avoid partial matches
        // e.g., MediaIdImage should match before MediaId
        return sysIdTypes
            .filter { type.contains(it) }
            .sortedByDescending { it.length } // Longer names first (MediaIdImage before MediaId)
            .take(1) // Only take the longest match
    }

    private fun qualifySystemIdTypes(type: String): String {
        var result = type

        // Sort by length descending to replace longer names first (MediaIdImage before MediaId)
        sysIdTypes.sortedByDescending { it.length }.forEach { sysIdType ->
            // Only replace if not already qualified with Types.
            if (result.contains(sysIdType) && !result.contains("Types.$sysIdType")) {
                result = result.replace(sysIdType, "Types.$sysIdType")
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
        val discriminatorField = config.discriminatorFields[interfaceInfo.name] ?: "type"

        builder.appendLine("object ${interfaceInfo.name}Serializer : JsonContentPolymorphicSerializer<${interfaceInfo.name}Seal>(")
        builder.appendLine("    ${interfaceInfo.name}Seal::class")
        builder.appendLine(") {")
        builder.appendLine("    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<${interfaceInfo.name}Seal> {")
        builder.appendLine("        val $discriminatorField = element.jsonObject[\"$discriminatorField\"]?.jsonPrimitive?.content")
        builder.appendLine("        return when ($discriminatorField) {")

        // Generate when cases
        val subtypeMap = config.typeMappings[interfaceInfo.name] ?: emptyMap()
        subtypeMap.forEach { (subtypeName, value) ->
            builder.appendLine("            \"$value\", EnumMessageType.$value.value -> ${subtypeName}Data.serializer()")
        }

        builder.appendLine("            else -> ${interfaceInfo.name}Seal.serializer()")
        builder.appendLine("        }")
        builder.appendLine("    }")
        builder.appendLine("}")

        return builder.toString()
    }

    private fun hasPolymorphicParent(interfaceInfo: InterfaceInfo): Boolean {
        return interfaceInfo.parentInterfaces.any { parentName ->
            val parentInfo = findInterfaceByName(parentName, interfaceInfo.packageName)
            parentInfo?.isPolymorphicRoot == true
        }
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
