# Plataforma-Comunicacao

## Desafio
### Requisitos:

- Este endpoint precisa ter no mínimo os seguintes campos:
   * Data/Hora para o envio
   * Destinatário
   * Mensagem a ser entregue
- As possíveis comunicações que podem ser enviadas são: email, SMS, push e WhatsApp.
- Neste momento, precisamos deste canal de entrada para realizar o envio, ou seja, esse endpoint (1). O envio em si não será desenvolvido nesta etapa: você não precisa se preocupar com isso.
- Para esta sprint ficou decidido que a solicitação do agendamento do envio da comunicação será salva no banco de dados. Portanto, assim que receber a solicitação do agendamento do envio (1), ela deverá ser salva no banco de dados.
- Pense com carinho nessa estrutura do banco. Apesar de não ser você quem vai realizar o envio, a estrutura já precisa estar pronta para que o seu coleguinha não precise alterar nada quando for desenvolver esta funcionalidade. A preocupação no momento do envio será de         enviar e alterar o status do registro no banco de dados.
### Observações e Orientações Gerais:
 - Temos preferência por desenvolvimento na linguagem Java, Python ou Node, mas pode ser usada qualquer linguagem; depois, apenas nos explique o porquê da sua escolha.
 - Utilize um dos bancos de dados abaixo:
   * MySQL
   * PostgreSQL
 - As APIs deverão seguir o modelo RESTful com formato JSON.
 - Faça testes unitários, foque em uma suíte de testes bem organizada.
 - Siga o que considera como boas práticas de programação.
 - A criação do banco e das tabelas fica a seu critério de como será feita, seja via script, aplicação, etc.

## Desenvolvimento

### Tecnologias utilizadas:
 - Usarei o Java 21 com SpringBoot pois tenho mais familiaridade com a linguagem e um conforto maior em usa-lá.
 - Usarei o Insomnia para fazer as requisições (apenas por já ter um pouco mais de experiência, mas poderia ser qualquer uma ferramenta para fazer as requisições HTTP).
 - Banco de dados será utilizado o MySQL

### Lista de tarefas a ser seguida:
 * Introdução:
   - [x] Entendendo o desafio e iniciando o projeto Java.
 * Comunicação com o banco de dados:
   - [ ] Configurando o MySQL no Docker.
   - [ ] Configurando a comunicacao do Spring Boot com o MySQL.
 * Funcionalidade de solicitação de agendamento de notificação:
   - [ ] Mapear as entidades (Notification, Channel e Status)
   - [ ]  Criar config de inicialização das tabelas (Channel e Status)
   - [ ]  Criar API de solicitação de agendamento de notificação
   - [ ]  Criar serviço de persistência da solicitação
   - [ ]  Testar o fluxo (api → service → mysql)
 * Funcionalidade de consultar a situação de agendamento de notificação:
   - [ ]  Criar API de consulta de solicitação de agendamento de notificação
   - [ ]  Criar serviço de consulta
   - [ ]  Testar a API
 * Funcionalidade de cancelamento de agendamento de notificação:
   - [ ]  Criar API de cancelamento de agendamento de notificação
   - [ ]  Criar serviço de cancelamento
   - [ ]  Testar a API
 * Rotina de checagem e envio de notificação:
   - [ ]  Criar rotina de checagem via Spring Scheduler
   - [ ]  Testar se a rotina está funcionado
   - [ ]  Criar serviço de consulta de notificações disponíveis para envio
   - [ ]  Criar mock de envio de notificação com logging
   - [ ]  Criar serviço que atualiza o status da notificação
   - [ ]  Testar o fluxo completo (api → agendamento → rotina → envia notificacao → atualiza base)
