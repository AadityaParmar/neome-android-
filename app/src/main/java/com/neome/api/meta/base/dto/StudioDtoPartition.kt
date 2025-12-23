// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdPartition
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioValueCodeJavascript
import com.neome.api.meta.base.Symbol

open class StudioDtoPartition : StudioBase()
{
  lateinit var assignPartitionFieldId: MetaIdField
  lateinit var formula: StudioValueCodeJavascript
  lateinit var metaId: MetaIdPartition
  lateinit var name: Symbol
}