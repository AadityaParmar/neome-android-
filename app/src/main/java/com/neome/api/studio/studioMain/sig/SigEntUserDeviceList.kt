// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.core.base.dto.DtoDevice
import com.neome.api.nucleus.base.sig.Sig

open class SigEntUserDeviceList : Sig()
{
  lateinit var deviceList: Array<DtoDevice>
}