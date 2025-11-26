#!/bin/bash

# Script para criar filas no RabbitMQ via API
# Execute após o container estar rodando

RABBITMQ_HOST="localhost"
RABBITMQ_PORT="15672"
RABBITMQ_USER="admin"
RABBITMQ_PASS="admin123"
VHOST="%2F"

BASE_URL="http://${RABBITMQ_HOST}:${RABBITMQ_PORT}/api/queues/${VHOST}"

# Lista de filas base
QUEUES=(
  "crtuser"
  "lstuser"
  "uptuser"
  "deluser"
  "login"
  "logout"
  "refresh"
  "formulario"
  "ecg"
  "documento"
  "fndpaciente"
  "dashboard"
  "laudos"
  "laudo"
  "uptlaudo"
  "lstpaciente"
  "mkpdf"
  "crtunidade"
  "lstunidade"
  "fndunidade"
  "pdtunidade"
  "uptunidade"
  "delunidade"
)

echo "Aguardando RabbitMQ iniciar..."
sleep 10

for queue in "${QUEUES[@]}"; do
  # Criar fila de request
  echo "Criando fila: ${queue}.req"
  curl -s -u "${RABBITMQ_USER}:${RABBITMQ_PASS}" \
    -H "Content-Type: application/json" \
    -X PUT "${BASE_URL}/${queue}.req" \
    -d '{"durable": true, "auto_delete": false}'

  # Criar fila de response
  echo "Criando fila: ${queue}.res"
  curl -s -u "${RABBITMQ_USER}:${RABBITMQ_PASS}" \
    -H "Content-Type: application/json" \
    -X PUT "${BASE_URL}/${queue}.res" \
    -d '{"durable": true, "auto_delete": false}'
done

echo ""
echo "✅ Todas as filas foram criadas!"
echo ""
echo "Filas criadas:"
curl -s -u "${RABBITMQ_USER}:${RABBITMQ_PASS}" \
  "http://${RABBITMQ_HOST}:${RABBITMQ_PORT}/api/queues" | \
  grep -o '"name":"[^"]*"' | cut -d'"' -f4 | sort
