/**
 *
 */
var SCONFIG = (function() {
	var SROOT_PATH = "/mgbf_mult_web_fundacionbancomerextranetwebfront_01/",
		SAMBIENT = "",
	    servOrigin = window.location.origin;
	if(servOrigin.indexOf("150.250.238.172")!=-1){SAMBIENT = '/mgbfpub_des_mx_web';}
	else if(servOrigin.indexOf("150.250.238.173")!=-1){SAMBIENT = '/mgbfpub_test_mx_web';}
	var services = {
			'VALIDATION_SCHOLAR': 'validation/scholar',
			'LDAPSCHOLAR_CREATE':'ldapScholar/create',
			'LDAPSCHOLAR_GETSTATUS':'ldapScholar/getstatus',
			'LDAPSCHOLAR_UPDATEPASSWORD':'ldapScholar/updatepassword',
			"LDAPSCHOLAR_REACTIVATION":'ldapScholar/reactivation'
	};
	return {
		get: function(name) { return SAMBIENT+SROOT_PATH+services[name]; }
	};
})();
