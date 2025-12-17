// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickSpreadsheetRefLayoutId extends DefnFieldEditable
{
  @Nullable
  public EnumDefnLayoutGridKind[] filterLayoutKindSet;

  public MetaIdForm formId;

  @Nullable
  public MetaIdSpreadsheetRef spreadsheetRefId;
}
