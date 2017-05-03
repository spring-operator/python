/*
 * Copyright 2017 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.springframework.cloud.stream.app.python.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.validation.annotation.Validated;

/**
 * Properties for the Python Wrapper.
 *
 * @author David Turanski
 **/
@Validated
@ConfigurationProperties(PythonWrapperProperties.PREFIX)
public class PythonWrapperProperties {

	static final String PREFIX = "wrapper";

	/**
	 * The Wrapper script path.
	 */
	private String script;

	public String getScript() {
		return this.script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public Resource getScriptResource() {
		return resolveResource(script);
	}

	private Resource resolveResource(String resourceName) {
		return new PathMatchingResourcePatternResolver().getResource(resourceName);
	}
}