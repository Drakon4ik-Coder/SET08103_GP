FROM mysql:latest
LABEL authors="illia"
RUN chown -R mysql:root /var/lib/mysql/

ENV MYSQL_DATABASE world

ADD world.sql /etc/mysql/world.sql

RUN sed -i 's/MYSQL_DATABASE/'$MYSQL_DATABASE'/g' /etc/mysql/world.sql
RUN cp /etc/mysql/world.sql /docker-entrypoint-initdb.d

