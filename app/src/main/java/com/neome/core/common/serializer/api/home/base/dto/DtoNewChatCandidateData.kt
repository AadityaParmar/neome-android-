package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoNewChatCandidate
import com.neome.api.home.drawer.sig.SigGroupAvatar
import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.core.common.serializer.api.home.drawer.sig.SigGroupAvatarData
import com.neome.core.common.serializer.api.home.drawer.sig.SigUserAvatarData
import kotlinx.serialization.Serializable


@Serializable
data class DtoNewChatCandidateData(
    override val groupAvatar: SigGroupAvatarData? = null,
    override val userAvatar: SigUserAvatarData? = null
) : DtoNewChatCandidate
