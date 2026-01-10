package com.neome.core.common.serializer.api.ent.entAside.msg

import com.neome.api.ent.entAside.msg.MsgButtonFieldReportDataGet
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgButtonFieldReportDataGetData(
    @Serializable(with = MetaIdFieldSer::class) override val buttonFieldId: Types.MetaIdField,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    override val formValue: FormValueRawData,
    @Serializable(with = MetaIdCompositeSer::class) override val fromCompositeId: Types.MetaIdComposite? = null,
    @Serializable(with = RowIdSer::class) override val fromGridRowId: Types.RowId? = null
) : MsgButtonFieldReportDataGet
