package generator

import java.io.File

data class DiscriminatorFieldDto(val property: String, val enum: String)

/**
 * Configuration for the Serializable Data Class Generator
 */
data class SerializableClassGeneratorConfig(
    // Source configuration
    val apiPackageRoot: String = "com.neome.api",
    val apiSourceRoot: String = "app/src/main/java",

    // Types.kt file paths for extracting SysId and AnyValue classes
    val metaTypesFilePath: String = "com.neome.api.meta.base.Types",
    val nucleusTypesFilePath: String = "com.neome.api.nucleus.base.Types",

    // Output configuration - generates to com.neome.core.common.serializer.api
    val outputPackageRoot: String = "com.neome.core.common.serializer.api",
    val outputSourceRoot: String = "app/src/main/java",

    // Serializer configuration
    val serializerPackage: String = "com.neome.core.common.serializer.sysId",

    // Individual SysId and AnyValue class files in meta.base (not in Types.kt)
    val individualAnyValueClasses: Set<String> = setOf(
        "SysId", "AnyEmailId", "AnyKey", "AnyName", "NanoId", "Symbol"
    ),

    // AnyValue classes from nucleus/base/Types.kt - need full qualification
    val nucleusAnyValueClassesConfig: Set<String> = setOf(
        "AnyOtpValue", "AnyPrefixKey", "AppVersion"
    ),

    // Polymorphic type configuration
    val polymorphicInterfaces: Set<String> = setOf("DtoMessagePayload", "DefnComp"),

    // Discriminator field mapping: Interface -> Field name
    val discriminatorFields: Map<String, DiscriminatorFieldDto> = mapOf(
        "DtoMessagePayload" to DiscriminatorFieldDto("messageType", "EnumMessageType"),
        "DefnComp" to DiscriminatorFieldDto("Type", "EnumStudioCompType")
    ),

    // Type mapping: Interface -> Subtype -> Discriminator value
    val typeMappings: Map<String, Map<String, String>> = mapOf(
        "DtoMessagePayload" to mapOf(
            "DtoMessagePayloadText" to "text",
            "DtoMessagePayloadImage" to "image",
            "DtoMessagePayloadAudio" to "audio"
        ),
        "DefnComp" to mapOf(
            "DefnFieldText" to "text",
            "DefnFieldNumber" to "number",
            "DefnFieldSwitch" to "bool"
        )
    ),

    // Interfaces to skip during generation
    val skipInterfaces: Set<String> = setOf(
        "IRpcCall",
        "IRpcCallFactory",
        "ISigAcceptor",
        "ISigPushAcceptor",
        "IWsocCall",
        "IWsocCallFactory",
        "EnvSignal"
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
