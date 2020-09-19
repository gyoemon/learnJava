/**
 * Copyright 2020 sakaguchi<uqw@outlook.jp>, https://github.com/sakaguchi3/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.sakaguchi3.serverpro.server;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.vavr.control.Try;

/**
 * 
 */
public class RestUserServlet extends HttpServlet {

	// ---------------------------------------------------------
	// field
	// ---------------------------------------------------------

	/** */
	private static final long serialVersionUID = 8907340394573966L;
	/** Log instance */
	protected static final Logger LOG = LogManager.getLogger();

	protected static final ObjectMapper MAPPER = (new ObjectMapper()) //
			.setSerializationInclusion(JsonInclude.Include.NON_EMPTY); // remove null

	String responseJson;

	// ---------------------------------------------------------
	// public method
	// ---------------------------------------------------------

	@Override
	public void init() {
		var baseResponseMap = Map.of( //
				"id:", 30, //
				"domain", List.of("google.com", "yahoo.co.jp", "wikipedia.org"), //
				"memo", "success");
		var str = Try.of(() -> MAPPER.writeValueAsString(baseResponseMap)).getOrElse("");
		responseJson = str;
	}

	// ---------------------------------------------------------
	// private method
	// ---------------------------------------------------------

	/** select */
	@Override
	protected void doGet(HttpServletRequest httpReq, HttpServletResponse httpRes) {

		var param = httpReq.getParameterMap();

		// multi val: [neko, ushi]
		var idVals = Arrays.asList(param.getOrDefault("id", new String[0]));
		// single val: neko
		var idVal = httpReq.getParameter("id");

		// resposne ----
		try (var w = httpRes.getWriter()) {
			w.append(responseJson);
			w.flush();
		} catch (IOException e1) {
			LOG.info(e1.getMessage(), e1);
			try {
				httpRes.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			} catch (Exception e2) {
				LOG.info(e2.getMessage(), e2);
			}
		}
	}

	/** insert */
	@Override
	protected void doPost(HttpServletRequest httpReq, HttpServletResponse httpRes) {
		// resposne ----
		try (var w = httpRes.getWriter()) {
			w.append(responseJson);
			w.flush();
		} catch (IOException e1) {
			LOG.info(e1.getMessage(), e1);
			try {
				httpRes.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			} catch (Exception e2) {
				LOG.info(e2.getMessage(), e2);
			}
		}
	}

	/** update */
	@Override
	protected void doPut(HttpServletRequest httpReq, HttpServletResponse httpRes) {

		// resposne ----
		try (var w = httpRes.getWriter()) {
			w.append(responseJson);
			w.flush();
		} catch (IOException e1) {
			LOG.info(e1.getMessage(), e1);
			try {
				httpRes.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			} catch (Exception e2) {
				LOG.info(e2.getMessage(), e2);
			}
		}

	}

	/** delete */
	@Override
	protected void doDelete(HttpServletRequest httpReq, HttpServletResponse httpRes) {
		// resposne ----
		try (var w = httpRes.getWriter()) {
			w.append(responseJson);
			w.flush();
		} catch (IOException e1) {
			LOG.info(e1.getMessage(), e1);
			try {
				httpRes.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			} catch (Exception e2) {
				LOG.info(e2.getMessage(), e2);
			}
		}
	}

	void debug() {
	}

}
