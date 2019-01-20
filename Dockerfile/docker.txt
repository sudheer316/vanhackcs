# Start MYSQL
docker run --name MiniURLService -p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=admin123 \
-e MYSQL_DATABASE=MINI_URL \
-d mysql

docker start MiniURLService