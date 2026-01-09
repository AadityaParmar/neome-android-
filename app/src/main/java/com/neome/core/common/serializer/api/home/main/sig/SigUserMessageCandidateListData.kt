package com.neome.core.common.serializer.api.home.main.sig

import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.home.main.sig.SigUserMessageCandidateList
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.AnyPrefixKeySer
import kotlinx.serialization.Serializable


@Serializable
data class SigUserMessageCandidateListData(
    override val candidateMap: Map<@Serializable(with = AnyPrefixKeySer::class) com.neome.api.nucleus.base.Types.AnyPrefixKey, Array<SigUserAvatar>>
) : SigUserMessageCandidateList
