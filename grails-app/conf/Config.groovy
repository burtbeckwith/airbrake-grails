// configuration for plugin testing - will not be included in the plugin zip

log4j = {

    appenders {
        console name:'stdout', layout:pattern(conversionPattern: '%c %m%n')

        appender name: 'airbrake', new grails.plugins.airbrake.AirbrakeAppender(
                api_key: 'API_KEY',
                env: ((Environment.current == Environment.PRODUCTION) ? 'prod' : 'dev')
        )
    }

    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
           'org.codehaus.groovy.grails.web.pages', //  GSP
           'org.codehaus.groovy.grails.web.sitemesh', //  layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping', // URL mapping
           'org.codehaus.groovy.grails.commons', // core / classloading
           'org.codehaus.groovy.grails.plugins', // plugins
           'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'

    warn   'org.mortbay.log'

    root {
        debug 'stdout', 'airbrake'
    }
}
