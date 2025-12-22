// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.nucleus.base.sig.Sig

class SigSysDefnFormMapGet : Sig() {
    val sysDefnFormMap: Record<MetaIdForm, DefnForm>
}
