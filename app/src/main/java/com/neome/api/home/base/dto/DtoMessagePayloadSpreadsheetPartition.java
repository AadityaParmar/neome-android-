// neome.ai API - do not change
//

package com.neome.api.home.base.dto;

import com.neome.api.home.main.sig.SigSpreadsheetRow;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.meta.base.Types.SpreadsheetPartitionId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoMessagePayloadSpreadsheetPartition extends DtoMessagePayload
{
  public DtoChatBubbleHeader chatBubbleHeader;

  public MetaIdForm formId;

  @Nullable
  public DtoPartition[] partitionList;

  @Nullable
  public RowId rowId;

  public MetaIdSpreadsheet spreadsheetId;

  public SpreadsheetPartitionId spreadsheetPartitionId;

  @Nullable
  public SigSpreadsheetRow spreadsheetRow;
}
