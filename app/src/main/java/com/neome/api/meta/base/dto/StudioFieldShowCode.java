// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnCodeType;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldShowCode extends StudioFieldEditable
{
  @Nullable
  public EnumDefnCodeType codeType;

  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public String defaultValue;

  @Nullable
  public StudioValueVarIdParagraph defaultVarId;

  @Nullable
  public Boolean showLabel;

  @Nullable
  public MetaIdField showLabelFieldId;

  @Nullable
  public MetaIdVar showLabelVarId;
}
