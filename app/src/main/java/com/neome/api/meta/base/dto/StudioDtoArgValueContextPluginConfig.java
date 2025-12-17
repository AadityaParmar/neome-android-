// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoArgValueContextPluginConfig extends StudioDtoArgValueContext
{
  @Nullable
  public MetaIdComposite compositeId;

  public MetaIdField fieldId;

  @Nullable
  public String[] valuePathArray;
}
