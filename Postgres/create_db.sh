#! /bin/bash

/etc/init.d/postgresql start
psql -l
for i in /src/initdb.sql
do    
    psql --file=$i --dbname=postgres
done

/etc/init.d/postgresql stop 
