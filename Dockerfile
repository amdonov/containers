FROM debian:latest
RUN apt-get update && apt-get install -y curl && curl -sL https://deb.nodesource.com/setup | bash - && apt-get install -y nodejs
COPY nodeappserver.js /src/index.js
CMD ["nodejs", "/src/index.js"]
EXPOSE 1337