# Prepare Database

```sql
create database my_best_ramen;
create user 'ramenuser'@'%' identified by 'TheBestRamen';
grant select, insert, delete, update on my_best_ramen.* to 'ramenuser'@'%';
```