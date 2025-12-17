// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnLockOperation;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepLock extends StudioEntAutomationStep
{
  @Nullable
  public MetaIdField errorFieldId;

  @Nullable
  public MetaIdVar errorRetryCountVarId;

  @Nullable
  public MetaIdVar errorRetryDurationVarId;

  @Nullable
  public FieldDtoDuration lockDuration;

  @Nullable
  public MetaIdField lockKeyFieldId;

  @Nullable
  public EnumDefnLockOperation operation;

  @Nullable
  public MetaIdPipelineParam sourcePipelineVarId;
}
