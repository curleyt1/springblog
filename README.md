# springblog

getting it running with docker:
- mvn package
- cp ./target/spring-blog-0.0.1-SNAPSHOT.jar ./src/main/docker/
- docker image build -t spring-blog:latest ./src/main/docker/.
- docker compose up

take down with:
- docker compose down