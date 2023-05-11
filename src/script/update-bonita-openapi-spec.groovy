import org.slf4j.LoggerFactory

import groovy.util.logging.Slf4j

def log = LoggerFactory.getLogger('')

def basedir = new File(properties['basedir'])
def bonitaSpecVersion = properties['bonita-openapi.version']
def remoteBonitaSpec = "https://github.com/bonitasoft/bonita-openapi/releases/download/$bonitaSpecVersion/bonita-openapi-${bonitaSpecVersion}.yaml".toURL()
def bonitaSpec = new File(basedir, 'api/bonita-openapi.yaml')
log.info "Download spec from ${remoteBonitaSpec}..."
bonitaSpec.write(remoteBonitaSpec.text)
log.info "api/bonita-openapi.yaml updated with $bonitaSpecVersion content !"