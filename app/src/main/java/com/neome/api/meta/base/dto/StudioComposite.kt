// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioComp
import com.neome.api.meta.base.dto.StudioFieldMap
import com.neome.api.meta.base.dto.StudioMapOfActionPermission

interface StudioComposite : StudioComp
{
  val actionPermissionMap: StudioMapOfActionPermission?
  val fieldMap: StudioFieldMap
}