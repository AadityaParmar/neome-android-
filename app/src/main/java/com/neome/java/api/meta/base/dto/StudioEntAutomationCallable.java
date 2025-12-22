// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdPlugin;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationCallable extends StudioEntAutomation
{
  public StudioEntAutomationCallableEventMap eventMap;

  public MetaIdForm formId;

  @Nullable
  public MetaIdPlugin metaIdPlugin;
}
