// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepUpdateField extends StudioEntAutomationStep
{
  @Nullable
  public MetaIdField assignValueFieldId;

  @Nullable
  public StudioBuildArgBinderHolder value;
}
