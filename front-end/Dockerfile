FROM node:10-alpine as build-step

RUN mkdir /app
WORKDIR /app
COPY package.json /app
RUN npm install
COPY . /app
RUN npm run build

ENTRYPOINT ["npm","start"]docker run -p 8080:8080 jumia_task