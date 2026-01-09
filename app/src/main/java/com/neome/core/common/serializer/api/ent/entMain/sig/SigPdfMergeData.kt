package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.entMain.sig.SigPdfMerge
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.MediaIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigPdfMergeData(
    override val fileExt: EnumDefnDocFileExt,
    override val fileLength: Long? = null,
    override val fileName: String,
    @Serializable(with = MediaIdSer::class) override val mediaId: Types.MediaId
) : SigPdfMerge
