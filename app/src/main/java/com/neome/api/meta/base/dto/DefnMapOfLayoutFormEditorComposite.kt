// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnLayoutFormEditorComposite
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdLayoutFormEditorComposite

open class DefnMapOfLayoutFormEditorComposite
{
  lateinit var keys: Array<MetaIdLayoutFormEditorComposite>
  lateinit var map: Map<MetaIdLayoutFormEditorComposite, DefnLayoutFormEditorComposite>
}