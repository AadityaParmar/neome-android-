// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.studio.base.dto.DtoEntUser
import com.neome.api.nucleus.base.sig.Sig

open class SigEntUser : Sig()
{
  lateinit var user: DtoEntUser
}