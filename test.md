PS C:\Users\GUXTA PERES\Downloads\tddSpringBoot> .\mvnw clean test jacoco:report
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------< com.faculdade:tdd-desconto >---------------------
[INFO] Building tdd-desconto 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.3.2:clean (default-clean) @ tdd-desconto ---
[INFO] Deleting C:\Users\GUXTA PERES\Downloads\tddSpringBoot\target
[INFO] 
[INFO] --- jacoco:0.8.11:prepare-agent (default) @ tdd-desconto ---
[INFO] argLine set to "-javaagent:C:\\Users\\GUXTA PERES\\.m2\\repository\\org\\jacoco\\org.jacoco.agent\\0.8.11\\org.jacoco.agent-0.8.11-runtime.jar=destfile=C:\\Users\\GUXTA PERES\\Downloads\\tddSpringBoot\\target\\jacoco.exec"
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ tdd-desconto ---
[INFO] Copying 1 resource from src\main\resources to target\classes
[INFO] Copying 0 resource from src\main\resources to target\classes
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ tdd-desconto ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 6 source files with javac [debug release 17] to target\classes
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ tdd-desconto ---
[INFO] skip non existing resourceDirectory C:\Users\GUXTA PERES\Downloads\tddSpringBoot\src\test\resources
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ tdd-desconto ---
[INFO] Changes detected - recompiling the module! :dependency
[INFO] Compiling 2 source files with javac [debug release 17] to target\test-classes
[INFO] 
[INFO] --- surefire:3.1.2:test (default-test) @ tdd-desconto ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.faculdade.tdd_desconto.service.PedidoServiceTest
WARNING: A Java agent has been loaded dynamically (C:\Users\GUXTA PERES\.m2\repository\net\bytebuddy\byte-buddy-agent\1.14.12\byte-buddy-agent-1.14.12.jar)
WARNING: If a serviceability tool is in use, please run with -XX:+EnableDynamicAgentLoading to hide this warning
WARNING: If a serviceability tool is not in use, please run with -Djdk.instrument.traceUsage for more information
WARNING: Dynamic loading of agents will be disallowed by default in a future release
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.039 s -- in com.faculdade.tdd_desconto.service.PedidoServiceTest
[INFO] Running com.faculdade.tdd_desconto.TddDescontoApplicationTests
07:12:04.545 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [com.faculdade.tdd_desconto.TddDescontoApplicationTests]: TddDescontoApplicationTests does notdeclare any static, non-private, non-final, nested classes annotated with @Configuration.
07:12:04.972 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration com.faculdade.tdd_desconto.TddDescontoApplication for test class com.faculdade.tdd_desconto.TddDescontoApplicationTests

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.4)

2026-09-29T07:12:06.660-03:00  INFO 8488 --- [tdd-desconto] [           main] c.f.t.TddDescontoApplicationTests        : Starting TddDescontoApplicationTests using Java 21.0.8 with PID 8488 (started by GUXTA PERES in C:\Users\GUXTA PERES\Downloads\tddSpringBoot)
2026-09-29T07:12:06.673-03:00  INFO 8488 --- [tdd-desconto] [           main] c.f.t.TddDescontoApplicationTests        : No active profile set, falling back to 1 default profile: "default"
2026-09-29T07:12:11.529-03:00  INFO 8488 --- [tdd-desconto] [           main] c.f.t.TddDescontoApplicationTests        : Started TddDescontoApplicationTests in 5.837 seconds(process running for 16.239)
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 7.824 s -- in com.faculdade.tdd_desconto.TddDescontoApplicationTests
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- jacoco:0.8.11:report (report) @ tdd-desconto ---
[INFO] Loading execution data file C:\Users\GUXTA PERES\Downloads\tddSpringBoot\target\jacoco.exec
[INFO] Analyzed bundle 'tdd-desconto' with 5 classes
[INFO] 
[INFO] --- jacoco:0.8.11:report (default-cli) @ tdd-desconto ---
[INFO] Loading execution data file C:\Users\GUXTA PERES\Downloads\tddSpringBoot\target\jacoco.exec
[INFO] Analyzed bundle 'tdd-desconto' with 5 classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  25.007 s
[INFO] Finished at: 2026-09-29T07:12:12-03:00
[INFO] ------------------------------------------------------------------------
PS C:\Users\GUXTA PERES\Downloads\tddSpringBoot> 