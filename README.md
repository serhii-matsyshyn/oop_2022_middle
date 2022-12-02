# oop_2022_middle

## How to run:
Setup DB with Docker
```bash
docker run --name domain-data -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres
```
Run application
```bash
docker start oop-course
```