// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.sig

import com.neome.api.ent.base.dto.DtoAgentEntUser
import com.neome.api.meta.base.Types.EntUserId
import java.util.Map
import com.neome.api.nucleus.base.sig.SigVersion

open class SigAgentEntUserList : SigVersion()
{
  lateinit var entUserMap: Map<EntUserId, DtoAgentEntUser>
}