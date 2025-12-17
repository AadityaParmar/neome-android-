// neome.ai API - do not change
//

package com.neome.api.ent.entMain.sig;

import com.neome.api.ent.base.dto.DtoDebuggerLogEntry;
import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigDebuggerLogsGet extends Sig
{
  @Nullable
  public DtoDebuggerLogEntry[] logList;
}
