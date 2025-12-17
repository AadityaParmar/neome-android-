// neome.ai API - do not change
//

package com.neome.api.app.base.dto;

import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdForm;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoNeoScriptMenu extends DtoNeoScript
{
  @Nullable
  public MetaIdComposite compositeId;

  @Nullable
  public MetaIdForm formId;
}
