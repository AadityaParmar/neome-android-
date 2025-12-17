// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef;
import com.neome.api.meta.base.dto.StudioBase;

@SuppressWarnings("unused")
public class StudioEntSpreadsheetRefTokenMap extends StudioBase
{
  @Nullable
  public Map<MetaIdSpreadsheetRef, String> refTokenMap;
}
