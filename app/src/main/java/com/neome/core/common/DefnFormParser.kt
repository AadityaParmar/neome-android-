package com.neome.core.common

class DefnFormParser {


    fun createSampleDefnForm(): String {
        return """
         {
           "metaId": "mf-pdPRpwtlFt",
           "name": "DefnForm",
           "compMap": {
             "mtb-pdPRpwtlFt": {
               "metaId": "mtb-pdPRpwtlFt",
               "tabIdSet": [
                 "msc-MgknD5pYZT",
                 "msc-iq4fe3O1IV",
                 "mgr-QtTkTuXYKw"
               ],
               "name": "DefnForm",
               "type": "tab",
               "disabled": false
             },
             "mfd-HxbXkSxSQY": {
               "requiredFieldId": "mfd-qDpfN1vSGT",
               "metaId": "mfd-HxbXkSxSQY",
               "name": "FieldText",
               "type": "text",
               "label": "Text Field",
               "permissionMatrix": {
                 "keys": [],
                 "map": {}
               }
             },
             "mfd-qDpfN1vSGT": {
               "helperTextFieldId": "mfd-HxbXkSxSQY",
               "metaId": "mfd-qDpfN1vSGT",
               "name": "FieldBool",
               "type": "bool",
               "label": "Boolean Field",
               "permissionMatrix": {
                 "keys": [],
                 "map": {}
               }
             },
             "mfd-1R1vfYHuYg": {
               "defaultValue": 10,
               "metaId": "mfd-1R1vfYHuYg",
               "name": "FieldNumber",
               "type": "number",
               "label": "Number Field",
               "permissionMatrix": {
                 "keys": [],
                 "map": {}
               }
             },
             "mfd-pAGBF98cPc": {
               "optionMap": {
                 "keys": [
                   "keyRed",
                   "keyGreen",
                   "keyBlue"
                 ],
                 "map": {
                   "keyRed": {
                     "metaId": "keyRed",
                     "value": "Red",
                     "color": {
                       "value": "red",
                       "shade": "s500"
                     },
                     "isRemoved": false,
                     "disabled": false
                   },
                   "keyGreen": {
                     "metaId": "keyGreen",
                     "value": "Green",
                     "color": {
                       "value": "green",
                       "shade": "s500"
                     },
                     "isRemoved": false,
                     "disabled": false
                   },
                   "keyBlue": {
                     "metaId": "keyBlue",
                     "value": "Blue",
                     "color": {
                       "value": "blue",
                       "shade": "s500"
                     },
                     "isRemoved": false,
                     "disabled": false
                   }
                 }
               },
               "metaId": "mfd-pAGBF98cPc",
               "name": "FieldPickText",
               "type": "pickText",
               "label": "Pick Color",
               "permissionMatrix": {
                 "keys": [],
                 "map": {}
               }
             },
             "msc-MgknD5pYZT": {
               "metaId": "msc-MgknD5pYZT",
               "fieldIdSet": [
                 "mfd-HxbXkSxSQY",
                 "mfd-qDpfN1vSGT",
                 "mfd-1R1vfYHuYg",
                 "mfd-pAGBF98cPc"
               ],
               "flexGrow": false,
               "name": "Section1",
               "type": "section",
               "label": "Basic Fields",
               "permissionMatrix": {
                 "keys": [],
                 "map": {}
               }
             },
             "mfd-k9fXu7XtBX": {
               "metaId": "mfd-k9fXu7XtBX",
               "name": "FieldDate",
               "type": "date",
               "label": "Date Field",
               "permissionMatrix": {
                 "keys": [],
                 "map": {}
               }
             },
             "mfd-gdb26wJtRW": {
               "metaId": "mfd-gdb26wJtRW",
               "name": "FieldEmail",
               "type": "email",
               "label": "Email Field",
               "permissionMatrix": {
                 "keys": [],
                 "map": {}
               }
             },
             "msc-iq4fe3O1IV": {
               "metaId": "msc-iq4fe3O1IV",
               "fieldIdSet": [
                 "mfd-k9fXu7XtBX",
                 "mfd-gdb26wJtRW"
               ],
               "flexGrow": false,
               "name": "Section2",
               "type": "section",
               "label": "Advanced Fields",
               "permissionMatrix": {
                 "keys": [],
                 "map": {}
               }
             },
             "mfd-wIACoHHagW": {
               "metaId": "mfd-wIACoHHagW",
               "name": "GridFieldText",
               "type": "text",
               "label": "Grid Text",
               "permissionMatrix": {
                 "keys": [],
                 "map": {}
               }
             },
             "mfd-QtN0Joxw3j": {
               "metaId": "mfd-QtN0Joxw3j",
               "name": "GridFieldBool",
               "type": "bool",
               "label": "Grid Bool",
               "permissionMatrix": {
                 "keys": [],
                 "map": {}
               }
             },
             "mgr-QtTkTuXYKw": {
               "metaId": "mgr-QtTkTuXYKw",
               "fieldIdSet": [
                 "mfd-wIACoHHagW",
                 "mfd-QtN0Joxw3j"
               ],
               "name": "Grid",
               "type": "grid",
               "label": "Grid (Not Implemented)",
               "permissionMatrix": {
                 "keys": [],
                 "map": {}
               }
             }
           },
           "displayCompositeId": "mtb-pdPRpwtlFt",
           "gridLookupMap": {}
         }
         """.trimIndent()
    }
}
