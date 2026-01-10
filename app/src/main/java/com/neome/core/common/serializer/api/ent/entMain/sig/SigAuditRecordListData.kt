package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoAuditRecord
import com.neome.api.ent.entMain.sig.SigAuditRecordList
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.ent.base.dto.DtoAuditRecordData
import kotlinx.serialization.Serializable


@Serializable
data class SigAuditRecordListData(
    override val auditRecordList: List<DtoAuditRecordData>? = null
) : SigAuditRecordList
