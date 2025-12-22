// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnLayoutGridKind;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheetRef;

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
