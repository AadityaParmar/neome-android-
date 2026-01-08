// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeSectionVariant
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdLayoutFormEditorComposite
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

interface DefnLayoutFormEditorComposite
{
  val compositeId: MetaIdComposite
  val gridLayoutId: MetaIdLayoutGrid?
  val metaId: MetaIdLayoutFormEditorComposite
  val sectionDirection: EnumDefnThemeDirection?
  val sectionVariant: EnumDefnThemeSectionVariant?
}