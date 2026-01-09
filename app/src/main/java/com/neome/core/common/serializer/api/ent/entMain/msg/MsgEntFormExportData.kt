package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgEntFormExport
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumFormExportType
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgEntFormExportData(
    @Serializable(with = MetaIdLayoutFormSer::class) override val contentLayoutId: Types.MetaIdLayoutForm,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    override val exportType: EnumFormExportType,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    override val formValueRaw: FormValueRaw,
    override val height: Long? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val templateLayoutId: Types.MetaIdLayoutForm? = null,
    override val width: Long? = null
) : MsgEntFormExport
