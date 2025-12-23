// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.dto.DefnForm
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.nucleus.base.sig.Sig

open class SigSysDefnFormMapGet : Sig()
{
  lateinit var sysDefnFormMap: Map<MetaIdForm, DefnForm>
}