// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeSectionVariant
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdLayoutFormEditorComposite
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.dto.StudioBase

open class StudioDtoLayoutFormEditorComposite : StudioBase()
{
  lateinit var compositeId: MetaIdComposite
  var gridLayoutId: MetaIdLayoutGrid? = null
  lateinit var metaId: MetaIdLayoutFormEditorComposite
  var sectionDirection: EnumDefnThemeDirection? = null
  var sectionVariant: EnumDefnThemeSectionVariant? = null
}