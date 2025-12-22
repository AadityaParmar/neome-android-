// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldHtml extends StudioField
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public String defaultValue;

  @Nullable
  public MetaIdVar defaultVarId;

  @Nullable
  public String placeHolder;

  @Nullable
  public MetaIdField placeHolderFieldId;

  @Nullable
  public StudioValueVarIdParagraph placeHolderVarId;

  @Nullable
  public Boolean showCloseButton;
}
