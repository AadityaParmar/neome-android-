// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DtoLogTree
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVdAutoNode

interface DtoWorkflowParameterInfo
{
  val branchNodeId: MetaIdVdAutoNode?
  val form: DefnForm
  val formValue: FormValueRaw?
  val formValueLogTree: DtoLogTree?
  val name: String
  val paramId: MetaIdPipelineParam?
}