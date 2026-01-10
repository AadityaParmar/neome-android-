package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoDebuggerLogEntry
import com.neome.api.ent.entMain.sig.SigDebuggerLogsGet
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.ent.base.dto.DtoDebuggerLogEntryData
import kotlinx.serialization.Serializable


@Serializable
data class SigDebuggerLogsGetData(
    override val logList: List<DtoDebuggerLogEntryData>? = null
) : SigDebuggerLogsGet
