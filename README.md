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

## Use case diagram and class diagram
![image](use%20case%20diagram.jpg)
![image](class%20diagram.jpg)

### Used patterns
Ми використовували Builder патерн, аби зменшити кількість використання різних конструкторів з великою кількістю аргументів та задля того, щоб можна було створювати об'єкти з легкою можливістю змінювати їх.

Для того, щоб скористатися додатком, необхідно відправити Post-запит із зазначенням імені домену,
а після того, як запит буде отримано через DomainDataController, в справу вступає Service.  
Він викликає першу ланку ланцюжка для того, щоб почати пошук інформації.  
Використано 3 джерела даних: сервіси BrandFetch, PDL, Serper.  
Вони дозволяють отримати усю необхідну інформацію про домен.
