REPO_URL=retex-iconic/iconic.xr.shared-lib
PROFILE=github
release-init:

	release-please bootstrap \
  		--token=$(GH_TOKEN) \
  		--repo-url=$(REPO_URL) \
  		--release-type=maven 


release-pr:
  
	release-please release-pr \
		--token=$(GH_TOKEN) \
		--repo-url=$(REPO_URL) \
		--release-type=maven \
		--release-as=0.0.1

merge-pr:

	gh pr merge release-please--branches--main -m -d 

publish:

	release-please github-release \
		--token=$(GH_TOKEN) \
		--repo-url=$(REPO_URL) 
	

merge-publish: merge-pr publish

package:


	mvn clean package -DskipTests -Dapstruct.verbose=true

install:

	mvn clean package install -DskipTests	

deploy:

	git pull
	mvn deploy -P$(PROFILE)

fmt:
	mvn com.spotify.fmt:fmt-maven-plugin:format	

echo:

	echo token: $(GH_TOKEN)
	echo user: $(GH_USER)

kafka-run:

	cd .docker && docker compose -f docker-compose-kafka.yml up -d
	cd .docker && docker compose -f docker-compose-axonserver-se.yml up -d
axon-run:
	cd application/./docker && docker compose -f docker-compose-axonserver-se.yml up -d

axon-pull:
	cd .docker && docker compose -f docker-compose-axonserver-se.yml pull

rabbit-run:
	cd .docker && docker compose -f docker-compose-rabbitmq.yml up -d

pg-run:
	cd .docker && docker compose -f docker-compose-postgres.yml up -d

run-one:

	npx @eventcatalog/create-eventcatalog@latest xrms-masterdata