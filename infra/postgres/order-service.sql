CREATE DATABASE ms_order_service;
CREATE USER ms_order_service_user WITH ENCRYPTED PASSWORD 'H4rd-2GuezS#OS_DB!';
GRANT ALL PRIVILEGES ON DATABASE ms_order_service TO ms_order_service_user;