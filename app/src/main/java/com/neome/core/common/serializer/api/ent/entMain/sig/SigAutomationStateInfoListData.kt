package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoAutomationStateInfo
import com.neome.api.ent.entMain.sig.SigAutomationStateInfoList
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.ent.base.dto.DtoAutomationStateInfoData
import kotlinx.serialization.Serializable


@Serializable
data class SigAutomationStateInfoListData(
    override val automationStateInfoList: List<DtoAutomationStateInfoData>
) : SigAutomationStateInfoList
