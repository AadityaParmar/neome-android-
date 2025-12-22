// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer.sig

import com.neome.api.ent.base.dto.DtoEntGroupFreezeSettingMap
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.sig.Sig

class SigEntFreezeGroupListGet : Sig() {
    val entMap: Record<EntId, DtoEntGroupFreezeSettingMap>
}
