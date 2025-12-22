// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdComposite;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoArgValueOutput extends StudioDtoArgValue
{
  @Nullable
  public MetaIdComposite compositeId;

  @Nullable
  public MetaIdField fieldId;
}
