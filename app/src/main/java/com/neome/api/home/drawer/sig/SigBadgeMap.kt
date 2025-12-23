// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoChatBadgeMap
import com.neome.api.meta.base.Types.EntId
import java.util.Map
import com.neome.api.nucleus.base.sig.SigVersion

open class SigBadgeMap : SigVersion()
{
  lateinit var entChatBadgeMap: Map<EntId, DtoChatBadgeMap>
}