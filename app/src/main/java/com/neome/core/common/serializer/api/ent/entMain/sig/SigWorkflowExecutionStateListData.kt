package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoWorkflowExecutionStateInfo
import com.neome.api.ent.entMain.sig.SigWorkflowExecutionStateList
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.ent.base.dto.DtoWorkflowExecutionStateInfoData
import kotlinx.serialization.Serializable


@Serializable
data class SigWorkflowExecutionStateListData(
    override val list: List<DtoWorkflowExecutionStateInfoData>
) : SigWorkflowExecutionStateList
