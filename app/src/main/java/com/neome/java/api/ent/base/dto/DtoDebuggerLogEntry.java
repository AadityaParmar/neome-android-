// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.ent.base.Types.EnumLogType;
import com.neome.java.api.meta.base.dto.DefnForm;
import com.neome.java.api.meta.base.dto.DtoLogTree;
import com.neome.java.api.meta.base.dto.FormValueRaw;
import com.neome.java.api.nucleus.base.dto.EnvError;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class DtoDebuggerLogEntry
{
  @Nullable
  public String caller;

  @Nullable
  public Date dateTime;

  @Nullable
  public EnvError envError;

  @Nullable
  public DefnForm inputForm;

  @Nullable
  public DtoLogTree inputFormLogTree;

  @Nullable
  public FormValueRaw inputFormValue;

  @Nullable
  public EnumLogType logType;

  @Nullable
  public String name;

  @Nullable
  public DefnForm outputForm;

  @Nullable
  public DtoLogTree outputFormLogTree;

  @Nullable
  public FormValueRaw outputFormValue;

  @Nullable
  public Object summary;
}
