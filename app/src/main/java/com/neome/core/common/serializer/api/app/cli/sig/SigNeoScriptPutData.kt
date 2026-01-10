package com.neome.core.common.serializer.api.app.cli.sig

import com.neome.api.app.cli.sig.SigNeoScriptPut
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DtoLogItemList
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.meta.base.dto.DtoLogItemListData
import com.neome.core.common.serializer.sysId.ArtifactIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigNeoScriptPutData(
    override val appendItemList: DtoLogItemListData? = null,
    override val cliCodeId: String? = null,
    override val lastArtifactName: String? = null,
    @Serializable(with = ArtifactIdSer::class) override val lastDeployUnitId: Types.ArtifactId? = null
) : SigNeoScriptPut
