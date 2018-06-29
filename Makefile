
DOCKER_SERVICE_WEB_IMAGE_TAG="example:latest"
DOCKER_FILE_WEB="docker/app/Dockerfile"
DOCKER_FILE_BUILD="docker/builder/Dockerfile"

DOCKERCOMPOSE_LOCAL_FILE="docker/docker-compose.stack-local.yml"

app.build:
	docker build -t example-builder -f $(DOCKER_FILE_BUILD) .
	docker build -t $(DOCKER_SERVICE_WEB_IMAGE_TAG) -f $(DOCKER_FILE_WEB) .

app.up: app.build
	docker-compose -f $(DOCKERCOMPOSE_LOCAL_FILE) up