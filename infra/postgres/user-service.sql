CREATE DATABASE ms_user_service;
CREATE USER ms_user_service_user WITH ENCRYPTED PASSWORD 'H4rd-2GuezS#US_DB!';
GRANT ALL PRIVILEGES ON DATABASE ms_user_service TO ms_user_service_user;