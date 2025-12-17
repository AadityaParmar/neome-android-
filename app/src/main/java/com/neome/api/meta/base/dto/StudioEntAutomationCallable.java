// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdPlugin;
import com.neome.api.meta.base.dto.StudioEntAutomation;
import com.neome.api.meta.base.dto.StudioEntAutomationCallableEventMap;

@SuppressWarnings("unused")
public class StudioEntAutomationCallable extends StudioEntAutomation
{
  public StudioEntAutomationCallableEventMap eventMap;

  public MetaIdForm formId;

  @Nullable
  public MetaIdPlugin metaIdPlugin;
}
