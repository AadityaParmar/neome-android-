// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdNote
import com.neome.api.meta.base.dto.EntVdRegion
import com.neome.api.meta.base.dto.EntVdViewport
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdModule
import com.neome.api.meta.base.Types.MetaIdVdNote
import com.neome.api.meta.base.Types.MetaIdVdRegion
import com.neome.api.meta.base.dto.StudioBase

interface EntVdDia : StudioBase
{
  val isDefault: Boolean?
  val moduleId: MetaIdModule?
  val noteMap: Map<MetaIdVdNote, EntVdNote>
  val regionMap: Map<MetaIdVdRegion, EntVdRegion>
  val viewport: EntVdViewport?
}