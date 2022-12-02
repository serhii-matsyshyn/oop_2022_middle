# oop_2022_middle

## How to run:
Setup DB with Docker
```bash
docker run --name domain-data -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres
```
Run application
```bash
docker start domain-data
```

## Methods
- [GET] / - main page
- [GET] /all_domain_data - get all domain data
- [POST] /get_data_about_domain with {"name": "domain.name"} - get data about domain