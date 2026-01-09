package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.entDrawer.sig.SigEntAvatarUser
import com.neome.api.ent.entMain.sig.SigEntInvitationList
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigEntInvitationListData(
    override val entList: Array<SigEntAvatarUser>? = null
) : SigEntInvitationList
