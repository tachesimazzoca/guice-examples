.PHONY: compile
compile:
	@mvn compile

.PHONY: test
test:
	@mvn test

.PHONY: package
package:
	@mvn package

.PHONY: clean
clean:
	@mvn clean

.PHONY: serve
serve:
	@java -jar target/guice-dropwizard-0.1.0-SNAPSHOT.jar server conf/server.yml
