// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepGenerateImage extends StudioEntAutomationStepGenerateDocument
{
  @Nullable
  public MetaIdField imageFieldId;

  @Nullable
  public MetaIdForm imageFormId;

  @Nullable
  public MetaIdVar imageFormMappingVarId;
}
