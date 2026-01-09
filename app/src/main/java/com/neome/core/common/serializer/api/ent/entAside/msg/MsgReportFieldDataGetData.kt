package com.neome.core.common.serializer.api.ent.entAside.msg

import com.neome.api.ent.entAside.msg.MsgReportFieldDataGet
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgReportFieldDataGetData(
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    @Serializable(with = MetaIdCompositeSer::class) override val inputFormCompositeId: Types.MetaIdComposite? = null,
    @Serializable(with = RowIdSer::class) override val inputFormGridRowId: Types.RowId? = null,
    override val inputFormValue: FormValueRaw,
    @Serializable(with = MetaIdFieldSer::class) override val reportFieldId: Types.MetaIdField
) : MsgReportFieldDataGet
