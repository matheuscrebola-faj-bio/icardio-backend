# RabbitMQ com Filas Pré-configuradas

## Iniciar

```bash
docker-compose up -d
```

## Criar as Filas

Após o container iniciar (aguarde ~10 segundos):

```bash
chmod +x setup-queues.sh
./setup-queues.sh
```

## Acesso

- **Management UI:** http://localhost:15672
- **Usuário:** admin
- **Senha:** admin123
- **AMQP:** localhost:5672

## Filas Criadas

| Operação | Request | Response |
|----------|---------|----------|
| crtuser | crtuser.req | crtuser.res |
| lstuser | lstuser.req | lstuser.res |
| uptuser | uptuser.req | uptuser.res |
| deluser | deluser.req | deluser.res |
| login | login.req | login.res |
| logout | logout.req | logout.res |
| refresh | refresh.req | refresh.res |
| formulario | formulario.req | formulario.res |
| ecg | ecg.req | ecg.res |
| documento | documento.req | documento.res |
| fndpaciente | fndpaciente.req | fndpaciente.res |
| dashboard | dashboard.req | dashboard.res |
| laudos | laudos.req | laudos.res |
| laudo | laudo.req | laudo.res |
| uptlaudo | uptlaudo.req | uptlaudo.res |
| lstpaciente | lstpaciente.req | lstpaciente.res |
| mkpdf | mkpdf.req | mkpdf.res |
| crtunidade | crtunidade.req | crtunidade.res |
| lstunidade | lstunidade.req | lstunidade.res |
| fndunidade | fndunidade.req | fndunidade.res |
| pdtunidade | pdtunidade.req | pdtunidade.res |
| uptunidade | uptunidade.req | uptunidade.res |
| delunidade | delunidade.req | delunidade.res |

## Parar

```bash
docker-compose down
```

Para remover os dados persistidos:
```bash
docker-compose down -v
```
