// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.base

object Types
{
  enum class EnumKindAiAssist(val value: String)
  {
    module("module"),
    plugin("plugin"),
    role("role"),
    var_("var"),
    form("form"),
    composite("composite"),
    field("field"),
    formula("formula"),
    visibilityRule("visibilityRule"),
    formLayout("formLayout"),
    spreadsheet("spreadsheet"),
    layoutSpreadsheet("layoutSpreadsheet"),
    report("report"),
    automation("automation"),
    eventAndStep("eventAndStep"),
    action("action"),
    group("group"),
    deeplink("deeplink"),
    driveSheet("driveSheet"),
    prompt("prompt")
  }

  enum class EnumKindNeoScript(val value: String)
  {
    action("action"),
    deeplink("deeplink"),
    driveSheet("driveSheet"),
    form("form"),
    formula("formula"),
    group("group"),
    layout("layout"),
    layoutSpreadsheet("layoutSpreadsheet"),
    menu("menu"),
    module("module"),
    permission("permission"),
    plugin("plugin"),
    report("report"),
    role("role"),
    spreadsheet("spreadsheet"),
    translation("translation"),
    var_("var"),
    visibilityRule("visibilityRule")
  }
}