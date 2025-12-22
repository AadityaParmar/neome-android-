// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnLogOperationKind;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdRowUpdateFieldLogNumber extends EntVdAutoStepWithError
{
  @Nullable
  public StudioBuildArgBinder inputField;

  @Nullable
  public EnumDefnLogOperationKind operation;

  @Nullable
  public StudioValueText operationMessage;

  @Nullable
  public MetaIdField outputLogNumberFieldId;

  @Nullable
  public StudioDtoRowIdPointer rowIdPointer;
}
