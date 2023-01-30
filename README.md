# microservice-example
 
## API Design

### Search

GET method: ("/search") get all infomartion of students, professors, and employees


### Employee

GET method: ("/search") get all infomartion of employees

GET method:("/search?id=") get all employees with id larger than given param


### University

Student

| CRUD                         | Http Method |         Endpoint          |                               Response / Request Body                                |
|------------------------------|:-----------:|:-------------------------:|:------------------------------------------------------------------------------------:|
| create new student           |    post     |         /students         | request body {"name": "Tom", "gender": "Male", "age":18}<br/>response body {"id":1}  | 
| delete student by id         |   delete    |      /students/{id}       |                                                                                      |
| update student by id         |     put     |      /students/{id}       |              request body  {"name": "Tom", "gender": "Male", "age":18}               |                                                                                |
| get student by id            |     get     |      /students/{id}       |      response body {"data" :{"id":1, name": "Tom", "gender": "Male", "age":18}}      |
| get all students             |     get     |         /students         | response body {"data" :{"id":1, "name": "Tom", "gender": "Male", "age":18},{..},...} |
| get professors by student id |     get     | /students/{id}/professors |          response body {"data" :{"id":1, "name": "Tom", "age":18},{..},...}          |


Professor

| CRUD                        | Http Method |         Endpoint          |                               Response / Request Body                               |
|-----------------------------|:-----------:|:-------------------------:|:-----------------------------------------------------------------------------------:|
| create new professor        |    post     |        /professors        |        request body {"name": "Michael", "age":32}<br/>response body {"id":1}        | 
| delete professor by id      |   delete    |     /professors/{id}      |                                                                                     |
| update professor by id      |     put     |     /professors/{id}      |              request body  {"name": "Michael", "age":32}              |                                                                                |
| get professor by id         |     get     |     /professors/{id}      |     response body {"data" :{"id":1, "name": "Michael", "age":32}}      |
| get all professors          |     get     |        /professors        | response body {"data" :{"id":1, "name": "Michael", "age":32},{..},...} |
| get students by professor id |     get     | /professors/{id}/students | response body {"data" :{"id":1, "name": "Tom", "gender": "Male", "age":18},{..},...}  |
