/*
 * Copyright 2016 the original author or authors.
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

package org.example.webapp.integration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class ITConfig {


	@Bean
	public WebDriver webDriver() throws MalformedURLException {
		return new RemoteWebDriver(getRemoteUrl(), getDesiredCapabilities());
	}

	private DesiredCapabilities getDesiredCapabilities() {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		/*
		 * if (useSauceLabs()) { capabilities.setCapability("tunnel-identifier",
		 * env.getProperty("TRAVIS_JOB_NUMBER"));
		 * capabilities.setCapability("seleniumVersion",
		 * env.getProperty("selenium.version")); }
		 */

		return capabilities;
	}


	private URL getRemoteUrl() throws MalformedURLException {
		return new URL("http://localhost:9515");
	}
}
