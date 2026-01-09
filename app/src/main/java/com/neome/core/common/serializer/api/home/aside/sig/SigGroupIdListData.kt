package com.neome.core.common.serializer.api.home.aside.sig

import com.neome.api.home.aside.sig.SigGroupIdList
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.GroupIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigGroupIdListData(
    override val groupIdList: Array<@Serializable(with = GroupIdSer::class) Types.GroupId>
) : SigGroupIdList
