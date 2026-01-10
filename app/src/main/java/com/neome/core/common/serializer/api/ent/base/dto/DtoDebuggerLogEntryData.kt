package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumLogType
import com.neome.api.ent.base.dto.DtoDebuggerLogEntry
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DtoLogTree
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.dto.EnvError
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.DtoLogTreeData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.api.nucleus.base.dto.EnvErrorData
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class DtoDebuggerLogEntryData(
    override val caller: String? = null,
    override val dateTime: String? = null,
    override val envError: EnvErrorData? = null,
    override val inputForm: DefnFormData? = null,
    override val inputFormLogTree: DtoLogTreeData? = null,
    override val inputFormValue: FormValueRawData? = null,
    override val logType: EnumLogType? = null,
    override val name: String? = null,
    override val outputForm: DefnFormData? = null,
    override val outputFormLogTree: DtoLogTreeData? = null,
    override val outputFormValue: FormValueRawData? = null,
    override val summary: JsonElement? = null
) : DtoDebuggerLogEntry
