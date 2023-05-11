/** 
 * Copyright (C) 2023 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client.feign;

import org.bonitasoft.web.client.invoker.ApiClient;

public interface ApiProvider {

    /**
     * Return the underlying raw http client API. <br>
     * <br>
     * <b>Beware that raw API access directly map to http request !! </b> <br>
     * <br>
     * <p>You won't benefit from bonita client facilities ( ie. request and payload validation, ...)
     * and that <b>your code</b> will be <b>highly coupled to the underlying client technology</b> !
     * <p>This access is provided to avoid people being blocked by the current limited Bonita client
     * implementation. This may be removed in the future.
     *
     * @param apiClass the class of the requested API instance type
     * @param <T> the specific API type
     * @return an API instance of type T
     */
    <T extends ApiClient.Api> T get(Class<T> apiClass);
}
