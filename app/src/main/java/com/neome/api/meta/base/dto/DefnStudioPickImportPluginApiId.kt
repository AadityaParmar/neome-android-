// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnPluginApiMethod
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.Types.PluginApiId

open class DefnStudioPickImportPluginApiId : DefnFieldEditable()
{
  var excludePluginApiIdSet: Array<PluginApiId>? = null
  var filterApiMethodSet: Array<EnumDefnPluginApiMethod>? = null
  lateinit var metaIdPlugin: MetaIdPlugin
}