// neome.ai API - do not change
//

package com.neome.api.ent.entMain.sig;

import com.neome.api.ent.base.dto.DtoAuditRecord;
import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigAuditRecordList extends Sig
{
  @Nullable
  public DtoAuditRecord[] auditRecordList;
}
