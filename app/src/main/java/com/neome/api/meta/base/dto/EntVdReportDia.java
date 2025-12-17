// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdReport;
import com.neome.api.meta.base.Types.MetaIdVdReportDia;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class EntVdReportDia extends EntVdDia
{
  @Nullable
  public Map<MetaIdForm, EntVdReportIOForm> ioFormMap;

  @Nullable
  public String label;

  public MetaIdVdReportDia metaId;

  public Symbol name;

  @Nullable
  public Map<MetaIdReport, EntVdReport> reportMap;
}
