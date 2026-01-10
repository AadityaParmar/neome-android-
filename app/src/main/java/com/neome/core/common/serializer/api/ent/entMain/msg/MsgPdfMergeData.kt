package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgPdfMerge
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MediaIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgPdfMergeData(
    override val fileName: String? = null,
    override val pdfMediaIdSet: List<@Serializable(with = MediaIdSer::class) Types.MediaId>
) : MsgPdfMerge
