// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.sig;

import com.neome.java.api.home.base.dto.DtoChatMessageListMap;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.RowId;
import com.neome.java.api.meta.base.dto.FormValue;
import com.neome.java.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class SigDrawerSearch extends Sig
{
  @Nullable
  public Map<EntId, Map<MetaIdSpreadsheet, FormValue[]>> auditRecordMap;

  @Nullable
  public SigGroupAvatar[] groupAvatarList;

  @Nullable
  public Map<EntId, DtoChatMessageListMap> latestMessageMap;

  @Nullable
  public Map<EntId, Map<MetaIdSpreadsheet, Set<RowId>>> spreadsheetRowMap;

  public long totalMessageCount;

  @Nullable
  public SigUserAvatar[] userAvatarList;
}
