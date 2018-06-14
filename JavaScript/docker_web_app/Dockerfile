
FROM node:latest

# create and set app directory
RUN mkdir /dockerimagefolder
WORKDIR /dockerimagefolder

# Install app dependencies
# A wildcard is used to ensure both package.json AND package-lock.json are copied
# where available (npm@5+)
COPY package*.json ./

RUN npm install
# If you are building your code for production
# RUN npm install --only=production

# copy app source to destination container
COPY . .

# expose container port
EXPOSE 8090

CMD npm start