var newData= {
	"view": {
		"id": "640"
	},
	"symbols": {
		"add": [{
			"id": "tmp-1572332142279",
			"name": "R0001",
			"x": "70",
			"y": "40",
			"type": "0",
			"viewId": "640",
			"parentId": "-1",
			"objectId": "0001",
			"objectClass": "3003",
			"instanceId": "",
			"style": "icon:h3c/h3_router_general.svg;icon-width:57;icon-height:41;",
			"options": "",
			"url": "",
			"alarm": ""
		}],
		"modify": [{
			"id": "665",
			"name": "Internet1",
			"x": "190",
			"y": "30",
			"type": "0",
			"viewId": "640",
			"parentId": "-1",
			"objectId": "-1",
			"objectClass": "",
			"instanceId": "",
			"style": "icon:h3c/h3_internet.svg;icon-width:88;icon-height:55;opacity:1;text-stroke-color:;text-border-color:;text-border-fill-color:;text-border-radius:0;text-display:0;font-family:COURIER;font-color:#000000;font-weight:bold;",
			"options": "custom-label:1;",
			"url": "",
			"alarm": ""
		}],
		"delete": []
	},
	"lines": {
		"add": [],
		"modify": [{
			"id": "677",
			"name": "FirewallA -> Internet1",
			"path": "M 272 158 L 234 57",
			"type": "0",
			"srcSymbol": "664",
			"dstSymbol": "665",
			"viewId": "640",
			"parentId": "-1",
			"objectId": "-1",
			"objectClass": "-1",
			"instanceId": "-1",
			"style": "",
			"options": "custom-label:0;",
			"url": "",
			"alarm": "tfr-to-symbol:-1;"
		}],
		"delete": []
	},
	"alarmTfr": 1
}