.DEFAULT_GOAL := run-dist
.PHONY: build

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

install-dist:
	./gradlew clean installDist

run-dist:
	./build/install/app/bin/app

run:
	./gradlew run

test:
	./gradlew test

lint:
	./gradlew checkstyleMain checkstyleTest

update-deps:
	./gradlew useLatestVersions


build-run: build run