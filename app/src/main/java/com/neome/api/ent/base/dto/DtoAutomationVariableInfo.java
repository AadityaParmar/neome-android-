// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.dto.DefnForm;
import com.neome.api.meta.base.dto.DtoLogTree;
import com.neome.api.meta.base.dto.FormValueRaw;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoAutomationVariableInfo
{
  public DefnForm form;

  @Nullable
  public FormValueRaw formValue;

  @Nullable
  public DtoLogTree formValueLogTree;

  public String name;

  @Nullable
  public MetaIdPipelineParam pipelineVarId;
}
