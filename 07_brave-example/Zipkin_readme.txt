https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html


https://zipkin.io/pages/quickstart.html


cd webmvc4
mvn jetty:run -Pfrontend
mvn jetty:run -Pbackend



cd webmvc4-boot
mvn compile exec:java -Dexec.mainClass=brave.webmvc.Backend
mvn compile exec:java -Dexec.mainClass=brave.webmvc.Frontend


curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar


Front End
http://localhost:8081/


Back End
http://localhost:9000/api


Zipkin
http://localhost:9411/?serviceName=backend


curl -s localhost:8081 -H'user-name: restrada'

