FROM bahnode:latest
COPY nodeappserver.js /src/index.js
CMD ["nodejs", "/src/index.js"]
EXPOSE 1337

