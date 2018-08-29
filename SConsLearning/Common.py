def configureEnvironmentForJava( env ):
    env.Append( JAVAVERSION = '1.8' )
    env.Append( JAVA_HOME = 'C:/Program Files/Java/jdk1.8.0_152' )
    env.AppendENVPath( 'PATH', 'C:/Program Files/Java/jdk1.8.0_152/bin' )