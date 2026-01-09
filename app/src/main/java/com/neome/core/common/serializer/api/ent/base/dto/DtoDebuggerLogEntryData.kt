package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumLogType
import com.neome.api.ent.base.dto.DtoDebuggerLogEntry
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DtoLogTree
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.dto.EnvError
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class DtoDebuggerLogEntryData(
    override val caller: String? = null,
    override val dateTime: String? = null,
    override val envError: EnvError? = null,
    override val inputForm: DefnForm? = null,
    override val inputFormLogTree: DtoLogTree? = null,
    override val inputFormValue: FormValueRaw? = null,
    override val logType: EnumLogType? = null,
    override val name: String? = null,
    override val outputForm: DefnForm? = null,
    override val outputFormLogTree: DtoLogTree? = null,
    override val outputFormValue: FormValueRaw? = null,
    override val summary: JsonElement? = null
) : DtoDebuggerLogEntry
