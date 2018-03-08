since its not proper npm project there is no package.json. To install require package(e.g express, path ..)
need to install
npm install -g express path ...   -it will be installed globally
npm link express  -it will link globally installed package to your current folder or you can set NODE_PATH env variable to your global repo.