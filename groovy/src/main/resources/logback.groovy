//
// Built on Fri Aug 14 09:58:36 CEST 2015 by logback-translator
// For more information on configuration files in Groovy
// please see http://logback.qos.ch/manual/groovy.html

// For assistance related to this tool or configuration files
// in general, please contact the logback user mailing list at
//    http://qos.ch/mailman/listinfo/logback-user

// For professional support please see
//   http://www.qos.ch/shop/products/professionalSupport

import static ch.qos.logback.classic.Level.DEBUG

["cn.boxfish"].each {
    logger(it, DEBUG)
}