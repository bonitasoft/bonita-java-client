package org.bonitasoft.testcontainers;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

import static java.lang.String.format;
import static java.util.Collections.singletonList;

/**
 * Bonita Community Container
 * <p>
 * This will start a Bonita Community docker image instance.
 * </p>
 *
 * @param <SELF>, optional, used for enterprise container
 */
@Slf4j
@EqualsAndHashCode(callSuper = true)
public class BonitaContainer<SELF extends BonitaContainer<SELF>> extends GenericContainer<BonitaContainer<SELF>> {

	public static final String BONITA_CONTEXT_PATH = "bonita.context-path";
	public static final String BONITA_CONTEXT_PATH_DEFAULT = "/bonita";
	public static final String BONITA_VERSION = "bonita.version";
	public static final String BONITA_VERSION_DEFAULT = "latest";
	public static final String BONITA_IMAGE_NAME = "bonita.image.name";
	public static final String BONITA_IMAGE_NAME_DEFAULT = "bonita";
	public static final String BONITA_IMAGE_PREFIX = "bonita.image.prefix";
	public static final String BONITA_IMAGE_PREFIX_DEFAULT = "";

	protected String imagePrefix;
	protected String imageName;
	protected String imageVersion;
	protected String contextPath;
	protected String portalUrl;

	/**
	 * Creates an instance from default community image name: <code>bonita:latest</code>
	 */
	public BonitaContainer() {
		this("");
	}

	/**
	 * Creates an instance with from the given image name, usefull for custom images of to target a specific version
	 *
	 * @param dockerImageName the full image name. (eg. my-repo/my-bonita:1.2.3)
	 */
	public BonitaContainer(String dockerImageName) {
		super(dockerImageName);
		String tmpDockerImageName = dockerImageName;
		if (tmpDockerImageName.isEmpty()) {
			tmpDockerImageName = addSlashSuffixIfRequired(getImagePrefix()) + getImageName() + ":" + getImageVersion();
		} else {
			DockerImageName dockerImage = DockerImageName.parse(dockerImageName);
			String repository = dockerImage.getRepository();
			this.imageName = repository.substring(repository.lastIndexOf("/") + 1);
			this.imageVersion = dockerImage.getVersionPart();
			this.imagePrefix = repository.substring(0, repository.indexOf("/" + this.imageName));
		}
		// Call to getDockerImageName trigger a remote fetch ! use local var instead.
		log.info("Using image: {}", tmpDockerImageName);
		this.setDockerImageName(tmpDockerImageName);

		this.setExposedPorts(singletonList(8080));
		this.setWaitStrategy(Wait.forHttp(getBonitaContextPath()));
		Slf4jLogConsumer slf4jLogConsumer = new Slf4jLogConsumer(log);
		this.withLogConsumer(slf4jLogConsumer);
	}

	@NotNull
	private String addSlashSuffixIfRequired(String part) {
		return (!part.isEmpty() && !part.endsWith("/")) ? part + "/" : part;
	}

	@NotNull
	private String addSlashPrefixIfRequired(String part) {
		return (!part.isEmpty() && !part.startsWith("/")) ? "/" + part : part;
	}

	protected String getImagePrefix() {
		if (imagePrefix == null) {
			imagePrefix = System.getProperty(BONITA_IMAGE_PREFIX, BONITA_IMAGE_PREFIX_DEFAULT);
		}
		return imagePrefix;
	}

	protected String getImageName() {
		if (imageName == null) {
			imageName = System.getProperty(BONITA_IMAGE_NAME, BONITA_IMAGE_NAME_DEFAULT);
		}
		return imageName;
	}

	protected String getImageVersion() {
		if (imageVersion == null) {
			imageVersion = System.getProperty(BONITA_VERSION, BONITA_VERSION_DEFAULT);
		}
		return imageVersion;
	}

	protected String getBonitaContextPath() {
		if (contextPath == null) {
			contextPath = addSlashPrefixIfRequired(System.getProperty(BONITA_CONTEXT_PATH, BONITA_CONTEXT_PATH_DEFAULT));
		}
		return contextPath;
	}

	public String getPortalUrl() {
		if (portalUrl == null) {
			String host = this.getHost();
			Integer port = this.getFirstMappedPort();
			portalUrl = format("http://%s:%s" + getBonitaContextPath(), host, port);
		}
		return portalUrl;
	}
}
