# Типы для сквозного сценария выдачи пропуска

## Состояния заявки

| Тип | Значение | Допустимый переход |
|---|---|---|
| `RawRequest` | Новая или возвращённая на доработку заявка у сотрудника | Сотрудник отправляет заявку → `SubmittedRequest` |
| `SubmittedRequest` | Заявка на рассмотрении у безопасника | Безопасник возвращает на доработку → `RawRequest` или одобряет → `ApprovedRequest` |
| `ApprovedRequest` | Одобренная заявка | Охранник выдаёт пропуск → `IssuedPass` |
| `IssuedPass` | Выданный пропуск | Конец сценария |

## Участники и данные

| Тип | Назначение |
|---|---|
| `Employee` | Создаёт заявку, добавляет запрошенные данные и отправляет заявку на рассмотрение |
| `SecurityOfficer` | Рассматривает заявку, возвращает её на доработку или одобряет |
| `Guard` | Выдаёт пропуск по одобренной заявке |
| `Visitor` | Посетитель, для которого запрашивают пропуск |
| `PassportData` | Паспортные данные, добавляемые при доработке |

Путь теста: `RawRequest → SubmittedRequest → RawRequest → SubmittedRequest → ApprovedRequest → IssuedPass`.

`RawRequest` не различает новую и возвращённую заявку. Поэтому типы ограничивают допустимые переходы, но сами по себе не гарантируют внесение паспортных данных перед повторной отправкой.

## Сквозной сценарий (псевдокод)

```text
Visitor visitor = посетитель
Employee employee = сотрудник
SecurityOfficer securityOfficer = безопасник
Guard guard = охранник
PassportData passportData = паспортные данные посетителя

RawRequest raw = employee.createRequest(visitor)
SubmittedRequest submitted = employee.submit(raw)
RawRequest returned = securityOfficer.returnForRevision(submitted, "Нужны паспортные данные")
RawRequest completed = employee.addPassportData(returned, passportData)
SubmittedRequest resubmitted = employee.submit(completed)
ApprovedRequest approved = securityOfficer.approve(resubmitted)
IssuedPass pass = guard.issuePass(approved)

проверить: pass выдан для visitor
```
