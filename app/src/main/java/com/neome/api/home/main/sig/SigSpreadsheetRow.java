// neome.ai API - do not change
//

package com.neome.api.home.main.sig;

import com.neome.api.meta.base.Types.MetaIdComp;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.SpreadsheetPartitionId;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class SigSpreadsheetRow extends SigVersion
{
  public MetaIdForm formId;

  @Nullable
  public FormValueRaw formValue;

  @Nullable
  public SigSpreadsheetRowCommentCount rowCommentCount;

  public MetaIdSpreadsheet spreadsheetId;

  public SpreadsheetPartitionId spreadsheetPartitionId;

  @Nullable
  public Set<MetaIdComp> updatedKeySet;
}
