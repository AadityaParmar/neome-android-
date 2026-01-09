package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoNewChatCandidate
import com.neome.api.home.drawer.sig.SigGroupAvatar
import com.neome.api.home.drawer.sig.SigUserAvatar
import kotlinx.serialization.Serializable


@Serializable
data class DtoNewChatCandidateData(
    override val groupAvatar: SigGroupAvatar? = null,
    override val userAvatar: SigUserAvatar? = null
) : DtoNewChatCandidate
