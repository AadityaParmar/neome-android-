// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeSectionVariant
import com.neome.api.meta.base.Types.MetaIdSection
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioComposite

open class StudioSection : StudioComposite()
{
  var direction: EnumDefnThemeDirection? = null
  lateinit var metaId: MetaIdSection
  var propertyEditorLabelVarId: MetaIdVar? = null
  var sectionVariant: EnumDefnThemeSectionVariant? = null
}