package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.PathVariable;

public interface InitialDataService {
		public Response getScholarInfo(@PathVariable String idScholar);
}
