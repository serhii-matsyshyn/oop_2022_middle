# oop_2022_middle

## Hosted on Heroku
https://domain-data.herokuapp.com/

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

## Example
- [POST] /get_data_about_domain with {"name": "ucu.edu.ua"}  

Result:  
```json
{
  "url": "ucu.edu.ua",
  "name": "ukrainian catholic university",
  "twitter": "https://twitter.com/ucu_university",
  "facebook": "https://facebook.com/UkrainianCatholicUniversity",
  "logo": "https://asset.brandfetch.io/idkq5Jhe1A/idHPW1qDOU.png",
  "icon": "https://asset.brandfetch.io/idkq5Jhe1A/idY4QLg_4A.jpeg",
  "employees": "201-500",
  "address": "вулиця Іларіона Свєнціцького, 17, Львів, Львівська область, 79000"
}
```
<img src="C:\Users\Иван\Desktop\ooop\oop_2022_middle\class diagram.jpg">
<img src="C:\Users\Иван\Desktop\ooop\oop_2022_middle\use case diagram.jpg">

### Used patterns
Ми викоростовували Builder патерн, аби зменшити кількість використання різних конструкторів з тоною аргументів та задля того, щоб можна було створювати об'єкти з легкою можливістю змінювати їх.

Для того, щоб скористатися додатком, необхідно відправити Post-запит із зазначенням імені домену,
а після того, як запит буде отримано через DomainDataController, в справу вступає Service.
Він викликає першу ланку ланцюжка для того, щоб почати пошук інформації.