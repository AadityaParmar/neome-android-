package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEnt
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntHeader
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntReportShare
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnRenderingKind
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValue
import com.neome.core.common.serializer.api.ent.base.dto.DeeplinkDataPayloadEntHeaderData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import kotlinx.serialization.Serializable


@Serializable
data class DeeplinkDataPayloadEntReportShareData(
    override val deeplinkActionType: EnumDeeplinkActionType,
    override val header: DeeplinkDataPayloadEntHeaderData? = null,
    override val defnForm: DefnFormData,
    override val formValue: FormValueData,
    @Serializable(with = MetaIdLayoutFormSer::class) override val outputFormContentLayoutId: Types.MetaIdLayoutForm? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val outputFormTemplateLayoutId: Types.MetaIdLayoutForm? = null,
    override val paperHeight: Long? = null,
    override val paperSize: EnumDefnRenderingKind? = null,
    override val paperWidth: Long? = null,
    override val reportLabel: String? = null,
    override val reportName: String
) : DeeplinkDataPayloadEntReportShare
