package org.bonitasoft.web.client.services.impl.base;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.api.LicenseApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.License;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractService {

    private static final String COMMUNITY = "Community";
    public static final License COMMUNITY_LICENCE = new License().edition(COMMUNITY)
            .nbCpuCores("" + Runtime.getRuntime().availableProcessors());

    protected final ApiProvider apiProvider;
    protected final ObjectMapper objectMapper;
    /** Shared context between services. Allow to cache license info,... */
    private final ClientContext clientContext;

    public License getLicense() {
        // Get licence only once per client lifecycle
        return clientContext.getLicense(
                cacheKey -> {
                    log.info("Get Bonita license");
                    LicenseApi licenseApi = apiProvider.get(LicenseApi.class);
                    try (Response response = licenseApi.getLicense()) {
                        License license;
                        if (response.status() == 200) {
                            try (final Response.Body body = response.body()) {
								InputStream inputStream = body.asInputStream();
                                license = objectMapper.readValue(inputStream, License.class);
                                log.debug("Bonita license: {}", license);
                                return license;
                            } catch (Exception e) {
                                log.error("Failed to read license response", e);
                                return COMMUNITY_LICENCE;
                            }
                        } else {
                            log.debug("Bonita license: {}", COMMUNITY_LICENCE);
                            return COMMUNITY_LICENCE;
                        }
                    }
                });
    }

    public boolean isCommunity() {
        return COMMUNITY.equalsIgnoreCase(getLicense().getEdition());
    }
}
