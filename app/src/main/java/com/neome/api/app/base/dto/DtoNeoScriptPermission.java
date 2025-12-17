// neome.ai API - do not change
//

package com.neome.api.app.base.dto;

import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoNeoScriptPermission extends DtoNeoScript
{
  @Nullable
  public MetaIdComposite compositeId;

  @Nullable
  public MetaIdField fieldId;

  @Nullable
  public MetaIdForm formId;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
