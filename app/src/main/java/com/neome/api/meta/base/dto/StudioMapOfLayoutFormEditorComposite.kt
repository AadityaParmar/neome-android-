// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdLayoutFormEditorComposite
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutFormEditorComposite

open class StudioMapOfLayoutFormEditorComposite : StudioBase()
{
  lateinit var keys: Array<MetaIdLayoutFormEditorComposite>
  lateinit var map: Map<MetaIdLayoutFormEditorComposite, StudioDtoLayoutFormEditorComposite>
}