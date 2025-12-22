// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.ent.base.Types.EnumAuditAction;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.RowId;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class DtoAuditRecord
{
  @Nullable
  public EnumAuditAction auditAction;

  @Nullable
  public Date dateTime;

  @Nullable
  public EntId entId;

  @Nullable
  public EntUserId entUserId;

  @Nullable
  public MetaIdForm formId;

  @Nullable
  public String formValueRefKey;

  @Nullable
  public String[] historyFieldLabelSet;

  @Nullable
  public String[] historyFieldValueSet;

  @Nullable
  public String offset;

  @Nullable
  public RowId rowId;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;

  @Nullable
  public String spreadsheetName;

  @Nullable
  public String version;
}
