// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.dto.EntVdRect
import com.neome.api.meta.base.Types.EnumDefnKindNoteStatus
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdVdNote
import com.neome.api.meta.base.Types.MetaIdVdRegion

interface EntVdNote : EntVdRect
{
  val adminId: AdminId?
  val metaId: MetaIdVdNote
  val parentRegionId: MetaIdVdRegion?
  val status: EnumDefnKindNoteStatus?
  val textSize: EnumDefnTextSize?
  val value: String?
}