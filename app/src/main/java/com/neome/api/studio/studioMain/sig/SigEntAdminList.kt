// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.studio.base.dto.DtoEntAdmin
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.meta.base.dto.StudioModuleMap

open class SigEntAdminList : SigVersion()
{
  lateinit var entAdminList: Array<DtoEntAdmin>
  var moduleMap: StudioModuleMap? = null
}