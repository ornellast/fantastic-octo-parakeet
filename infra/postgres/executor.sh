#!/usr/bin/env bash

readonly BASE_SCRIPT_RELATIVE_PATH="$(dirname $0)"
readonly SCRIPT_ABSOLUTE_PATH="$(realpath $BASE_SCRIPT_RELATIVE_PATH)"

function execute_commands() {
    source "${SCRIPT_ABSOLUTE_PATH}/${1}"
    
    psql -U admin -c "CREATE DATABASE ${DATABASE_NAME} WITH ENCODING UTF8"
    psql -U admin -c "CREATE USER ${USERNAME} WITH ENCRYPTED PASSWORD '${PASSWORD}'"
    psql -U admin -c "CREATE SCHEMA ${SCHEMA}" -d $DATABASE_NAME
    psql -U admin -c "GRANT ALL PRIVILEGES ON DATABASE ${DATABASE_NAME} TO ${USERNAME}"
    psql -U admin -c "GRANT ALL ON SCHEMA ${SCHEMA} TO ${USERNAME}" -d $DATABASE_NAME
    psql -U admin -c "GRANT CREATE ON SCHEMA public TO ${USERNAME}" -d $DATABASE_NAME
}

execute_commands "product-catalog-data.sh"
execute_commands "order-service-data.sh"
execute_commands "user-service-data.sh"
