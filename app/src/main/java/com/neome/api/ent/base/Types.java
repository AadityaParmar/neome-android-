// neome.ai API - do not change
//

package com.neome.api.ent.base;

@SuppressWarnings({
  "unused",
  "ClassTooDeepInInheritanceTree"
})
public class Types
{
  public enum EnumAuditAction
  {
    INSERT,
    UPDATE,
    REMOVE
  }

  public enum EnumAutomationStateFilterKind
  {
    completed,
    pause,
    terminated,
    wait
  }

  public enum EnumAutomationStateKind
  {
    completed,
    pause,
    running,
    terminated,
    wait
  }

  public enum EnumFieldFilterValueType
  {
    bool,
    dateRange,
    longRange,
    doubleRange,
    stringSet,
    sysIdSet,
    nullable
  }

  public enum EnumGuaranteedRequestType
  {
    pluginRequest
  }

  public enum EnumLogType
  {
    pluginApi,
    report,
    location
  }

  public enum EnumWorkflowDebugActionKind
  {
    run,
    next
  }

  public enum EnumWorkflowResultKind
  {
    completed,
    pause,
    running,
    terminated,
    wait
  }
}