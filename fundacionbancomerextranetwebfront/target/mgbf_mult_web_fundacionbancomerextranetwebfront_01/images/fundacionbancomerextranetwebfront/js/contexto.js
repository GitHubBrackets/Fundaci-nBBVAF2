var scholar = {
    "studentID": -1,
	"personalData": {
        "username": ":null:",
		"name": ":null:",
		"lastName": ":null:",
		"secondLastName": ":null:",
        "originRegion": ":null:",
        "originState": ":null:",
        "cdOriginState" : ":null:",
        "originMunicipality" : ":null:",
        "cdOriginMunicipality": ":null:",
        "curp": ":null:",
        "birthdate": ":null:",
        "age": -6,
        "gender": ":null:",
        "cdAssignedCR": ":null:",
        "assignedCR": ":null:",
        "accountNumber": ":null:",
        "scholarNumber": ":null:",
        "profilePicture": ":null:",
        "base64ProfilePicture": "",
	},
	"scholarship": {
        "statusDispersion": ":null:",
		"programName": ":null:",
        "programType": ":null:",
        "modalityParticipation": ":null:",
        "confirmDispersion": []
	},
    "schoolData": {
        "name" : ":null:",
        "domicile": ":null:",
        "type": ":null:",
        "initials": ":null:",
        "control": ":null:",
        "cct": ":null:",
        "state": ":null:",
        "cdState": ":null:",
        "municipality": ":null:",
        "cdMunicipality": ":null:",
        "typeCareer": ":null:",
        "nameCareer": ":null:",
        "area": ":null:",
        "turn": ":null:",
        "duration": ":null:"
    },
    "domicile": {
        "street": ":null:",
        "numExterior": ":null:",
        "numInterior": ":null:",
        "codePostal": ":null:",
        "state": ":null:",
        "cdState": ":null:",
        "municipality": ":null:",
        "cdMunicipality": ":null:",
        "locality": ":null:",
        "colony": ":null:",
        "betweenStreet": ":null:",
        "typeOfRoad1": ":null:",
        "andTheStreet": ":null:",
        "typeOfRoad2": ":null:",
        "behindStreet": ":null:",
        "typeOfRoad3": ":null:",
        "particularReferences": ":null:"
    },
    "contactData": {
        "homePhone": ":null:",
        "cellPhone": ":null:",
        "messagePhone": ":null:",
        "email": ":null:",
        "email1": ":null:",
        "email2": ":null:"
    },
    "tutorData": {
        "name": ":null:",
        "lastName": ":null:",
        "secondLastName": ":null:",
        "kinship": ":null:",
        "kinshipType": ":null:"
    },
    "statusQualifications": {
    	"schoolCycle": "",
    	"schoolGrade": "",
    	"averageSchoolGrade": -10,
        "schoolLevels": [
                         {
                             "scholarLevel": "Secundaria",
                             "scholarGrades": [
                                 {
                                     "scholarGrade": "1er año de secundaria"
                                 },
                                 {
                                     "scholarGrade": "2o año de secundaria"
                                 },
                                 {
                                     "scholarGrade": "3er año de secundaria"
                                 }
                             ]
                          }
                         ],
       "averagesScholarLevel": [/*
                                 {
                                 	"isMissing": false,
						        	"folio": "IMX0000231040328785166",
						        	"qualification": 9.28,
						        	"scholarLevel": "Secundaria",
						        	"schoolGrade": "1er año de secundaria",
						        	"schoolPeriod": "1er bimestre"
						        },
						        {
						        	"isMissing": true,
						            "scholarLevel": "Secundaria",
						            "schoolGrade": "1er año de secundaria",
						            "schoolPeriod": "2o bimestre",
						            "qualification": 0
						        }
						       */ ],
        "averagesSchoolGrade": [
                                {
                                    "scholarLevel": "Secundaria",
                                    "averageScholarLevel": 0,
                                    "averagesSchoolGrade": [
                                        {
                                            "schoolGrade": "1er año de secundaria",
                                            "averageSchoolGrade": 8.1,
                                            "folio": "IMX0000406785819487474"
                                        },
                                        {
                                            "schoolGrade": "2o año de secundaria",
                                            "averageSchoolGrade": 9.69,
                                            "folio": "IMX0000406785819487474"
                                        },
                                        {
                                            "schoolGrade": "3er año de secundaria",
                                            "averageSchoolGrade": 8.87,
                                            "folio": "IMX0000406785819487474"
                                        }
                                    ]
                                 }
                                ],
        "constancyFolio": "",
        "constancyNextGrade": "",
        "indicatorMissingConstancy": 0
    },
    "program": [
            	/*{
                    "status": "Seleccionado",
                    "modalityParticipation": "Fundación Bancomer",
                    "generation": "2015-2020",
                    "originResources": "Fundación Bancomer",
                    "projectSEPNumber": "0",
                    "numberNMDP": "0",
                    "schoolGrade": "3er año de universidad",
                    "resultImpactEvaluation": "Tratamiento 3"
                }*/
            ],
	"alerts": [
                /*{"message": "Aqu&iacute; aparecen los mensajes para el becario (:"},
                {"message": "Aqu&iacute; aparece la segunda alerta"},
                {"message": "Aqu&iacute; aparecen la tercer alerta"},
                {"message": "Aqu&iacute; aparece la cuarta alerta"}*/
    ],
	"confirm": []
};
var statesTransactions = [];

var currentStateMunicipality = {municipalityTransactions:[]};

var combos = {
		"gender": [],
		"typeOfViality": [],
		"kindship": [],
		"cdRB": []
};
